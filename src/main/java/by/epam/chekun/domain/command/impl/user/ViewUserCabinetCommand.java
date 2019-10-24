package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_PERSONAL_CABINET_PAGE;

public class ViewUserCabinetCommand implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService service = ServiceManager.getInstance().getUserService();

    public ViewUserCabinetCommand(final HttpServletRequest request,
                                  final HttpServletResponse response) {
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

            checkDialogMessage(session);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return USER_PERSONAL_CABINET_PAGE;

    }

    private void checkDialogMessage(HttpSession session) {
        //check was any messages to user or not
        // if yes took message from session and put it with rename

        if (session.getAttribute(ERROR_TO_JSP_PASSWORD) != null) {
            String error = String.valueOf(session.getAttribute(ERROR_TO_JSP_PASSWORD));
            request.setAttribute(ERROR_MESSAGE_TO_JSP, error);
            session.removeAttribute(ERROR_TO_JSP_PASSWORD);
        }

        if (session.getAttribute(ERROR_TO_EDIT_USER) != null) {
            String error = String.valueOf(session.getAttribute(ERROR_TO_EDIT_USER));
            request.setAttribute(ERROR_MESSAGE_TO_JSP, error);
            session.removeAttribute(ERROR_TO_EDIT_USER);
        }
    }
}
