package by.epam.training.command;

import by.epam.training.command.admin.*;
import by.epam.training.command.courier.*;
import by.epam.training.command.user.*;
import by.epam.training.command.customer.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Command enum.
 */
public enum CommandEnum {
    /**
     * The Locale.
     */
    LOCALE(new LocaleCommand()),
    /**
     * The Login.
     */
    LOGIN(new LoginCommand()),
    /**
     * The Empty.
     */
    EMPTY(new EmptyCommand()),
    /**
     * The Logout.
     */
    LOGOUT(new LogoutCommand()),
    /**
     * The Register.
     */
    REGISTER(new RegisterCommand()),
    /**
     * The Home.
     */
    HOME(new HomeCommand()),
    /**
     * The Change password.
     */
    CHANGE_PASSWORD(new ChangePasswordCommand()),
    /**
     * The New order command.
     */
    NEW_ORDER_COMMAND(new NewOrderCommand()),
    /**
     * The Show active order command.
     */
    SHOW_ACTIVE_ORDER_COMMAND(new ShowActiveOrderCommand()),
    /**
     * The Show done order command.
     */
    SHOW_DONE_ORDER_COMMAND(new ShowDoneOrderCommand()),
    /**
     * The Confirm order command.
     */
    CONFIRM_ORDER_COMMAND(new ConfirmOrderCommand()),
    /**
     * The Rate order command.
     */
    RATE_ORDER_COMMAND(new RateOrderCommand()),
    /**
     * The Confirm rate command.
     */
    CONFIRM_RATE_COMMAND(new ConfirmRateCommand()),
    /**
     * The Show available order command.
     */
    SHOW_AVAILABLE_ORDER_COMMAND(new ShowAvailableOrderCommand()),
    /**
     * The Take order command.
     */
    TAKE_ORDER_COMMAND(new TakeOrderCommand()),
    /**
     * The Complete order command.
     */
    COMPLETE_ORDER_COMMAND(new CompleteOrderCommand()),
    /**
     * The Show processing order command.
     */
    SHOW_PROCESSING_ORDER_COMMAND(new ShowProcessingOrderCommand()),
    /**
     * The Show completed order command.
     */
    SHOW_COMPLETED_ORDER_COMMAND(new ShowCompletedOrderCommand()),
    /**
     * The Show user list command.
     */
    SHOW_USER_LIST_COMMAND(new ShowUserListCommand()),
    /**
     * The Edit user command.
     */
    EDIT_USER_COMMAND(new EditUserCommand()),
    /**
     * The Change login command.
     */
    CHANGE_LOGIN_COMMAND(new ChangeLoginCommand()),
    /**
     * The Change role command.
     */
    CHANGE_ROLE_COMMAND(new ChangeRoleCommand()),
    /**
     * The Change transport command.
     */
    CHANGE_TRANSPORT_COMMAND(new ChangeTransportCommand()),
    /**
     * The Change rating command.
     */
    CHANGE_RATING_COMMAND(new ChangeRatingCommand());

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

    /**
     * Gets current command.
     *
     * @param action the action
     * @return the current command
     */
    public static ActionCommand getCurrentCommand(String action) {
        return commands.getOrDefault(action.toUpperCase(), EMPTY).command;
    }
}
