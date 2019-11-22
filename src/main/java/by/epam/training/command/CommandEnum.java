package by.epam.training.command;

import by.epam.training.command.impl.*;
import by.epam.training.command.impl.courier.ShowAvailableCommand;
import by.epam.training.command.impl.courier.TakeOrderCommand;
import by.epam.training.command.impl.ChangePasswordCommand;
import by.epam.training.command.impl.customer.ConfirmDeliveryCommand;
import by.epam.training.command.impl.customer.NewOrderCommand;
import by.epam.training.command.impl.customer.RefreshDeliveryCommand;

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
    CONFIRM_DELIVERY_COMMAND(new ConfirmDeliveryCommand()),
    SHOW_AVAILABLE_COMMAND(new ShowAvailableCommand()),
    TAKE_ORDER_COMMAND(new TakeOrderCommand()),
    REFRESH_DELIVERY_COMMAND(new RefreshDeliveryCommand());

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
