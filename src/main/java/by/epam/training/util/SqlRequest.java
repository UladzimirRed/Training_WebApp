package by.epam.training.util;

public class SqlRequest {
    public static final String FIND_PROFILE_BY_LOGIN =
            "SELECT id, login, password, role FROM profiles WHERE login =? AND password = ?";
    public static final String CHECK_USER_EXISTS =
            "SELECT id FROM profiles WHERE login = ?";
}
