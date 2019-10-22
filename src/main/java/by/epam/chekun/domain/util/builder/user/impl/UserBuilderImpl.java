package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;
import by.epam.chekun.domain.util.builder.user.UserBuilder;

import java.sql.Timestamp;

public class UserBuilderImpl implements UserBuilder {

    private String userId;

    private Contacts contacts;

    private String login;
    private String password;

    private String name;
    private String surname;
    private UserStatus userStatus;

    private Timestamp birthDate;
    private boolean banned;

    public UserBuilderImpl() {
        this.userId = "";
    }

    public UserBuilderImpl(String userId) {
        this.userId = userId;
    }


    @Override
    public UserBuilder withContacts(Contacts contacts) {
        this.contacts = contacts;
        return this;
    }

    @Override
    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    @Override
    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }


    @Override
    public UserBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    @Override
    public UserBuilder withBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Override
    public UserBuilder isBanned(boolean banned) {
        this.banned = banned;
        return this;
    }

    @Override
    public User build() {
        final User user = new User();

        user.setUserId(userId);
        user.setContacts(contacts);
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setUserStatus(userStatus);
        user.setBirthDate(birthDate);
        user.setBanned(banned);
        return user;
    }


    public String getUserId() {
        return userId;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public boolean isBanned() {
        return banned;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }
}
