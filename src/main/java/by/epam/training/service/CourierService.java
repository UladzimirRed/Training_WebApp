package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

import java.util.List;

public interface CourierService{
    List<Order> showAvailableDelivery(User courier) throws ServiceException;
    void updateOrderStatus(int orderId, User courier) throws ServiceException;
    List<Order> showProcessingDelivery(User courier) throws ServiceException;
}
