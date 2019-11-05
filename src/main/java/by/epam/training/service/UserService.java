package by.epam.training.service;

import by.epam.training.entity.RoleEnum;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

public interface UserService {
    User logIn(String login, String password) throws ServiceException;
    User registration(String login, String password, RoleEnum role) throws ServiceException;
    void changePassword(int userId, String newPassword) throws ServiceException;
}
