package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.JspActionCommand.USER_FOR_ACTION_IN_USERS_TABLE;
import static by.epam.chekun.domain.configuration.JspFilePass.USERS_TABLE_PAGE;

public class AdminChangeUserStatusCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private UserService userService = ServiceManager.getInstance().getUserService();

    public AdminChangeUserStatusCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();
        try {
            final String userIdForAction = String.valueOf(request.getParameter(USER_FOR_ACTION_IN_USERS_TABLE));
            userService.changeUserStatus(userIdForAction);

        } catch (ServiceException ex) {
            throw new CommandException(ex);
        }

        session.setAttribute("redirectToCommand", "viewUsersTable");
        return USERS_TABLE_PAGE;
    }
}
