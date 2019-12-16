package by.epam.training.command.user;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.training.command.JspAddress.HOME_PAGE;

/**
 * The type Home command.
 */
public class HomeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(JspAttribute.PAGE, HOME_PAGE);
        return HOME_PAGE;
    }
}
