package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Order status.
 */
public enum  OrderStatus {
    /**
     * New order status.
     */
    NEW(1),
    /**
     * Processing order status.
     */
    PROCESSING(2),
    /**
     * Done order status.
     */
    DONE(3),
    /**
     * Rated order status.
     */
    RATED(4);

    private int code;

    private static final Map<OrderStatus, Integer> ORDER_STATUS_INTEGER_MAP = new HashMap<>();
    private static final Map<String, OrderStatus> STRING_ORDER_STATUS_MAP = new HashMap<>();

    static {
        for (OrderStatus orderStatus: values()) {
            ORDER_STATUS_INTEGER_MAP.put(orderStatus, orderStatus.getCode());
            STRING_ORDER_STATUS_MAP.put(orderStatus.name(), orderStatus);
        }
    }

    OrderStatus(int code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets code by order status.
     *
     * @param status the status
     * @return the code by order status
     */
    public static Integer getCodeByOrderStatus(OrderStatus status) {
        return ORDER_STATUS_INTEGER_MAP.get(status);
    }

    /**
     * Gets order status by string.
     *
     * @param name the name
     * @return the order status by string
     */
    public static OrderStatus getOrderStatusByString(String name) {
        return STRING_ORDER_STATUS_MAP.get(name.toUpperCase());
    }

}

