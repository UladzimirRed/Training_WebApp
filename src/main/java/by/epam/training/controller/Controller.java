package by.epam.training.controller;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.ActionFactory;
import by.epam.training.command.JspAddress;
import by.epam.training.command.JspAttribute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainController", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        ActionCommand command = ActionFactory.defineCommand(request);
        page = command.execute(request);
        if (!page.equals(JspAddress.ERROR_PAGE)) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_DATA);
            request.getRequestDispatcher(JspAddress.ERROR_PAGE).forward(request, response);
        }
    }
}
