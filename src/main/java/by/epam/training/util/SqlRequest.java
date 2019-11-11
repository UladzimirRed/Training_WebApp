package by.epam.training.util;

public class SqlRequest {
    public static final String FIND_PROFILE_BY_LOGIN =
            "SELECT id, login, password, role FROM profiles WHERE login =? AND password = SHA1(?)";
    public static final String CHECK_USER_EXISTS =
            "SELECT id FROM profiles WHERE login = ?";
    public static final String INSERT_USER =
            "INSERT INTO profiles(login, password, role) VALUES (?, SHA1(?), ?)";
    public static final String FIND_USER_BY_LOGIN =
            "SELECT user_id, login, password, role\n" +
                    "FROM profiles\n" +
                    "WHERE login = ?";
}
