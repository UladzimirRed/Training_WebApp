package by.epam.training.command.customer;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.Order;
import by.epam.training.entity.Transport;
import by.epam.training.entity.User;
import by.epam.training.service.impl.CustomerServiceImpl;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConfirmOrderCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String subject = request.getParameter(JspAttribute.SUBJECT);
        Transport transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
        boolean rate = Boolean.parseBoolean(request.getParameter(JspAttribute.RATE));
        String distanceString = request.getParameter(JspAttribute.DISTANCE);
        int distance = Integer.parseInt(distanceString);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(JspAttribute.USER);
        Order order = new Order(subject, user, transport, rate, distance);
        CustomerServiceImpl service = new CustomerServiceImpl();
        Order resultOrder = service.countTotalCost(order);
        session.setAttribute(JspAttribute.ORDER, resultOrder);
        return JspAddress.CONFIRM_ORDER;
    }
}
