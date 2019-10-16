package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.manager.ServiceManager;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.epam.chekun.domain.configuration.JspActionCommand.SORT_BY_ACTION_IN_USERS_TABLE;
import static by.epam.chekun.domain.configuration.JspActionCommand.SORT_TYPE_ACTION_IN_USERS_TABLE;
import static by.epam.chekun.domain.configuration.JspFilePass.USERS_TABLE_PAGE;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.USERS_LIST;

public class ViewUsersTableSortedCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService userService = ServiceManager.getInstance().getUserService();

    public ViewUsersTableSortedCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        final String sortedBy = request.getParameter(SORT_BY_ACTION_IN_USERS_TABLE);
        final String sortType = request.getParameter(SORT_TYPE_ACTION_IN_USERS_TABLE);

        try {
            final List<User> users = userService.getAllUsersSorted(sortedBy, sortType);

            request.setAttribute(USERS_LIST, users);
            request.setAttribute(SORT_BY_ACTION_IN_USERS_TABLE, sortedBy);
            request.setAttribute(SORT_TYPE_ACTION_IN_USERS_TABLE, sortType);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return USERS_TABLE_PAGE;
    }
}
