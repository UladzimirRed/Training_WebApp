package by.epam.training.service.impl;

import by.epam.training.dao.impl.CustomerDaoImpl;
import by.epam.training.entity.Order;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.CustomerService;
import by.epam.training.util.ComparatorByOrderId;

import java.util.List;

/**
 * The type Customer service.
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    private final double TRUCK_PRICE_PER_KM = 2;
    private final double CAR_PRICE_PER_KM = 0.75;
    private final double FOOT_COURIER_PRICE_PER_KM = 0.5;
    private final double EXPRESS_RATE_COEFFICIENT = 1.5;

    @Override
    public void checkout(Order order) throws ServiceException {
        try {
            customerDao.makeOrder(order);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Order countTotalCost(Order order) {
        double totalCost = 0;
        switch (order.getTransport()) {
            case CAR:
                totalCost = order.getDistance() * CAR_PRICE_PER_KM;
                break;
            case TRUCK:
                totalCost = order.getDistance() * TRUCK_PRICE_PER_KM;
                break;
            case NONE:
                totalCost = order.getDistance() * FOOT_COURIER_PRICE_PER_KM;
                break;
        }
        if (order.getRate()) {
            totalCost = totalCost * EXPRESS_RATE_COEFFICIENT;
        }
        double roundedTotalCost = (double) Math.round(totalCost * 100) / 100;
        order.setTotalPrice(roundedTotalCost);
        return order;
    }

    @Override
    public List<Order> showActiveDelivery(int userId) throws ServiceException {
        try {
            return customerDao.selectActiveDelivery(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> showCompleteDelivery(int userId) throws ServiceException {
        try {
            return customerDao.selectCompleteDelivery(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Order showCurrentDelivery(int orderId) throws ServiceException {
        try {
            return customerDao.selectCurrentDelivery(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double showCurrentCourierRating(String courierLogin) throws ServiceException {
        try {
            return customerDao.selectCourierRating(courierLogin);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public double updateRating(String courierLogin, double currentRating, double rate) throws ServiceException {
        double updatedRating = (currentRating + rate) / 2;
        try {
            customerDao.wrightCourierRating(courierLogin, updatedRating);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return updatedRating;
    }

    @Override
    public void updateOrderStatusToRated(int orderId) throws ServiceException {
        try {
            customerDao.changeOrderStatusToRated(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> sortListOfOrdersByOrderId(List<Order> orders) {
        orders.sort(new ComparatorByOrderId());
        return orders;
    }
}
