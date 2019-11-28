package by.epam.training.service;

import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

import java.util.List;

public interface AdminService {
    List<User> showUserList() throws ServiceException;
}
