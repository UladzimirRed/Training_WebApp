package by.epam.training.command.courier;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.CourierServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The type Show processing order command.
 */
public class ShowProcessingOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User courier = (User) session.getAttribute(JspAttribute.USER);
        String page;
        try {
            CourierServiceImpl service = new CourierServiceImpl();
            List<Order> orders = service.showProcessingDelivery(courier);
            logger.info("Processing orders of courier with login " + courier.getLogin() + " provided");
            List<Order> sortedOrders = service.sortListOfOrdersByOrderId(orders);
            logger.info("Processing orders are sorted by id");
            session.setAttribute(JspAttribute.ORDERS, sortedOrders);
            page = JspAddress.PROCESSING_ORDER;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.ERROR_PAGE;
        }
        return new CommandResult(page);
    }
}
