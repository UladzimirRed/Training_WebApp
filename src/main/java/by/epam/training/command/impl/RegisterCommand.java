package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.RoleEnum;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.training.util.JspAddress.HOME_PAGE;

public class RegisterCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    //todo make return as in login
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(JspAttribute.LOGIN);
        String password = request.getParameter(JspAttribute.PASSWORD);
        String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
        RoleEnum role = RoleEnum.getRoleByString(request.getParameter(JspAttribute.ROLE));
        HttpSession session = request.getSession();
        try {
            if (!password.equals(confirmPassword)) {
                request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                session.setAttribute(JspAttribute.PAGE, JspAddress.REGISTER_URL);
                return JspAddress.REGISTER_URL;
            }
            UserServiceImpl service = new UserServiceImpl();
            User user = service.register(login, password, role);

            if (user != null) {
                session.setAttribute(JspAttribute.USER, user);
                session.setAttribute(JspAttribute.PAGE, JspAddress.MAIN_PAGE);
                request.setAttribute(JspAttribute.MESSAGE, JspAttribute.SIGNED_UP);
                return JspAddress.MAIN_PAGE;
            }
            session.setAttribute(JspAttribute.PAGE, JspAddress.REGISTER_URL);
            request.setAttribute(JspAttribute.DATA_EXISTS, JspAttribute.USER_EXISTS);
            return JspAddress.REGISTER_URL;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            session.setAttribute(JspAttribute.PAGE, HOME_PAGE);
            return HOME_PAGE;
        }
    }
}
