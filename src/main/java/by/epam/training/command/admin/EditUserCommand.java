package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The type Edit user command.
 */
public class EditUserCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        String page;
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            User user = service.showCurrentUser(userId);
            session.setAttribute(JspAttribute.CURRENT_USER, user);
            logger.info("User information with id " + userId + " provided");
            page = JspAddress.EDIT_USER;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.ERROR_PAGE;
        }
        return new CommandResult(page);
    }
}
