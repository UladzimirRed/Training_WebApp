package by.epam.training.command;

import by.epam.training.command.impl.*;
import by.epam.training.command.impl.courier.*;
import by.epam.training.command.impl.ChangePasswordCommand;
import by.epam.training.command.impl.customer.*;

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
    SHOW_ACTIVE_ORDER_COMMAND(new ShowActiveOrderCommand()),
    SHOW_DONE_ORDER_COMMAND(new ShowDoneOrderCommand()),
    CONFIRM_ORDER_COMMAND(new ConfirmOrderCommand()),
    RATE_ORDER_COMMAND(new RateOrderCommand()),
    CONFIRM_RATE_COMMAND(new ConfirmRateCommand()),
    SHOW_AVAILABLE_ORDER_COMMAND(new ShowAvailableOrderCommand()),
    TAKE_ORDER_COMMAND(new TakeOrderCommand()),
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
