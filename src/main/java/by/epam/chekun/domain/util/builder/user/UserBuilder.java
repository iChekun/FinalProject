package by.epam.chekun.domain.util.builder.user;

import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;

import java.sql.Timestamp;

public interface UserBuilder {

    User build();

    UserBuilder withPassword(String password);

    UserBuilder withContacts(Contacts contacts);

    UserBuilder withLogin(String login);

    UserBuilder withName(String name);

    UserBuilder withSurname(String surname);

    UserBuilder withUserStatus(UserStatus userStatus);

    UserBuilder withBirthDate(Timestamp birthDate);

    UserBuilder isBanned(boolean banned);
}
