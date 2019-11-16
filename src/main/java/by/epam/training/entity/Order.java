package by.epam.training.entity;

import java.math.BigDecimal;

public class Order {
    private int order_id;
    private User user;
    private User courier;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private double distance;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCourier() {
        return courier;
    }

    public void setCourier(User courier) {
        this.courier = courier;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (order_id != order.order_id) return false;
        if (Double.compare(order.distance, distance) != 0) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (status != order.status) return false;
        return totalPrice != null ? totalPrice.equals(order.totalPrice) : order.totalPrice == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = order_id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
