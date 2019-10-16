package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.manager.ServiceManager;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.JspFilePass.USER_PERSONAL_CABINET_PAGE;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;

public class ViewUserCabinetCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService service = ServiceManager.getInstance().getUserService();

    public ViewUserCabinetCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final String userId = String.valueOf(session.getAttribute(USER_ID));

        try {
            final User user = service.getById(userId);

            request.setAttribute(USER_OBJECT, user);
            request.setAttribute(USER_STATUS_ID, user.getUserStatus().getUserStatusId());
            request.setAttribute(USER_BIRTH_DATE, user.getBirthDateStringFormat());

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return USER_PERSONAL_CABINET_PAGE;

    }
}
