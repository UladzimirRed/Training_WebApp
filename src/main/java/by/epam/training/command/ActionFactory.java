package by.epam.training.command;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandEnum;
import by.epam.training.command.impl.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public static ActionCommand defineCommand(HttpServletRequest request) {

        ActionCommand currentCommand = new EmptyCommand(); // FIXME: 29.11.2019
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return currentCommand;
        }
        return CommandEnum.getCurrentCommand(action);
    }
}
