package by.epam.training.dao;

import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

/**
 * The interface Admin dao.
 */
public interface AdminDao extends BaseDao<User> {
    /**
     * Select user list list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> selectUserList() throws DaoException;

    /**
     * Select current user user.
     *
     * @param userId the user id
     * @return the user
     * @throws DaoException the dao exception
     */
    User selectCurrentUser(int userId) throws DaoException;

    /**
     * Update user login.
     *
     * @param userId       the user id
     * @param currentLogin the current login
     * @throws DaoException the dao exception
     */
    void updateUserLogin(int userId, String currentLogin) throws DaoException;

    /**
     * Update user role.
     *
     * @param userId the user id
     * @param roleId the role id
     * @throws DaoException the dao exception
     */
    void updateUserRole(int userId, int roleId) throws DaoException;

    /**
     * Update user transport.
     *
     * @param userId      the user id
     * @param transportId the transport id
     * @throws DaoException the dao exception
     */
    void updateUserTransport(int userId, int transportId) throws DaoException;

    /**
     * Update user rating.
     *
     * @param userId the user id
     * @param rating the rating
     * @throws DaoException the dao exception
     */
    void updateUserRating(int userId, double rating) throws DaoException;

    /**
     * Reset user info.
     *
     * @param userId the user id
     * @throws DaoException the dao exception
     */
    void resetUserInfo(int userId) throws DaoException;
}
