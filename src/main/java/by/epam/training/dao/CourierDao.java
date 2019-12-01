package by.epam.training.dao;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

public interface CourierDao extends BaseDao<User>{
    List<Order> selectAvailableDelivery(User courier) throws DaoException;
    void changeOrderStatusToProcessing(int orderId, User courier) throws DaoException;
    List<Order> selectProcessingDelivery(User courier) throws DaoException;
    void changeOrderStatusToComplete(int orderId, User courier) throws DaoException;
    List<Order> selectCompleteDelivery(User courier) throws DaoException;
}
