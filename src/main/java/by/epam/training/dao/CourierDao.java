package by.epam.training.dao;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

/**
 * The interface Courier dao.
 */
public interface CourierDao extends BaseDao<User> {
    /**
     * Select available delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Order> selectAvailableDelivery(User courier) throws DaoException;

    /**
     * Change order status to processing.
     *
     * @param orderId the order id
     * @param courier the courier
     * @throws DaoException the dao exception
     */
    void changeOrderStatusToProcessing(int orderId, User courier) throws DaoException;

    /**
     * Select processing delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Order> selectProcessingDelivery(User courier) throws DaoException;

    /**
     * Change order status to complete.
     *
     * @param orderId the order id
     * @param courier the courier
     * @throws DaoException the dao exception
     */
    void changeOrderStatusToComplete(int orderId, User courier) throws DaoException;

    /**
     * Select complete delivery list.
     *
     * @param courier the courier
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Order> selectCompleteDelivery(User courier) throws DaoException;
}
