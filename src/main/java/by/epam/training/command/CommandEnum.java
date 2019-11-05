package by.epam.training.command;

import by.epam.training.command.impl.EmptyCommand;
import by.epam.training.command.impl.LocaleCommand;
import by.epam.training.command.impl.LoginCommand;
import by.epam.training.command.impl.LogoutCommand;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnum {
    LOCALE(new LocaleCommand()),
    LOGIN(new LoginCommand()),
    EMPTY(new EmptyCommand()),
    LOGOUT(new LogoutCommand());

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
