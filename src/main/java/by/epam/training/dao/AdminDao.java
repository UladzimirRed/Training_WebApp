package by.epam.training.dao;

import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

public interface AdminDao extends BaseDao<User> {
    List<User> selectUserList() throws DaoException;
    User selectCurrentUser(int userId) throws DaoException;
    void changeUserInfo(int userId, String login, RoleType role, Transport transport, double rating);
}
