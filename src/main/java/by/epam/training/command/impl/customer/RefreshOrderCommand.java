package by.epam.training.command.impl.customer;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.CustomerServiceImpl;
import by.epam.training.service.impl.UserServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RefreshOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(JspAttribute.USER);
        int userId = user.getId();
        try {
            CustomerServiceImpl service = new CustomerServiceImpl();
            List<Order> result = service.showCustomerDelivery(userId);
            session.setAttribute(JspAttribute.ORDERS, result);
            return JspAddress.CUSTOMER_DELIVERY;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}
