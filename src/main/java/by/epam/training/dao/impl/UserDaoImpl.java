package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.UserDao;
import by.epam.training.entity.*;
import by.epam.training.exception.DaoException;
import by.epam.training.dao.SqlRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private final ConnectionPool pool;

    public UserDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public User registerCourier(User user) throws DaoException {
        ProxyConnection connection = pool.takeConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.INSERT_COURIER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, RoleType.getCodeByRole(user.getRole()));
            preparedStatement.setObject(4, Transport.getCodeByTransport(user.getTransport()));
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public User registerCustomer(User user) throws DaoException {
        ProxyConnection connection = pool.takeConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.INSERT_CUSTOMER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, RoleType.getCodeByRole(user.getRole()));
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public User login(String login, String password) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_USER_BY_LOGIN_AND_PASSWORD);
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

    @Override
    public boolean userExists(String login) throws DaoException {
        PreparedStatement preparedStatement = null;
        ProxyConnection connection = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
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

    @Override
    public User findCourierByLogin(String login) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_COURIER_BY_LOGIN);
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

    @Override
    public User findCustomerByLogin(String login) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_CUSTOMER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createCustomerFromQueryResult(resultSet);
            }
            return null;  // TODO Something
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public User updateUserPassword(User user, String newPassword) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            if (userMatches(user.getLogin(), user.getPassword())) {
                preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_PASSWORD);
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.executeUpdate();
                return findCourierByLogin(user.getLogin());
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
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

    private User createUserFromQueryResult(ResultSet resultSet) throws DaoException {
        try {
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    RoleType.getRoleByString(resultSet.getString(4)),
                    Transport.getTransportByString(resultSet.getString(5)),
                    resultSet.getDouble(6));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User createCustomerFromQueryResult(ResultSet resultSet) throws DaoException {
        try {
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    RoleType.getRoleByString(resultSet.getString(4)));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
