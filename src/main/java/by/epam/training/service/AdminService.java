package by.epam.training.service;

import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

import java.util.List;

public interface AdminService {
    List<User> showUserList() throws ServiceException;
    User showCurrentUser(int userId) throws ServiceException;
    void updateUserInfo(int userId, String login, RoleType role, Transport transport, double rating);
}
