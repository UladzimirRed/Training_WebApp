package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeTransportCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        Transport transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
        try {
            AdminServiceImpl service = new AdminServiceImpl();
            service.changeUserTransport(userId, transport);
            return JspAddress.CHANGE_SUCCESS;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}
