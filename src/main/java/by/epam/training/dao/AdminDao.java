package by.epam.training.dao;

import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

public interface AdminDao extends BaseDao<User> {
    List<User> selectUserList() throws DaoException;
    User selectCurrentUser(int userId) throws DaoException;
    void updateUserLogin(int userId, String currentLogin) throws DaoException;
    void updateUserRole(int userId, int roleId) throws DaoException;
    void updateUserTransport(int userId, int transportId) throws DaoException;
    void updateUserRating(int userId, double rating) throws DaoException;
    void resetUserInfo(int userId) throws DaoException;
}
