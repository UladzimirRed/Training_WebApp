package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.util.JspAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.training.util.JspAddress.HOME_PAGE;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(JspAttribute.PAGE, HOME_PAGE);
        return HOME_PAGE;
    }
}
