package by.epam.training.dao;

import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

/**
 * The interface User dao.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * Register courier.
     *
     * @param user the user
     * @throws DaoException the dao exception
     */
    void registerCourier(User user) throws DaoException;

    /**
     * Register customer.
     *
     * @param user the user
     * @throws DaoException the dao exception
     */
    void registerCustomer(User user) throws DaoException;

    /**
     * Login user.
     *
     * @param login    the login
     * @param password the password
     * @return the user
     * @throws DaoException the dao exception
     */
    User login(String login, String password) throws DaoException;

    /**
     * User exists boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean userExists(String login) throws DaoException;

    /**
     * Find courier by login user.
     *
     * @param login the login
     * @return the user
     * @throws DaoException the dao exception
     */
    User findCourierByLogin(String login) throws DaoException;

    /**
     * Find customer by login user.
     *
     * @param login the login
     * @return the user
     * @throws DaoException the dao exception
     */
    User findCustomerByLogin(String login) throws DaoException;

    /**
     * Update user password user.
     *
     * @param user        the user
     * @param newPassword the new password
     * @return the user
     * @throws DaoException the dao exception
     */
    User updateUserPassword(User user, String newPassword) throws DaoException;

    /**
     * User matches boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean userMatches(String login, String password) throws DaoException;
}
