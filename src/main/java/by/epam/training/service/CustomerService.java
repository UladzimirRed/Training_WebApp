package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.exception.ServiceException;

import java.util.List;

public interface CustomerService {
    void checkout(Order order) throws ServiceException;
    Order countTotalCost(Order order) throws ServiceException;
    List<Order> showCustomerDelivery(int userId) throws ServiceException;
}
