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
 * The type Login command.
 */
public class LoginCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page;
        String login = request.getParameter(JspAttribute.PARAM_NAME_LOGIN);
        String password = request.getParameter(JspAttribute.PARAM_NAME_PASSWORD);
        try {
            UserServiceImpl service = new UserServiceImpl();
            User user = service.logIn(login, password);
            if (user != null) {
                request.setAttribute(JspAttribute.USER, login);
                logger.info("User with login " + login + " logged in");
                session.setAttribute(JspAttribute.USER, user);
                switch (user.getRole()){
                    case CUSTOMER:
                        page = JspAddress.CUSTOMER_MAIN;
                        break;
                    case COURIER:
                        page = JspAddress.COURIER_MAIN;
                        break;
                    default:
                        page = JspAddress.ADMIN_MAIN;
                }
            } else {
                if(login.equals("") || password.equals("")){
                    logger.info("An attempt was made to send an empty required field");
                    request.setAttribute(JspAttribute.EMPTY_FIELDS, JspAttribute.EMPTY_FIELDS);
                } else {
                    logger.info("User with login " + login + " did not logged in: wrong credentials");
                    request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_DATA);
                }
                page = JspAddress.LOGIN_PAGE;
            }
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.LOGIN_PAGE;
        }
        return new CommandResult(page, true);
    }
}
