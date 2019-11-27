package by.epam.training.util;

import by.epam.training.entity.Order;

import java.util.Comparator;

public class ComparatorByOrderId implements Comparator<Order> {
    @Override
    public int compare(Order first, Order second) {
        return first.getOrderId() - second.getOrderId();
    }
}
