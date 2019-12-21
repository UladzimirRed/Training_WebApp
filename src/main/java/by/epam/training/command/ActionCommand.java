package by.epam.training.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The interface Action command.
 */
public interface ActionCommand {
    /**
     * Execute string.
     *
     * @param request the request
     * @return the string
     */
    CommandResult execute(HttpServletRequest request, HttpServletResponse response);
}
