package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditUserCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            User user = service.showCurrentUser(userId);
            session.setAttribute(JspAttribute.CURRENT_USER, user);
            return JspAddress.EDIT_USER;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }

    }
}

