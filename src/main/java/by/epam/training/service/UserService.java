package by.epam.training.service;

import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;

import java.sql.SQLException;


/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Log in user.
     *
     * @param login    the login
     * @param password the password
     * @return the user
     * @throws ServiceException the service exception
     */
    User logIn(String login, String password) throws ServiceException;

    /**
     * Register user.
     *
     * @param user the user
     * @return the user
     * @throws ServiceException    the service exception
     * @throws SQLException        the sql exception
     * @throws UserExistsException the user exists exception
     */
    User register(User user) throws ServiceException, SQLException, UserExistsException;

    /**
     * Change password user.
     *
     * @param login       the login
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the user
     * @throws ServiceException the service exception
     */
    User changePassword(String login, String oldPassword, String newPassword) throws ServiceException;
}
