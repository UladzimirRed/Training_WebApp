package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The type Change password command.
 */
public class ChangePasswordCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User userFromSession = (User) session.getAttribute(JspAttribute.USER);
        String login = userFromSession.getLogin();
        String oldPassword = request.getParameter(JspAttribute.OLD_PASSWORD);
        String newPassword = request.getParameter(JspAttribute.NEW_PASSWORD);
        String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
        String page;
        try {
            if(!oldPassword.equals(newPassword)){
                if (newPassword.equals(confirmPassword)) {
                    UserServiceImpl service = new UserServiceImpl();
                    User user = service.changePassword(login, oldPassword, newPassword);
                    if (user != null) {
                        logger.info("User password with login " + login + " changed");
                        session.setAttribute(JspAttribute.USER, user);
                        request.setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_PASSWORD);
                    } else {
                        logger.info("User password with login " + login + "not  changed: wrong old password");
                        request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_PASSWORD);
                    }
                } else {
                    logger.info("User password with login " + login + "not  changed: new and confirm passwords do not match");
                    request.setAttribute(JspAttribute.PASSWORD_DOES_NOT_MATCH, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                }
            } else {
                request.setAttribute(JspAttribute.PASSWORDS_EQUALS, JspAttribute.PASSWORDS_EQUALS);
                logger.info("User password with login " + login + "not  changed: new and old passwords do not match");
            }
            page = JspAddress.CHANGE_PASSWORD;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.CHANGE_PASSWORD;
        }
        session.setAttribute(JspAttribute.PAGE, page);
        return new CommandResult(page, true);
    }
}
