package by.epam.training.command;

import by.epam.training.command.impl.*;
import by.epam.training.command.impl.courier.*;
import by.epam.training.command.impl.ChangePasswordCommand;
import by.epam.training.command.impl.customer.ConfirmOrderCommand;
import by.epam.training.command.impl.customer.NewOrderCommand;
import by.epam.training.command.impl.customer.RefreshOrderCommand;

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
    NEW_ORDER_COMMAND(new NewOrderCommand()),
    CONFIRM_ORDER_COMMAND(new ConfirmOrderCommand()),
    SHOW_AVAILABLE_ORDER_COMMAND(new ShowAvailableOrderCommand()),
    TAKE_ORDER_COMMAND(new TakeOrderCommand()),
    REFRESH_ORDER_COMMAND(new RefreshOrderCommand()),
    COMPLETE_ORDER_COMMAND(new CompleteOrderCommand()),
    SHOW_PROCESSING_ORDER_COMMAND(new ShowProcessingOrderCommand()),
    SHOW_COMPLETED_ORDER_COMMAND(new ShowCompletedOrderCommand());

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
