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

import static by.epam.chekun.domain.configuration.BeanFieldJsp.USER_ID;
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

        final String currentPassword = request.getParameter("currentPassword");
        final String newPassword = request.getParameter("newPassword");
        final String confirmedPassword = request.getParameter("confirmedPassword");

        try {
            service.changePassword(userId, currentPassword, newPassword, confirmedPassword);

            session.setAttribute("changePassMessage", "message.invalid_password");
        } catch (InvalidUserInformationException e) {
            session.setAttribute("changePassMessage", "message.password_dont_math");
            //user dont match
        } catch (InvalidPasswordException e) {
            session.setAttribute("changePassMessage", "message.invalid_password");
            //invalid passwors
        } catch (ServiceException e) {
            throw new CommandException();
        }
        return USER_PERSONAL_CABINET_PAGE;
    }
}
