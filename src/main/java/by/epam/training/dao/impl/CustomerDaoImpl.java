package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.CustomerDao;
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
 * The type Customer dao.
 */
public class CustomerDaoImpl implements CustomerDao {

    private final ConnectionPool pool;

    /**
     * Instantiates a new Customer dao.
     */
    public CustomerDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public void makeOrder(Order order) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_MAKE_NEW_ORDER);
            preparedStatement.setString(1, order.getSubject());
            preparedStatement.setInt(2, order.getUser().getId());
            preparedStatement.setDouble(3, order.getTotalPrice());
            preparedStatement.setInt(4, order.getDistance());
            preparedStatement.setObject(5, Transport.getCodeByTransport(order.getTransport()));
            preparedStatement.setBoolean(6, order.getRate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> selectActiveDelivery(int userId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_ACTIVE_CUSTOMER_ORDER);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = createCustomerDeliveryFromQueryResult(resultSet);
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
    public List<Order> selectCompleteDelivery(int userId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_COMPLETE_CUSTOMER_ORDER);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = createCustomerDeliveryFromQueryResult(resultSet);
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
    public Order selectCurrentDelivery(int orderId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        Order order = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_CURRENT_CUSTOMER_ORDER);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = createCustomerDeliveryFromQueryResult(resultSet);
            }
            return order;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public double selectCourierRating(String courierLogin) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        double courierCurrentRating = 0;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_GET_USER_RATING);
            preparedStatement.setString(1, courierLogin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                courierCurrentRating = resultSet.getInt(1);
            }
            return courierCurrentRating;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void wrightCourierRating(String courierLogin, double updatedRating) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_WRITE_COURIER_RATING);
            preparedStatement.setDouble(1, updatedRating);
            preparedStatement.setString(2, courierLogin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void changeOrderStatusToRated(int orderId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_UPDATE_ORDER_STATUS_TO_RATED);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private Order createCustomerDeliveryFromQueryResult(ResultSet resultSet) throws SQLException {
        Order order;
        String login = resultSet.getString(3);
        order = new Order(resultSet.getInt(1), resultSet.getString(2), new User(login),
                resultSet.getDouble(4), resultSet.getInt(5), resultSet.getBoolean(6),
                Transport.getTransportByString(resultSet.getString(7)),
                OrderStatus.getOrderStatusByString(resultSet.getString(8)));
        return order;
    }
}
