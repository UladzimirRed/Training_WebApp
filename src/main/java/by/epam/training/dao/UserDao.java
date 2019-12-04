package by.epam.training.dao;

import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

public interface UserDao extends BaseDao<User> {
    void registerCourier(User user) throws DaoException;
    void registerCustomer(User user) throws DaoException;
    User login(String login, String password) throws DaoException;
    boolean userExists(String login) throws DaoException;
    User findCourierByLogin(String login) throws DaoException;
    User findCustomerByLogin(String login) throws DaoException;
    User updateUserPassword(User user, String newPassword) throws DaoException;
    boolean userMatches(String login, String password) throws DaoException;
}
