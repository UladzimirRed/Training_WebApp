package by.epam.training.command.impl;

import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import by.epam.training.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String lang = request.getParameter(JspAttribute.LANGUAGE);
        request.getSession().setAttribute(JspAttribute.LOCAL, lang);
        request.getSession().setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        request.setAttribute(JspAttribute.MESSAGE, JspAttribute.CHANGED_LOCALE);
        return JspAddress.LOGIN_PAGE;
    }
}
