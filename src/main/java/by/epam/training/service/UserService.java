package by.epam.training.service;

import by.epam.training.entity.RoleEnum;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

import java.sql.SQLException;

public interface UserService {
    User logIn(String login, String password) throws ServiceException;
    User register(String login, String password, RoleEnum role) throws ServiceException, SQLException;
    User changePassword(String login, String oldPassword, String newPassword) throws ServiceException;
}
