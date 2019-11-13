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

public class RegisterCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

        @Override
        public String execute(HttpServletRequest request) {
            String login = request.getParameter(JspAttribute.LOGIN);
            String password = request.getParameter(JspAttribute.PASSWORD);
            String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
            RoleEnum role = RoleEnum.getRoleByString(request.getParameter(JspAttribute.ROLE));
            try {
                if (!password.equals(confirmPassword)){
                    request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                    return JspAddress.REGISTER_URL;
                }
                UserServiceImpl service = new UserServiceImpl();
                User user = service.register(login, password, role);
                if (user != null) {
                    request.getSession().setAttribute(JspAttribute.USER, login);
                    request.setAttribute(JspAttribute.MESSAGE, JspAttribute.SIGNED_UP);
                    return JspAddress.MAIN_PAGE;
                }
                request.setAttribute(JspAttribute.DATA_EXISTS, JspAttribute.USER_EXISTS);
                return JspAddress.REGISTER_URL;
            } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            }
            return null;
        }
    }
