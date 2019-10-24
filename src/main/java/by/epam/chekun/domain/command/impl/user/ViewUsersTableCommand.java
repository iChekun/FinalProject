package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.USERS_LIST;
import static by.epam.chekun.domain.configuration.JspFilePass.USERS_TABLE_PAGE;

public class ViewUsersTableCommand implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService userService = ServiceManager.getInstance().getUserService();

    public ViewUsersTableCommand(final HttpServletRequest request,
                                 final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        try {
            final List<User> users = userService.getAll();
            request.setAttribute(USERS_LIST, users);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return USERS_TABLE_PAGE;
    }
}
