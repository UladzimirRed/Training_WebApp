package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.exception.ValidationException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.util.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * The type Register command.
 */
public class RegisterCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
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
                UserValidator.validate(user);
                UserServiceImpl service = new UserServiceImpl();
                User resultUser = service.register(user);
                logger.info("User with login " + login + " is registered");
                session.setAttribute(JspAttribute.USER, resultUser);
                if (resultUser.getRole().name().equals(JspAttribute.CUSTOMER)) {
                    page = JspAddress.CUSTOMER_MAIN;
                } else {
                    page = JspAddress.COURIER_MAIN;
                }
            } else {
                logger.info("User with login " + login + " is not registered: passwords does not match");
                session.setAttribute(JspAttribute.PASSWORD_DOES_NOT_MATCH, JspAttribute.PASSWORD_DOES_NOT_MATCH);
                page = defineUserPage(transport);
            }
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.ERROR_PAGE;
        } catch (UserExistsException e) {
            logger.info("user with login " + login + " already exist");
            session.setAttribute(JspAttribute.USER_EXIST, JspAttribute.USER_EXIST);
            page = defineUserPage(transport);
        } catch (ValidationException e) {
            logger.warn("Validation is not successful. check the correctness of the entered values");
            session.setAttribute(JspAttribute.WRONG_PATTERN, JspAttribute.WRONG_PATTERN);
            page = defineUserPage(transport);
        }
        return new CommandResult(page, true);
    }

    private String defineUserPage(Transport transport) {
        String page;
        if (transport == null){
            page = JspAddress.REGISTER_CUSTOMER;
        } else {
            page = JspAddress.REGISTER_COURIER;
        }
        return page;
    }
}
