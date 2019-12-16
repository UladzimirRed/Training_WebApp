package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.CourierDao;
import by.epam.training.entity.Order;
import by.epam.training.entity.OrderStatus;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.dao.SqlRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Courier dao.
 */
public class CourierDaoImpl implements CourierDao {

    private final ConnectionPool pool;

    /**
     * Instantiates a new Courier dao.
     */
    public CourierDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public List<Order> selectAvailableDelivery(User courier) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_AVAILABLE_COURIER_ORDER);
            preparedStatement.setInt(1, Transport.getCodeByTransport(courier.getTransport()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = createCourierDeliveryFromQueryResult(resultSet);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void changeOrderStatusToProcessing(int orderId, User courier) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_UPDATE_ORDER_STATUS_TO_PROCESSING);
            preparedStatement.setInt(1, courier.getId());
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> selectProcessingDelivery(User courier) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_PROCESSING_COURIER_ORDER);
            preparedStatement.setInt(1, courier.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = createCourierDeliveryFromQueryResult(resultSet);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void changeOrderStatusToComplete(int orderId, User courier) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_UPDATE_ORDER_STATUS_TO_COMPLETE);
            preparedStatement.setInt(1, courier.getId());
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> selectCompleteDelivery(User courier) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_COMPLETE_COURIER_ORDER);
            preparedStatement.setInt(1, courier.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = createCourierDeliveryFromQueryResult(resultSet);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private Order createCourierDeliveryFromQueryResult(ResultSet resultSet) throws SQLException {
        User user = new User();
        Order order;
        user.setLogin(resultSet.getString(3));
        String userLogin = user.getLogin();
        order = new Order(resultSet.getInt(1), resultSet.getString(2), new User(userLogin),
                resultSet.getDouble(4), resultSet.getInt(5), resultSet.getBoolean(6),
                Transport.getTransportByString(resultSet.getString(7)),
                OrderStatus.getOrderStatusByString(resultSet.getString(8)));
        return order;
    }
}
