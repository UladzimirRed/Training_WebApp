package by.epam.training.command.customer;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Order;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.CustomerServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RateOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter(JspAttribute.ORDER_ID));
        try {
            CustomerServiceImpl service = new CustomerServiceImpl();
            Order order = service.showCurrentDelivery(orderId);
            session.setAttribute(JspAttribute.ORDER, order);
            return JspAddress.RATE_ORDER;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }

    }
}

