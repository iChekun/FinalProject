package by.epam.chekun.domain.command.impl.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;

/**
 * Util class for help parsing users data from JSP
 */
public class GetUserParametersFromJsp {

    private final HttpServletRequest request;

    public GetUserParametersFromJsp(HttpServletRequest request) {
        this.request = request;
    }


    public String getLogin() {
        return request.getParameter(USER_LOGIN);
    }

    public String getPassword() {
        return request.getParameter(USER_PASSWORD);
    }


    public String getConfirmedPassword() {
        return request.getParameter(USER_CONFIRMED_PASSWORD);
    }

    public String getName() {
        return request.getParameter(USER_NAME);
    }

    public String getSurname() {
        return request.getParameter(USER_SURNAME);
    }

    public Date getBirthDate() {
        final String birthDate = request.getParameter(USER_BIRTH_DATE);
        return Date.valueOf(birthDate);
    }

    public String getEmail() {
        return request.getParameter(USER_CONTACTS_EMAIL);
    }

    public String getPhoneNumber() {
        return (request.getParameter(USER_CONTACTS_PHONE_NUMBER));
    }

    public String getCountry() {
        return request.getParameter(USER_CONTACTS_ADDRESS_COUNTRY);
    }

    public String getCity() {
        return request.getParameter(USER_CONTACTS_ADDRESS_CITY);
    }

    public String getStreet() {
        return request.getParameter(USER_CONTACTS_ADDRESS_STREET);
    }

    public int getHouseNumber() {
        return Integer.valueOf(request.getParameter(USER_CONTACTS_ADDRESS_HOUSE_NUMBER));
    }

    public int getApartmentNumber() {
        return Integer.valueOf(request.getParameter(USER_CONTACTS_ADDRESS_USER_APARTMENT_NUMBER));
    }

    public String getUserIdFromSession(final HttpSession session) {
        return String.valueOf(session.getAttribute(USER_ID));
    }

    public int getUserStatusIdFromSession(final HttpSession session) {
        return (int) (session.getAttribute(USER_STATUS_ID));
    }


    public String getUserContactsId() {
        return String.valueOf(request.getParameter(USER_CONTACTS_ID));
    }

    public boolean getIsUserBanned() {
        return Boolean.valueOf(request.getParameter(USER_BANNED_STATUS));
    }
}
