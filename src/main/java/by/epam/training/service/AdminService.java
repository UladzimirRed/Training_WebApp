package by.epam.training.service;

import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;

import java.util.List;

/**
 * The interface Admin service.
 */
public interface AdminService {
    /**
     * Show user list list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<User> showUserList() throws ServiceException;

    /**
     * Show current user user.
     *
     * @param userId the user id
     * @return the user
     * @throws ServiceException the service exception
     */
    User showCurrentUser(int userId) throws ServiceException;

    /**
     * Change user login.
     *
     * @param userId       the user id
     * @param currentLogin the current login
     * @throws ServiceException    the service exception
     * @throws UserExistsException the user exists exception
     */
    void changeUserLogin(int userId, String currentLogin) throws ServiceException, UserExistsException;

    /**
     * Change user role.
     *
     * @param userId the user id
     * @param role   the role
     * @throws ServiceException the service exception
     */
    void changeUserRole(int userId, RoleType role) throws ServiceException;

    /**
     * Change user transport.
     *
     * @param userId    the user id
     * @param transport the transport
     * @throws ServiceException the service exception
     */
    void changeUserTransport(int userId, Transport transport) throws ServiceException;

    /**
     * Change user rating.
     *
     * @param userId the user id
     * @param rating the rating
     * @throws ServiceException the service exception
     */
    void changeUserRating(int userId, double rating) throws ServiceException;
}
