package by.epam.training.command.impl.customer;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Order;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NewOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String subject = request.getParameter(JspAttribute.SUBJECT);
        Transport transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
        String rate = request.getParameter(JspAttribute.RATE);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(JspAttribute.USER);
        int userId = user.getId();
        try {
            Order order = new Order(subject, transport, rate);
            UserServiceImpl service = new UserServiceImpl();
            Order resultOrder = service.checkout(order, userId);
            session.setAttribute(JspAttribute.ORDER, resultOrder);
            session.setAttribute(JspAttribute.USER, userId);
            return JspAddress.CUSTOMER_DELIVERY;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}
