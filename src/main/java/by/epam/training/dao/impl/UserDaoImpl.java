package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.BaseDao;
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

    public User register(User user) throws DaoException{
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = pool.takeConnection();
            String login = user.getLogin();
            String password = user.getPassword();
            int role = user.getRole();
            //TODO CHECK FOR LOGIN AND PASS ALREADY EXIST
            preparedStatement = connection.prepareStatement(SqlRequest.INSERT_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2,password);
            preparedStatement.setInt(3, role);
            preparedStatement.executeUpdate();
            return findUserByLogin(connection, login);
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }
    public User login(String login, String password) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_PROFILE_BY_LOGIN);
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
                    resultSet.getInt(4));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User findUserByLogin(ProxyConnection connection, String login) throws DaoException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(SqlRequest.FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
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
}
