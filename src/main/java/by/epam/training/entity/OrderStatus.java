package by.epam.training.entity;

import java.util.HashMap;
import java.util.Map;

public enum  OrderStatus {
    NEW(1),
    PROCESSING(2),
    DONE(3);

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

    public int getCode() {
        return code;
    }

    public static Integer getCodeByOrderStatus(OrderStatus roleEnum) {
        return ORDER_STATUS_INTEGER_MAP.get(roleEnum);
    }


    public static OrderStatus getOrderStatusByString(String name) {
        return STRING_ORDER_STATUS_MAP.get(name.toUpperCase());
    }

}

