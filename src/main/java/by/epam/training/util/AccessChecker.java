package by.epam.training.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccessChecker {

    public static boolean checkForNullSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(JspAttribute.USER) == null;
    }
}
