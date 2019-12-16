package by.epam.training.command.user;

import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Locale command.
 */
public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lang = request.getParameter(JspAttribute.LANGUAGE);
        request.getSession().setAttribute(JspAttribute.LOCAL, lang);
        request.getSession().setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        request.setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        return JspAddress.HOME_PAGE;
    }
}
