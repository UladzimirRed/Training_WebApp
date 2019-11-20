package by.epam.training.service.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    private final ConnectionPool pool;
    private final double TRUCK_PRICE_PER_KM = 2;
    private final double CAR_PRICE_PER_KM = 0.75;
    private final double FOOT_COURIER_PRICE_PER_KM = 0.5;
    private final double EXPRESS_RATE_COEFFICIENT = 1.5;



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
    public Order checkout(Order order) throws ServiceException {
        try {
            return userDao.makeOrder(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Order countTotalCost(Order order) {
        double totalCost = 0;
        switch (order.getTransport()){
            case CAR:
                totalCost = order.getDistance() * CAR_PRICE_PER_KM;
                break;
            case TRUCK:
                totalCost = order.getDistance() * TRUCK_PRICE_PER_KM;
                break;
            case NONE:
                totalCost = order.getDistance() * FOOT_COURIER_PRICE_PER_KM;
                break;
        }
        if (order.getRate()){
            totalCost = totalCost * EXPRESS_RATE_COEFFICIENT;
        }
        double roundedTotalCost = (double) Math.round(totalCost * 100) / 100;
        order.setTotalPrice(roundedTotalCost);
        return order;
    }

    @Override
    public List<Order> showCustomerDelivery(int userId) throws ServiceException {
        try {
            return userDao.selectCurrentDelivery(userId);
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

}
