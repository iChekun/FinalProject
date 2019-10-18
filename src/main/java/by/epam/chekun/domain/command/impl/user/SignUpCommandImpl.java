package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.util.GetUserParametersFromJsp;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.InvalidEmailException;
import by.epam.chekun.domain.service.exception.user.InvalidLoginException;
import by.epam.chekun.domain.service.exception.user.InvalidUserInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

import static by.epam.chekun.domain.configuration.JspFilePass.SIGN_UP_PAGE;

public class SignUpCommandImpl implements Command {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService userService = ServiceManager.getInstance().getUserService();

    public SignUpCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final GetUserParametersFromJsp getUserParametersFromJsp = new GetUserParametersFromJsp(request);
        ///////////////////////////////////////////////////////////
        final String login = getUserParametersFromJsp.getLogin();
        final String password = getUserParametersFromJsp.getPassword();
        final String confirmedPassword = getUserParametersFromJsp.getConfirmedPassword();
        final String name = getUserParametersFromJsp.getName();
        final String surname = getUserParametersFromJsp.getSurname();
        final Date birthDate = getUserParametersFromJsp.getBirthDate();
        final String email = getUserParametersFromJsp.getEmail();
        final String phoneNumber = getUserParametersFromJsp.getPhoneNumber();
        final String country = getUserParametersFromJsp.getCountry();
        final String city = getUserParametersFromJsp.getCity();
        final String street = getUserParametersFromJsp.getStreet();
        final int houseNumber = getUserParametersFromJsp.getHouseNumber();
        final int apartmentNumber = getUserParametersFromJsp.getApartmentNumber();
        ///////////////////////////////////////////////////////////
        final HttpSession session = request.getSession();
        try {
            userService.add(login, password, confirmedPassword,
                    name, surname, birthDate,
                    email, phoneNumber,
                    country, city, street, houseNumber, apartmentNumber);

            session.setAttribute("errorMessage", "message.successful_registration");
            session.setAttribute("redirectToCommand", "main");
        } catch (InvalidLoginException ex) {
            session.setAttribute("errorMessage", "message.invalid_username");
        } catch (InvalidEmailException ex) {
            session.setAttribute("errorMessage", "message.invalid_email");
        } catch (InvalidUserInformationException ex) {
            session.setAttribute("errorMessage", "message.invalid_info");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        session.setAttribute("redirectToCommand", "signUpWindow");
        return SIGN_UP_PAGE;
    }
}
