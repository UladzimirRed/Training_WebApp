package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Role;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class RegisterCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    //todo make return as in login
    //todo: as we have new pages customer register and courier register, provide page for each and return the needed one
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(JspAttribute.LOGIN);
        String password = request.getParameter(JspAttribute.PASSWORD);
        String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
        Transport transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
        Role role = Role.getRoleByString(request.getParameter(JspAttribute.ROLE));
        HttpSession session = request.getSession();
        try {
            if (!password.equals(confirmPassword)) {
                request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                return JspAddress.REGISTER_PAGE;
            }
            User user = new User(login, password, role, transport);

            UserServiceImpl service = new UserServiceImpl();
            User resultUser = service.register(user);

            session.setAttribute(JspAttribute.USER, resultUser);
            return JspAddress.MAIN_PAGE;

        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        } catch (UserExistsException e) {
            logger.log(Level.ERROR, e);
            request.setAttribute(JspAttribute.DATA_EXISTS, JspAttribute.USER_EXISTS);
            return JspAddress.REGISTER_PAGE;
        }
    }
}
