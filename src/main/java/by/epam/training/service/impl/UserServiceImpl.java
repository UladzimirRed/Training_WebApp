package by.epam.training.service.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.Order;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
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
    public User register(User user) throws ServiceException, UserExistsException {

        ProxyConnection connection = pool.takeConnection();

        try {
            if (userDao.userExists(connection, user.getLogin())) {
                throw new UserExistsException("User with this login already exists");
            }
            userDao.register(user, connection);
            return userDao.findUserByLogin(connection, user.getLogin());
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    @Override
    public User changePassword(String login, String oldPassword, String newPassword) throws ServiceException {
        User user = new User(login, oldPassword);
        try {
            return userDao.changeUserPassword(user, newPassword);
        } catch (DaoException e){
            throw new ServiceException(e);
        }

    }

    @Override
    //TODO locale_RU doesn't work..
    public Order checkout(Order order, int userId) throws ServiceException {
        int rateCode;
        if (order.getRate().equals("Express") || order.getRate().equals("Экспресс")){
            rateCode = 1;
        } else {
            rateCode = 0;
        }
        try {
            return userDao.makeOrder(order, userId, rateCode);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
