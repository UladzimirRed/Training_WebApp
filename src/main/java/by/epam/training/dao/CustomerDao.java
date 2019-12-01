package by.epam.training.dao;

import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

public interface CustomerDao extends BaseDao<User> {
    void makeOrder(Order order) throws DaoException;
    List<Order> selectActiveDelivery(int userId) throws DaoException;
    List<Order> selectCompleteDelivery(int userId) throws DaoException;
    Order selectCurrentDelivery(int orderId) throws DaoException;
    double selectCourierRating(String courierLogin) throws DaoException;
    void wrightCourierRating (String courierLogin, double updatedRating) throws DaoException;
    void changeOrderStatusToRated(int orderId) throws DaoException;
}
