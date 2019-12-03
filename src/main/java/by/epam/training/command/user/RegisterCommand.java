package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class RegisterCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    //todo make return as in login
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(JspAttribute.LOGIN);
        String password = request.getParameter(JspAttribute.PASSWORD);
        String confirmPassword = request.getParameter(JspAttribute.CONFIRM_PASSWORD);
        Transport transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
        RoleType role = RoleType.getRoleByString(request.getParameter(JspAttribute.ROLE));
        HttpSession session = request.getSession();
        try {
            if (password.equals(confirmPassword)) {
                User user;
                if (transport == null){
                    user = new User(login, password, role);
                } else {
                    user = new User(login, password, role, transport);
                }
                UserServiceImpl service = new UserServiceImpl();
                User resultUser = service.register(user);
                session.setAttribute(JspAttribute.USER, resultUser);

                if (resultUser.getRole().equals(JspAttribute.CUSTOMER)) {
                    page = JspAddress.CUSTOMER_MAIN;
                } else {
                    page = JspAddress.COURIER_MAIN;
                }
            } else {
                request.setAttribute(JspAttribute.PASSWORD_DOES_NOT_MATCH, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                if (transport == null){
                    page = JspAddress.REGISTER_CUSTOMER;
                } else {
                    page = JspAddress.REGISTER_COURIER;
                }
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            page = JspAddress.ERROR_PAGE;
        } catch (UserExistsException e) {
            logger.log(Level.INFO, e);
            request.setAttribute(JspAttribute.USER_EXIST, JspAttribute.USER_EXIST);
            if (transport == null){
                page = JspAddress.REGISTER_CUSTOMER;
            } else {
                page = JspAddress.REGISTER_COURIER;
            }
        }
        return page;
    }
}
