package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(JspAttribute.USER);
        return JspAddress.HOME_PAGE;
    }
}
