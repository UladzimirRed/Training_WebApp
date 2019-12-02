package by.epam.training.service;

import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;

import java.util.List;

public interface AdminService {
    List<User> showUserList() throws ServiceException;
    User showCurrentUser(int userId) throws ServiceException;
    void changeUserLogin(int userId, String currentLogin) throws ServiceException, UserExistsException;
    void changeUserRole(int userId, RoleType role) throws ServiceException;
    void changeUserTransport(int userId, Transport transport) throws ServiceException;
    void changeUserRating(int userId, double rating) throws ServiceException;
}
