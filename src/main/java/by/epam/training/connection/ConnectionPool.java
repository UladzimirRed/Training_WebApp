package by.epam.training.connection;

import by.epam.training.exception.ConnectionPoolException;
import by.epam.training.util.DataBaseInfo;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger();
    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;
    private final static int DEFAULT_POOL_SIZE = 16;
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static ReentrantLock lock = new ReentrantLock();
    private static String url;
    private static String user;
    private static String password;

    private ConnectionPool() {
        register();
        initDatabase();
        initPool();
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private void register() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.fatal("Couldn't register driver" + e);
//            throw new RuntimeException("Couldn't register driver", e);
        }
    }

    private void initDatabase() {
        url = DataBaseInfo.URL;
        password = DataBaseInfo.PASSWORD;
        user = DataBaseInfo.USER;
    }

    private void initPool() {
        freeConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                createConnection();
            } catch (ConnectionPoolException e) {
                logger.log(Level.ERROR, e);
            }
        }
        if (freeConnections.isEmpty()) {
            logger.log(Level.FATAL, "Couldn't init connection pool");
            throw new RuntimeException("Couldn't init connection pool");
        }
        if (freeConnections.size() == DEFAULT_POOL_SIZE) {
            logger.log(Level.INFO, "Successfully initialized connection pool");
        }

    }

    private void createConnection() throws ConnectionPoolException {
        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(url, user, password));
            freeConnections.add(connection);
        } catch (SQLException e) {
            throw new ConnectionPoolException("Couldn't create connection", e);
        }
    }

    public ProxyConnection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(ProxyConnection connection) {
        givenAwayConnections.remove(connection);  //TODO CHECK AUTOCOMMIT
        freeConnections.offer(connection);
    }

    public void destroyPool() throws ConnectionPoolException {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deregisterDrivers();
        }
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Couldn't deregister driver", e);
            }
        });


    }
}
