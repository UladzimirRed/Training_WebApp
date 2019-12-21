package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The type Show user list command.
 */
public class ShowUserListCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page;
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            List<User> users = service.showUserList();
            session.setAttribute(JspAttribute.USERS, users);
            logger.info("Information about all users is provided");
            page = JspAddress.USER_LIST;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page =JspAddress.ERROR_PAGE;
        }
        return new CommandResult(page);
    }
}
