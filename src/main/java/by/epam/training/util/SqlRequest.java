package by.epam.training.util;

public class SqlRequest {
    //todo change all profile to user
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT user_id, login, password, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE login = ? AND password = SHA1(?)";
    public static final String CHECK_USER_EXISTS =
            "SELECT user_id FROM user WHERE login = ?";
    public static final String INSERT_USER =
            "INSERT INTO user(login, password, role_id, transport_id) VALUES (?, SHA1(?), ?, ?)";
    public static final String FIND_USER_BY_LOGIN =
            "SELECT user_id, login, password, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE login = ?";
    public static final String SQL_CHECK_USER_MATCHES =
            "SELECT login, password FROM user WHERE login =? AND password = SHA1(?)";
    public static final String SQL_CHANGE_USER_PASSWORD =
            "UPDATE user SET password = SHA1(?) WHERE login = ?";
    public static final String SQL_MAKE_NEW_ORDER =
            "INSERT INTO shipping_order(subject, customer_id, total_price, distance, transport_id, express_rate) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SQL_WRITE_COURIER_RATING =
            "UPDATE user SET rating = ? WHERE login = ?";
    public static final String SQL_GET_USER_RATING =
            "SELECT rating FROM user WHERE login = ?";
    public static final String SQL_FIND_CURRENT_CUSTOMER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.courier_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE order_id = ?";
    public static final String SQL_FIND_ACTIVE_CUSTOMER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.courier_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE customer_id = ? " +
                    "AND order_status_id != 3";
    public static final String SQL_FIND_COMPLETE_CUSTOMER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.courier_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE customer_id = ? " +
                    "AND order_status_id = 3";
    public static final String SQL_FIND_AVAILABLE_COURIER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.customer_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE shipping_order.transport_id = ? " +
                    "AND order_status_id = 1";
    public static final String SQL_UPDATE_ORDER_STATUS_TO_PROCESSING =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '2', courier_id = ? WHERE order_id = ?";
    public static final String SQL_FIND_PROCESSING_COURIER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.customer_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE shipping_order.courier_id = ? " +
                    "AND order_status_id = 2";
    public static final String SQL_UPDATE_ORDER_STATUS_TO_COMPLETE =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '3', courier_id = ? WHERE order_id = ?";
    public static final String SQL_FIND_COMPLETE_COURIER_ORDER =
            "SELECT order_id, subject, login, total_price, distance, express_rate, transport_name, status " +
                    "FROM shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "LEFT JOIN user " +
                    "ON shipping_order.customer_id = user.user_id " +
                    "LEFT JOIN transport " +
                    "ON shipping_order.transport_id = transport.transport_id " +
                    "WHERE shipping_order.courier_id = ? " +
                    "AND order_status_id = 3";
    public static final String SQL_UPDATE_ORDER_STATUS_TO_RATED =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '4' WHERE order_id = ?";
}
