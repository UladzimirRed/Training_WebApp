package by.epam.training.service.impl;

import by.epam.training.dao.impl.AdminDaoImpl;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDaoImpl adminDao = new AdminDaoImpl();
    @Override
    public List<User> showUserList() throws ServiceException {
        try {
            return adminDao.selectUserList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
