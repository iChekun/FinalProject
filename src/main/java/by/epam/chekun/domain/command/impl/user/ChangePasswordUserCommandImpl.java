package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.InvalidPasswordException;
import by.epam.chekun.domain.service.exception.user.InvalidUserInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_USER_CABINET_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_PERSONAL_CABINET_PAGE;

public class ChangePasswordUserCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService service = ServiceManager.getInstance().getUserService();

    public ChangePasswordUserCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();
        final String userId = String.valueOf(session.getAttribute(USER_ID));

        final String currentPassword = request.getParameter(USER_CURRENT_PASSWORD);
        final String newPassword = request.getParameter(USER_NEW_PASSWORD);
        final String confirmedPassword = request.getParameter(USER_CONFIRMED_NEW_PASSWORD);

        try {
            service.changePassword(userId, currentPassword, newPassword, confirmedPassword);
            session.setAttribute(ERROR_TO_JSP_PASSWORD, "message.password_changed");
        } catch (InvalidUserInformationException e) {
            session.setAttribute(ERROR_TO_JSP_PASSWORD, "message.password_dont_math");
        } catch (InvalidPasswordException e) {
            session.setAttribute(ERROR_TO_JSP_PASSWORD, "message.invalid_password");
        } catch (ServiceException e) {
            throw new CommandException();
        }
        session.setAttribute(REDIRECT_COMMAND, VIEW_USER_CABINET_COMMAND);
        return USER_PERSONAL_CABINET_PAGE;
    }
}
