package by.epam.training.util;

public class SqlRequest {
    //todo change all profile to user
    public static final String FIND_PROFILE_BY_LOGIN_AND_PASSWORD =
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
            "INSERT INTO `order`(subject, user_id, transport_id, express_rate) VALUES (?, ?, ?, ?)";

}
