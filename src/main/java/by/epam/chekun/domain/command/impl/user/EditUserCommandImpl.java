package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.util.GetUserParametersFromJsp;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.InvalidEmailException;
import by.epam.chekun.domain.service.exception.user.InvalidLoginException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_USER_CABINET_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_PERSONAL_CABINET_PAGE;

public class EditUserCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService service = ServiceManager.getInstance().getUserService();

    public EditUserCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final GetUserParametersFromJsp getUserParametersFromJsp = new GetUserParametersFromJsp(request);
        ///////////////////////////////////////////////////////////

        final String userId = getUserParametersFromJsp.getUserIdFromSession(session);
        final String contactsId = getUserParametersFromJsp.getUserContactsId();
        final boolean banned = getUserParametersFromJsp.getIsUserBanned();
        final int userStatusId = getUserParametersFromJsp.getUserStatusIdFromSession(session);

        final String login = getUserParametersFromJsp.getLogin();
        final String name = getUserParametersFromJsp.getName();
        final String surname = getUserParametersFromJsp.getSurname();
        final Date birthDateForm = getUserParametersFromJsp.getBirthDate();
        ///////////////////////////////////////////////////////////
        final String email = getUserParametersFromJsp.getEmail();
        final String phoneNumber = getUserParametersFromJsp.getPhoneNumber();
        final String country = getUserParametersFromJsp.getCountry();
        final String city = getUserParametersFromJsp.getCity();
        final String street = getUserParametersFromJsp.getStreet();
        final int houseNumber = getUserParametersFromJsp.getHouseNumber();
        final int apartmentNumber = getUserParametersFromJsp.getApartmentNumber();

        try {
            service.update(userId, userStatusId, banned,
                    login, name, surname, birthDateForm,
                    contactsId, email, phoneNumber,
                    country, city, street, houseNumber, apartmentNumber);

            User user = service.getById(userId);
            request.setAttribute(USER_OBJECT, user);
            request.setAttribute(USER_STATUS_ID, user.getUserStatus().getUserStatusId());

            session.setAttribute(ERROR_TO_JSP, "message.successful_registration");
        } catch (InvalidLoginException ex) {
            session.setAttribute(ERROR_TO_JSP, "message.invalid_username");
        } catch (InvalidEmailException ex) {
            session.setAttribute(ERROR_TO_JSP, "message.invalid_email");
        } catch (ServiceException e) {
            session.setAttribute(ERROR_TO_JSP, "message.invalid_info");
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_USER_CABINET_COMMAND);
        return USER_PERSONAL_CABINET_PAGE;
    }
}
