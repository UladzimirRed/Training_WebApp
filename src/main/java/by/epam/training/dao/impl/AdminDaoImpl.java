package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.AdminDao;
import by.epam.training.entity.*;
import by.epam.training.exception.DaoException;
import by.epam.training.dao.SqlRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin dao.
 */
public class AdminDaoImpl implements AdminDao {
    private final ConnectionPool pool;

    /**
     * Instantiates a new Admin dao.
     */
    public AdminDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public List<User> selectUserList() throws DaoException {
        PreparedStatement preparedStatement = null;
        ProxyConnection connection = null;
        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_USER_LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = createUserListFromResultSet(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public User selectCurrentUser(int userId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        User user = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_FIND_CURRENT_USER);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = createUserFromQueryResult(resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void updateUserLogin(int userId, String currentLogin) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_LOGIN);
            preparedStatement.setString(1, currentLogin);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void updateUserRole(int userId, int roleId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_ROLE);
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void updateUserTransport(int userId, int transportId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_TRANSPORT);
            preparedStatement.setInt(1, transportId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void updateUserRating(int userId, double rating) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_CHANGE_USER_RATING);
            preparedStatement.setDouble(1, rating);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void resetUserInfo(int userId) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_RESET_USER_TRANSPORT);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SqlRequest.SQL_RESET_USER_RATING);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private User createUserListFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getInt(1), resultSet.getString(2),
                RoleType.getRoleByString(resultSet.getString(3)),
                Transport.getTransportByString(resultSet.getString(4)),
                resultSet.getDouble(5));
        return user;
    }

    private User createUserFromQueryResult(ResultSet resultSet) throws SQLException {
        User user;
        user = new User(resultSet.getInt(1), resultSet.getString(2),
                RoleType.getRoleByString(resultSet.getString(3)),
                Transport.getTransportByString(resultSet.getString(4)),
                resultSet.getDouble(5));
        return user;
    }
}
