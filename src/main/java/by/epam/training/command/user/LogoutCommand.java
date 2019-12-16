package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Logout command.
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(JspAttribute.USER);
        session.removeAttribute(JspAttribute.ORDERS);
        session.removeAttribute(JspAttribute.ORDER);
        return JspAddress.HOME_PAGE;
    }
}
