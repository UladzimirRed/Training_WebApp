package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;

import java.sql.SQLException;

public interface UserService {
    User logIn(String login, String password) throws ServiceException;
    User register(User user) throws ServiceException, SQLException, UserExistsException;
    User changePassword(String login, String oldPassword, String newPassword) throws ServiceException;
    Order checkout(Order order) throws ServiceException;
    Order countTotalCost(Order order) throws ServiceException;
    Order showCustomerDelivery(int userId) throws ServiceException;
}
