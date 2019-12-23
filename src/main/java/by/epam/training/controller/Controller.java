package by.epam.training.controller;

import by.epam.training.command.*;
import by.epam.training.connection.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Controller.
 */
@WebServlet(name = "MainController", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionCommand command = ActionFactory.defineCommand(request);
        CommandResult commandResult = command.execute(request, response);
        String page = commandResult.getPage();
        if (!commandResult.isRedirect()) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }
}
