package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;

import java.util.List;

/**
 * The interface Courier service.
 */
public interface CourierService {
    /**
     * Show available delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Order> showAvailableDelivery(User courier) throws ServiceException;

    /**
     * Update order status to processing.
     *
     * @param orderId the order id
     * @param courier the courier
     * @throws ServiceException the service exception
     */
    void updateOrderStatusToProcessing(int orderId, User courier) throws ServiceException;

    /**
     * Show processing delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Order> showProcessingDelivery(User courier) throws ServiceException;

    /**
     * Update order status to complete.
     *
     * @param orderId the order id
     * @param courier the courier
     * @throws ServiceException the service exception
     */
    void updateOrderStatusToComplete(int orderId, User courier) throws ServiceException;

    /**
     * Show complete delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Order> showCompleteDelivery(User courier) throws ServiceException;

    /**
     * Sort list of orders by order id list.
     *
     * @param orders the orders
     * @return the list
     */
    List<Order> sortListOfOrdersByOrderId(List<Order> orders);
}
