package by.epam.training.util;

import by.epam.training.command.JspAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Access checker.
 */
public class AccessChecker {

    /**
     * Check for null session boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public static boolean checkForNullSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(JspAttribute.USER) == null;
    }
}
