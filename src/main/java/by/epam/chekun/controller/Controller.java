package by.epam.chekun.controller;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.factory.CommandFactory;
import by.epam.chekun.domain.command.factory.impl.CommandFactoryImpl;
import by.epam.chekun.domain.configuration.JspActionCommand;
import by.epam.chekun.domain.configuration.JspFilePass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/mainWindow")
@MultipartConfig
public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter(JspActionCommand.ACTION_TYPE);
        logger.info("DO_GET command name " + action);

        final CommandFactory commandFactory = CommandFactoryImpl.getInstance();

        try {
            final Command command = commandFactory.createCommand(action, req, resp);
            final String path = command.execute();
            req.getRequestDispatcher(path).forward(req, resp);
        } catch (CommandException e) {
            logger.error(e);
            resp.sendRedirect(JspFilePass.ERROR_PAGE);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter(JspActionCommand.ACTION_TYPE);
        logger.info("DO POST command name  " + action);

        final CommandFactory commandFactory = CommandFactoryImpl.getInstance();

        try {
            final Command command = commandFactory.createCommand(action, req, resp);
            final String path = command.execute();

            resp.sendRedirect(path);

        } catch (CommandException e) {
            logger.error(e);
            resp.sendRedirect(JspFilePass.ERROR_PAGE);
        }
    }


}
