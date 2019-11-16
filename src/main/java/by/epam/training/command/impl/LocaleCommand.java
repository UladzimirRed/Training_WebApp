package by.epam.training.command.impl;

import by.epam.training.util.JspAttribute;
import by.epam.training.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lang = request.getParameter(JspAttribute.LANGUAGE);
        request.getSession().setAttribute(JspAttribute.LOCAL, lang);
        request.getSession().setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        request.setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        String page = session.getAttribute(JspAttribute.PAGE).toString();
        session.setAttribute(JspAttribute.PAGE, page);
        return page;
    }
}
