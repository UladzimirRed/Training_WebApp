package by.epam.training.dao;

/**
 * The type Sql request.
 */
public class SqlRequest {
    /**
     * The constant FIND_USER_BY_LOGIN_AND_PASSWORD.
     */
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT user_id, login, password, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE login = ? AND password = SHA1(?)";
    /**
     * The constant CHECK_USER_EXISTS.
     */
    public static final String CHECK_USER_EXISTS =
            "SELECT user_id FROM user WHERE login = ?";
    /**
     * The constant INSERT_CUSTOMER.
     */
    public static final String INSERT_CUSTOMER =
            "INSERT INTO user(login, password, role_id) VALUES (?, SHA1(?), ?)";
    /**
     * The constant INSERT_COURIER.
     */
    public static final String INSERT_COURIER =
            "INSERT INTO user(login, password, role_id, transport_id) VALUES (?, SHA1(?), ?, ?)";
    /**
     * The constant FIND_COURIER_BY_LOGIN.
     */
    public static final String FIND_COURIER_BY_LOGIN =
            "SELECT user_id, login, password, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE login = ?";
    /**
     * The constant FIND_CUSTOMER_BY_LOGIN.
     */
    public static final String FIND_CUSTOMER_BY_LOGIN =
            "SELECT user_id, login, password, role_name " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "WHERE login = ?";
    /**
     * The constant SQL_CHECK_USER_MATCHES.
     */
    public static final String SQL_CHECK_USER_MATCHES =
            "SELECT login, password FROM user WHERE login =? AND password = SHA1(?)";
    /**
     * The constant SQL_CHANGE_USER_PASSWORD.
     */
    public static final String SQL_CHANGE_USER_PASSWORD =
            "UPDATE user SET password = SHA1(?) WHERE login = ?";
    /**
     * The constant SQL_MAKE_NEW_ORDER.
     */
    public static final String SQL_MAKE_NEW_ORDER =
            "INSERT INTO shipping_order(subject, customer_id, total_price, distance, transport_id, express_rate) VALUES (?, ?, ?, ?, ?, ?)";
    /**
     * The constant SQL_WRITE_COURIER_RATING.
     */
    public static final String SQL_WRITE_COURIER_RATING =
            "UPDATE user SET rating = ? WHERE login = ?";
    /**
     * The constant SQL_GET_USER_RATING.
     */
    public static final String SQL_GET_USER_RATING =
            "SELECT rating FROM user WHERE login = ?";
    /**
     * The constant SQL_FIND_CURRENT_CUSTOMER_ORDER.
     */
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
    /**
     * The constant SQL_FIND_ACTIVE_CUSTOMER_ORDER.
     */
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
    /**
     * The constant SQL_FIND_COMPLETE_CUSTOMER_ORDER.
     */
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
    /**
     * The constant SQL_FIND_AVAILABLE_COURIER_ORDER.
     */
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
    /**
     * The constant SQL_UPDATE_ORDER_STATUS_TO_PROCESSING.
     */
    public static final String SQL_UPDATE_ORDER_STATUS_TO_PROCESSING =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '2', courier_id = ? WHERE order_id = ?";
    /**
     * The constant SQL_FIND_PROCESSING_COURIER_ORDER.
     */
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
    /**
     * The constant SQL_UPDATE_ORDER_STATUS_TO_COMPLETE.
     */
    public static final String SQL_UPDATE_ORDER_STATUS_TO_COMPLETE =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '3', courier_id = ? WHERE order_id = ?";
    /**
     * The constant SQL_FIND_COMPLETE_COURIER_ORDER.
     */
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
    /**
     * The constant SQL_UPDATE_ORDER_STATUS_TO_RATED.
     */
    public static final String SQL_UPDATE_ORDER_STATUS_TO_RATED =
            "UPDATE shipping_order " +
                    "JOIN order_status " +
                    "ON shipping_order.order_status_id = order_status.id_status " +
                    "SET shipping_order.order_status_id = '4' WHERE order_id = ?";
    /**
     * The constant SQL_FIND_USER_LIST.
     */
    public static final String SQL_FIND_USER_LIST =
            "SELECT user_id, login, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE role_name != 'ADMIN'";
    /**
     * The constant SQL_FIND_CURRENT_USER.
     */
    public static final String SQL_FIND_CURRENT_USER =
            "SELECT user_id, login, role_name, transport_name, rating " +
                    "FROM user " +
                    "JOIN role " +
                    "ON user.role_id = role.role_id " +
                    "LEFT JOIN transport " +
                    "ON user.transport_id = transport.transport_id " +
                    "WHERE user_id = ?";
    /**
     * The constant SQL_CHANGE_USER_LOGIN.
     */
    public static final String SQL_CHANGE_USER_LOGIN =
            "UPDATE user SET login = ? WHERE user_id = ?";
    /**
     * The constant SQL_CHANGE_USER_ROLE.
     */
    public static final String SQL_CHANGE_USER_ROLE =
            "UPDATE user SET role_id = ? WHERE user_id = ?";
    /**
     * The constant SQL_CHANGE_USER_TRANSPORT.
     */
    public static final String SQL_CHANGE_USER_TRANSPORT =
            "UPDATE user SET transport_id = ? WHERE user_id = ?";
    /**
     * The constant SQL_CHANGE_USER_RATING.
     */
    public static final String SQL_CHANGE_USER_RATING =
            "UPDATE user SET rating = ? WHERE user_id = ?";
    /**
     * The constant SQL_RESET_USER_TRANSPORT.
     */
    public static final String SQL_RESET_USER_TRANSPORT =
            "UPDATE user SET transport_id = NULL WHERE user_id = ?";
    /**
     * The constant SQL_RESET_USER_RATING.
     */
    public static final String SQL_RESET_USER_RATING =
            "UPDATE user SET rating = 0.00 WHERE user_id = ?";

}
