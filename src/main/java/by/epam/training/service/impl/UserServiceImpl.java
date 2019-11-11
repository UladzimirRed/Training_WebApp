package by.epam.training.service.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.RoleEnum;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.UserService;

import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    private final ConnectionPool pool;

    public UserServiceImpl() {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public User logIn(String login, String password) throws ServiceException {
        try {
            return userDao.login(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User register(String login, String password, RoleEnum role) throws ServiceException {
        User user = new User(login, password, role);
        ProxyConnection connection = pool.takeConnection();

        try {
            connection.setAutoCommit(false);
            if (userDao.userExists(connection, login)) {
                return null;
            }
            User result = userDao.register(user, connection);
            connection.commit();
            return result;
        } catch (DaoException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new ServiceException(e);
            }
            throw new ServiceException(e);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void changePassword(int userId, String newPassword) throws ServiceException {

    }
}
