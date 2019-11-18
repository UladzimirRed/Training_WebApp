package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.BaseDao;
import by.epam.training.entity.Order;
import by.epam.training.entity.Role;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.util.SqlRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements BaseDao<User> {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private final ConnectionPool pool;

    public UserDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

    public User register(User user, ProxyConnection connection) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.INSERT_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, Role.getCodeByRole(user.getRole()));
            preparedStatement.setObject(4, Transport.getCodeByTransport(user.getTransport()));
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
        }
    }

    public User login(String login, String password) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_PROFILE_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? createUserFromQueryResult(resultSet) : null;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    public boolean userExists(ProxyConnection connection, String login) throws DaoException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.CHECK_USER_EXISTS);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private User createUserFromQueryResult(ResultSet resultSet) throws DaoException {
        try {
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    Role.getRoleByString(resultSet.getString(4)),
                    Transport.getTransportByString(resultSet.getString(5)),
                    resultSet.getDouble(6));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public User findUserByLogin(ProxyConnection connection, String login) throws DaoException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUserFromQueryResult(resultSet);
            }
            return null;  // TODO Something
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    public User changeUserPassword(User user, String newPassword) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            if (userMatches(user.getLogin(), user.getPassword())) {
                preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_PASSWORD);
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.executeUpdate();
                return findUserByLogin(connection, user.getLogin());
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    public boolean userMatches(String login, String password) throws DaoException {
        PreparedStatement preparedStatement = null;
        ProxyConnection connection = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHECK_USER_MATCHES);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    // TODO add distance and total cost set
    public Order makeOrder(Order order, int userId, int rateCode) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_MAKE_NEW_ORDER);
            preparedStatement.setString(1, order.getSubject());
            preparedStatement.setInt(2, userId);
            preparedStatement.setObject(3, Transport.getCodeByTransport(order.getTransport()));
            preparedStatement.setInt(4, rateCode);
            preparedStatement.executeUpdate();
            return order;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }
}
