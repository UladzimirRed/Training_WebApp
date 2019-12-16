package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

import static by.epam.training.command.JspAddress.ERROR_PAGE;
import static by.epam.training.command.JspAddress.HOME_PAGE;

/**
 * The type Empty command.
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return ERROR_PAGE;
    }
}
