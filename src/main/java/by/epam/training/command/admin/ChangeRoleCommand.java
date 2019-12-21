package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.entity.RoleType;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Change role command.
 */
public class ChangeRoleCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        RoleType role = RoleType.getRoleByString(request.getParameter(JspAttribute.ROLE));
        String page;
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            service.changeUserRole(userId, role);
            logger.info("User role with id " + userId + " changed to " + role.toString().toLowerCase());
            page = JspAddress.CHANGE_SUCCESS;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.ERROR_PAGE;
        }
        return new CommandResult(page, true);
    }
}

