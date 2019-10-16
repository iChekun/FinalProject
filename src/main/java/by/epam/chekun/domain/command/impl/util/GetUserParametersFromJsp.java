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
        final String login = request.getParameter(USER_LOGIN);
        return login;
    }

    public String getPassword() {
        final String password = request.getParameter(USER_PASSWORD);
        return password;
    }


    public String getConfirmedPassword() {
        final String confirmedPassword = request.getParameter(USER_CONFIRMED_PASSWORD);
        return confirmedPassword;
    }

    public String getName() {
        final String name = request.getParameter(USER_NAME);
        return name;
    }

    public String getSurname() {
        final String surname = request.getParameter(USER_SURNAME);
        return surname;
    }

    public Date getBirthDate() {
        final String birthDate = request.getParameter(USER_BIRTH_DATE);
        final Date birthDateForm = Date.valueOf(birthDate);
        return birthDateForm;
    }

    public String getEmail() {
        final String email = request.getParameter(USER_CONTACTS_EMAIL);
        return email;
    }

    public String getPhoneNumber() {
        final String phoneNumber = (request.getParameter(USER_CONTACTS_PHONE_NUMBER));
        return phoneNumber;
    }

    public String getCountry() {
        final String country = request.getParameter(USER_CONTACTS_ADDRESS_COUNTRY);
        return country;
    }

    public String getCity() {
        final String city = request.getParameter(USER_CONTACTS_ADDRESS_CITY);
        return city;
    }

    public String getStreet() {
        final String street = request.getParameter(USER_CONTACTS_ADDRESS_STREET);
        return street;
    }

    public int getHouseNumber() {
        final int houseNumber = Integer.valueOf(request.getParameter(USER_CONTACTS_ADDRESS_HOUSE_NUMBER));
        return houseNumber;
    }

    public int getApartmentNumber() {
        final int apartmentNumber = Integer.valueOf(request.getParameter(USER_CONTACTS_ADDRESS_USER_APARTMENT_NUMBER));
        return apartmentNumber;
    }

    public String getUserIdFromSession(final HttpSession session) {
        final String userId = String.valueOf(session.getAttribute(USER_ID));
        return userId;
    }

    public int getUserStatusIdFromSession(final HttpSession session) {
        final int userId = (int) (session.getAttribute(USER_STATUS_ID));
        return userId;
    }


    public String getUserContactsId() {
        final String contactsId = String.valueOf(request.getParameter(USER_CONTACTS_ID));
        return contactsId;
    }

    public boolean getIsUserBanned() {
        final boolean banned = Boolean.valueOf(request.getParameter(USER_BANNED_STATUS));
        return banned;
    }
}
