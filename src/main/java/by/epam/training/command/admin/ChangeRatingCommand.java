package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Change rating command.
 */
public class ChangeRatingCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        double rating = Double.parseDouble(request.getParameter(JspAttribute.RATING));
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            service.changeUserRating(userId, rating);
            return JspAddress.CHANGE_SUCCESS;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}
