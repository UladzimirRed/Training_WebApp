package by.epam.training.entity;

/**
 * The type Order.
 */
public class Order {
    private int orderId;
    private String subject;
    private User user;
    private User courier;
    private OrderStatus status;
    private double totalPrice;
    private Transport transport;
    private boolean rate;
    private int distance;


    /**
     * Instantiates a new Order.
     *
     * @param subject   the subject
     * @param user      the user
     * @param transport the transport
     * @param rate      the rate
     * @param distance  the distance
     */
    public Order(String subject, User user, Transport transport, boolean rate, int distance) {
        this.subject = subject;
        this.user = user;
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    /**
     * Instantiates a new Order.
     *
     * @param subject   the subject
     * @param transport the transport
     * @param rate      the rate
     * @param distance  the distance
     */
    public Order(String subject, Transport transport, boolean rate, int distance) {
        this.subject = subject;
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    /**
     * Instantiates a new Order.
     *
     * @param orderId    the order id
     * @param subject    the subject
     * @param courier    the courier
     * @param status     the status
     * @param totalPrice the total price
     */
    public Order(int orderId, String subject, User courier, OrderStatus status, double totalPrice) {
        this.orderId = orderId;
        this.subject = subject;
        this.courier = courier;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    /**
     * Instantiates a new Order.
     *
     * @param transport the transport
     * @param rate      the rate
     * @param distance  the distance
     */
    public Order(Transport transport, boolean rate, int distance) {
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    /**
     * Instantiates a new Order.
     *
     * @param orderId    the order id
     * @param subject    the subject
     * @param user       the user
     * @param totalPrice the total price
     * @param distance   the distance
     * @param rate       the rate
     * @param transport  the transport
     * @param status     the status
     */
    public Order(int orderId, String subject, User user, double totalPrice, int distance, boolean rate, Transport transport, OrderStatus status) {
        this.orderId = orderId;
        this.subject = subject;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
        this.transport = transport;
        this.rate = rate;
        this.distance = distance;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets courier.
     *
     * @return the courier
     */
    public User getCourier() {
        return courier;
    }

    /**
     * Sets courier.
     *
     * @param courier the courier
     */
    public void setCourier(User courier) {
        this.courier = courier;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets transport.
     *
     * @return the transport
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets transport.
     *
     * @param transport the transport
     */
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public boolean getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(boolean rate) {
        this.rate = rate;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (Double.compare(order.totalPrice, totalPrice) != 0) return false;
        if (rate != order.rate) return false;
        if (distance != order.distance) return false;
        if (subject != null ? !subject.equals(order.subject) : order.subject != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (status != order.status) return false;
        return transport == order.transport;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (rate ? 1 : 0);
        result = 31 * result + distance;
        return result;
    }
}
