package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.BaseDao;
import by.epam.training.entity.Role;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.util.SqlRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements BaseDao<User> {
    private final ConnectionPool pool;

    public AdminDaoImpl() {
        pool = ConnectionPool.getInstance();
    }

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

    private User createUserListFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getInt(1), resultSet.getString(2),
                Role.getRoleByString(resultSet.getString(3)),
                Transport.getTransportByString(resultSet.getString(4)),
                resultSet.getDouble(5));
        return user;
    }
}
