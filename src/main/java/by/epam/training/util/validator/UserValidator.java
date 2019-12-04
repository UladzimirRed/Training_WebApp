package by.epam.training.util.validator;

import by.epam.training.entity.User;
import by.epam.training.exception.ValidationException;

public class UserValidator {

    public static final String PASSWORD_PATTERN = "^[\\w_]{4,32}$";
    public static final String LOGIN_PATTERN = "^[\\w_]{4,16}$";

    public static void validate(User user) throws ValidationException {
        if (user != null) {
            if (!user.getLogin().matches(LOGIN_PATTERN)) {
                throw new ValidationException("Wrong login pattern");
            } else if (!user.getPassword().matches(PASSWORD_PATTERN)) {
                throw new ValidationException("Wrong password pattern");
            }
        }
    }
}
