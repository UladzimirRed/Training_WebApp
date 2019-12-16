package by.epam.training.service;

import by.epam.training.entity.Order;
import by.epam.training.exception.ServiceException;

import java.util.List;

/**
 * The interface Customer service.
 */
public interface CustomerService {
    /**
     * Checkout.
     *
     * @param order the order
     * @throws ServiceException the service exception
     */
    void checkout(Order order) throws ServiceException;

    /**
     * Count total cost order.
     *
     * @param order the order
     * @return the order
     * @throws ServiceException the service exception
     */
    Order countTotalCost(Order order) throws ServiceException;

    /**
     * Show active delivery list.
     *
     * @param userId the user id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Order> showActiveDelivery(int userId) throws ServiceException;

    /**
     * Show complete delivery list.
     *
     * @param userId the user id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Order> showCompleteDelivery(int userId) throws ServiceException;

    /**
     * Sort list of orders by order id list.
     *
     * @param orders the orders
     * @return the list
     */
    List<Order> sortListOfOrdersByOrderId(List<Order> orders);

    /**
     * Show current delivery order.
     *
     * @param orderId the order id
     * @return the order
     * @throws ServiceException the service exception
     */
    Order showCurrentDelivery(int orderId) throws ServiceException;

    /**
     * Show current courier rating double.
     *
     * @param courierLogin the courier login
     * @return the double
     * @throws ServiceException the service exception
     */
    double showCurrentCourierRating(String courierLogin) throws ServiceException;

    /**
     * Update rating double.
     *
     * @param courierLogin  the courier login
     * @param currentRating the current rating
     * @param rate          the rate
     * @return the double
     * @throws ServiceException the service exception
     */
    double updateRating(String courierLogin, double currentRating, double rate) throws ServiceException;

    /**
     * Update order status to rated.
     *
     * @param orderId the order id
     * @throws ServiceException the service exception
     */
    void updateOrderStatusToRated(int orderId) throws ServiceException;
}
