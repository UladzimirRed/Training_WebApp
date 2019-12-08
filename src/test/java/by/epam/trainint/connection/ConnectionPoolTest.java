package by.epam.trainint.connection;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.exception.ConnectionPoolException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ConnectionPoolTest {
    private static ConnectionPool pool = ConnectionPool.getInstance();
    private ProxyConnection connection;

    @Test
    public void initConnectionPool() {
        Assert.assertNotNull(pool);
    }

    @Test
    public void takeConnection() {
        connection = pool.takeConnection();
        int freeConnectionsSize = pool.getFreeConnectionsSize();
        Assert.assertEquals(15, freeConnectionsSize);
    }

    @Test
    public void releaseConnection() {
        pool.releaseConnection(connection);
        int freeConnectionsSize = pool.getFreeConnectionsSize();
        Assert.assertEquals(16, freeConnectionsSize);
    }

    @AfterClass
    public void destroyPool() {
        pool.destroyPool();
    }
}
