package by.epam.training.command.impl.courier;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.CourierServiceImpl;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CompleteOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter(JspAttribute.ORDER_ID));
        User courier = (User) session.getAttribute(JspAttribute.USER);
        try {
            CourierServiceImpl service = new CourierServiceImpl();
            service.updateOrderStatusToComplete(orderId, courier);
            List<Order> orders = service.showCompleteDelivery(courier);
            List<Order> sortedOrders = service.sortListOfOrdersByOrderId(orders);
            session.setAttribute(JspAttribute.ORDERS, sortedOrders);
            return JspAddress.COMPLETE_ORDER;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            return JspAddress.ERROR_PAGE;
        }
    }
}