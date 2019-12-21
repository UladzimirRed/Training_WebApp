package by.epam.training.command.customer;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandResult;
import by.epam.training.entity.Order;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.impl.CustomerServiceImpl;
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
 * The type Show done order command.
 */
public class ShowDoneOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(JspAttribute.USER);
        int userId = user.getId();
        String page;
        try {
            CustomerServiceImpl service = new CustomerServiceImpl();
            List<Order> orders = service.showCompleteDelivery(userId);
            logger.info("Completed orders of user with login " + user.getLogin() + " provided");
            List<Order> sortedOrders = service.sortListOfOrdersByOrderId(orders);
            logger.info("Completed orders are sorted by id");
            session.setAttribute(JspAttribute.ORDERS, sortedOrders);
            page = JspAddress.CUSTOMER_DONE;
        } catch (ServiceException e) {
            logger.error("Service error occurred", e);
            page = JspAddress.ERROR_PAGE;
        }
        return new CommandResult(page);
    }
}
