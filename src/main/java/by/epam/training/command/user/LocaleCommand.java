package by.epam.training.command.user;

import by.epam.training.command.CommandResult;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.command.ActionCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Locale command.
 */
public class LocaleCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter(JspAttribute.LANGUAGE);
        request.getSession().setAttribute(JspAttribute.LOCAL, lang);
        logger.info("The locale attribute was set to: " + lang);
        return new CommandResult(JspAddress.HOME_PAGE);
    }
}
