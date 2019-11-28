package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.exception.ServiceException;

import java.util.List;

public interface CustomerService {
    void checkout(Order order) throws ServiceException;

    Order countTotalCost(Order order) throws ServiceException;

    List<Order> showActiveDelivery(int userId) throws ServiceException;

    List<Order> showCompleteDelivery(int userId) throws ServiceException;

    List<Order> sortListOfOrdersByOrderId(List<Order> orders);

    Order showCurrentDelivery(int orderId) throws ServiceException;

    double showCurrentCourierRating(String courierLogin) throws ServiceException;

    double updateRating(String courierLogin, double currentRating, double rate) throws ServiceException;

    void updateOrderStatusToRated(int orderId) throws ServiceException;
}
