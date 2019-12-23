package by.epam.training.dao;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

/**
 * The interface Customer dao.
 */
public interface CustomerDao extends BaseDao<User> {
    /**
     * Make order.
     *
     * @param order the order
     * @throws DaoException the dao exception
     */
    void makeOrder(Order order) throws DaoException;

    /**
     * Select active delivery list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Order> selectActiveDelivery(int userId) throws DaoException;

    /**
     * Select complete delivery list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Order> selectCompleteDelivery(int userId) throws DaoException;

    /**
     * Select current delivery order.
     *
     * @param orderId the order id
     * @return the order
     * @throws DaoException the dao exception
     */
    Order selectCurrentDelivery(int orderId) throws DaoException;

    /**
     * Select courier rating double.
     *
     * @param courierLogin the courier login
     * @return the double
     * @throws DaoException the dao exception
     */
    double selectCourierRating(String courierLogin) throws DaoException;

    /**
     * Wright courier rating.
     *
     * @param courierLogin  the courier login
     * @param updatedRating the updated rating
     * @throws DaoException the dao exception
     */
    void wrightCourierRating(String courierLogin, double updatedRating) throws DaoException;

    /**
     * Change order status to rated.
     *
     * @param orderId the order id
     * @throws DaoException the dao exception
     */
    void changeOrderStatusToRated(int orderId) throws DaoException;
}
