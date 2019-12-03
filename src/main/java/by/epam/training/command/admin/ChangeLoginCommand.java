package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.exception.ServiceException;
import by.epam.training.exception.UserExistsException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeLoginCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        String currentLogin = request.getParameter(JspAttribute.CURRENT_LOGIN);
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            service.changeUserLogin(userId, currentLogin);
            return JspAddress.CHANGE_SUCCESS;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        } catch (UserExistsException e) {
            logger.log(Level.ERROR, e);
            request.setAttribute(JspAttribute.USER_EXIST, JspAttribute.USER_EXIST);
            return JspAddress.EDIT_USER;
        }
    }
}
