package by.epam.training.service.impl;

import by.epam.training.dao.impl.AdminDaoImpl;
import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDaoImpl adminDao = new AdminDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List<User> showUserList() throws ServiceException {
        try {
            return adminDao.selectUserList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User showCurrentUser(int userId) throws ServiceException {
        try {
            return adminDao.selectCurrentUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeUserLogin(int userId, String currentLogin) throws ServiceException, UserExistsException {
        try {
            if (!userDao.userExists(currentLogin)) {
                adminDao.updateUserLogin(userId, currentLogin);
            } else {
                throw new UserExistsException("User with this login already exists");
                // FIXME: 02.12.2019 CAN I USE TWO DIFFERENT DAO IN ADMIN SERVICE?
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeUserRole(int userId, RoleType role) throws ServiceException {
        int roleId = RoleType.getCodeByRole(role);
        try {
            adminDao.updateUserRole(userId, roleId);
            if (!role.equals(RoleType.COURIER)) {
                adminDao.resetUserInfo(userId);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeUserTransport(int userId, Transport transport) throws ServiceException {
        int transportId = Transport.getCodeByTransport(transport);
        try {
            adminDao.updateUserTransport(userId, transportId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeUserRating(int userId, double rating) throws ServiceException {
        try {
            adminDao.updateUserRating(userId, rating);
        } catch (DaoException e) {
            throw new ServiceException(e);

        }
    }
}
