package by.epam.training.command.admin;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;
import by.epam.training.entity.RoleType;
import by.epam.training.entity.Transport;
import by.epam.training.service.impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConfirmChangeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter(JspAttribute.USER_ID));
        String currentLogin = request.getParameter(JspAttribute.CURRENT_LOGIN);
        RoleType role = RoleType.getRoleByString(request.getParameter(JspAttribute.ROLE));
        Transport transport = null;
        double rating = 0;
        if (role.equals(RoleType.COURIER)) {
            transport = Transport.getTransportByString(request.getParameter(JspAttribute.TRANSPORT));
            rating = Double.parseDouble(request.getParameter(JspAttribute.RATING));
        }
        AdminServiceImpl service = new AdminServiceImpl();
        return JspAddress.ERROR_PAGE;
    }
}
