package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.util.AccessChecker;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        if (AccessChecker.checkForNullSession(request)) {
            return JspAddress.LOGIN_PAGE;
        }
        HttpSession session = request.getSession();
        User userFromSession = (User) session.getAttribute(JspAttribute.USER);
        String page;
        String login = userFromSession.getLogin();
        String oldPassword = request.getParameter(JspAttribute.OLD_PASSWORD);
        String newPassword = request.getParameter(JspAttribute.NEW_PASSWORD);
        String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
        try {
            if(!oldPassword.equals(newPassword)){
                if (newPassword.equals(confirmPassword)) {
                    UserServiceImpl service = new UserServiceImpl();
                    User user = service.changePassword(login, oldPassword, newPassword);
                    if (user != null) {
                        session.setAttribute(JspAttribute.USER, user);
                        request.setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_PASSWORD);
                    } else {
                        request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_PASSWORD);
                    }
                } else {
                    request.setAttribute(JspAttribute.PASSWORD_DOES_NOT_MATCH, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                }
            } else {
                request.setAttribute(JspAttribute.PASSWORDS_EQUALS, JspAttribute.PASSWORDS_EQUALS);
            }
            page = JspAddress.CHANGE_PASSWORD;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            page = JspAddress.CHANGE_PASSWORD;
        }
        session.setAttribute(JspAttribute.PAGE, page);
        return page;
    }
}
