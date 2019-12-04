package by.epam.training.command;

import by.epam.training.command.user.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public static ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand currentCommand = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return currentCommand;
        }
        return CommandEnum.getCurrentCommand(action);
    }
}
