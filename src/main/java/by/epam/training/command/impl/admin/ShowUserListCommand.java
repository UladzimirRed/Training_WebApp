package by.epam.training.command.impl.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUserListCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            List<User> users = service.showUserList();
            session.setAttribute(JspAttribute.USERS, users);
            return JspAddress.USER_LIST;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}
