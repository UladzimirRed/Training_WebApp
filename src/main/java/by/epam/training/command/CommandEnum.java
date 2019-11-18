package by.epam.training.command;

import by.epam.training.command.impl.*;
import by.epam.training.command.impl.customer.ChangePasswordCommand;
import by.epam.training.command.impl.customer.NewOrderCommand;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnum {
    LOCALE(new LocaleCommand()),
    LOGIN(new LoginCommand()),
    EMPTY(new EmptyCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTER(new RegisterCommand()),
    HOME(new HomeCommand()),
    CHANGE_PASSWORD(new ChangePasswordCommand()),
    NEW_ORDER_COMMAND(new NewOrderCommand());

    private static final Map<String, CommandEnum> commands = new HashMap<>();

    static {
        for (CommandEnum commandEnum : CommandEnum.values()) {
            commands.put(commandEnum.name(), commandEnum);
        }
    }

    private ActionCommand command;


    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public static ActionCommand getCurrentCommand(String action) {
        return commands.getOrDefault(action.toUpperCase(), EMPTY).command;
    }
}
