package by.epam.training.entity;

import java.math.BigDecimal;

public class Order {
    private int order_id;
    private String subject;
    private User user;
    private User courier;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private Transport transport;
    private String rate;
    private int distance;


    public Order(String subject, User user, Transport transport, String rate, int distance) {
        this.subject = subject;
        this.user = user;
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    public Order(String subject, Transport transport, String rate, int distance) {
        this.subject = subject;
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    public Order(int order_id, String subject, User courier, OrderStatus status, BigDecimal totalPrice) {
        this.order_id = order_id;
        this.subject = subject;
        this.courier = courier;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public Order(Transport transport, String rate, int distance) {
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (order_id != order.order_id) return false;
        if (distance != order.distance) return false;
        if (subject != null ? !subject.equals(order.subject) : order.subject != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (status != order.status) return false;
        if (totalPrice != null ? !totalPrice.equals(order.totalPrice) : order.totalPrice != null) return false;
        if (transport != order.transport) return false;
        return rate != null ? rate.equals(order.rate) : order.rate == null;
    }

    @Override
    public int hashCode() {
        int result = order_id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + distance;
        return result;
    }
}
