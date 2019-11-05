package by.epam.training.service.impl;

import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.RoleEnum;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.UserService;


public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public User logIn(String login, String password) throws ServiceException {
        try {
            return userDao.login(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User registration(String login, String password, RoleEnum role) throws ServiceException {
        return null;
    }

    @Override
    public void changePassword(int userId, String newPassword) throws ServiceException {

    }
}
