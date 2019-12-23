package by.epam.training.connection;

import by.epam.training.exception.ConnectionPoolException;
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

/**
 * The type Connection pool.
 */
public class ConnectionPool {
    private static Logger logger = LogManager.getLogger();
    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;
    private final static int DEFAULT_POOL_CAPACITY = 16;
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static ReentrantLock lock = new ReentrantLock();
    private static String url;
    private static String user;
    private static String password;

    private ConnectionPool() {
        registerDriver();
        initDatabase();
        initPool();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
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

    private void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.ERROR, e);
            throw new RuntimeException("Driver is not register", e);
        }
    }

    /**
     * Gets free connections size.
     *
     * @return the free connections size
     */
    public int getFreeConnectionsSize() {
        return freeConnections.size();
    }

    private void initDatabase() {
        url = DataBaseInfo.URL;
        password = DataBaseInfo.PASSWORD;
        user = DataBaseInfo.USER;
    }

    private void initPool() {
        freeConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_CAPACITY);
        givenAwayConnections = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_CAPACITY; i++) {
            try {
                createConnection();
            } catch (ConnectionPoolException e) {
                logger.log(Level.ERROR, e);
            }
        }
        if (freeConnections.isEmpty()) {
            logger.log(Level.ERROR, "Couldn't init connection pool");
            throw new RuntimeException("Couldn't init connection pool");
        }
        if (freeConnections.size() == DEFAULT_POOL_CAPACITY) {
            logger.log(Level.INFO, "Successfully initialized connection pool");
        }
    }

    private void createConnection() throws ConnectionPoolException {
        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(url, user, password));
            freeConnections.add(connection);
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
            throw new ConnectionPoolException("Couldn't create connection", e);
        }
    }

    /**
     * Take connection proxy connection.
     *
     * @return the proxy connection
     */
    public ProxyConnection takeConnection() {
        ProxyConnection connection;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e);
            throw new RuntimeException("Couldn't take connection", e);
        }
        return connection;
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     */
    public void releaseConnection(ProxyConnection connection) {
        givenAwayConnections.remove(connection);
        freeConnections.offer(connection);
    }

    /**
     * Destroy pool.
     */
    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_CAPACITY; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException | SQLException e) {
                logger.log(Level.ERROR, "Couldn't destroy pool");
            }
            deregisterDrivers();
        }
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Couldn't deregister driver");
            }
        });
    }
}
