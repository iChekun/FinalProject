package by.epam.chekun.domain.entity.user;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class User implements Serializable {

    private String userId;
    private Contacts contacts;

    private String login;
    private String password;

    private String name;
    private String surname;
    private UserStatus userStatus;

    private Timestamp birthDate;
    private boolean banned;


    public User() {
    }

    public User(String userId, Contacts contacts, String login, String password,
                String name, String surname,
                UserStatus userStatus, Timestamp birthDate, boolean banned) {
        this.userId = userId;
        this.contacts = contacts;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.userStatus = userStatus;
        this.birthDate = birthDate;
        this.banned = banned;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getPassword() {
        return password;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
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

    public Timestamp getBirthDate() {
        return birthDate;
    }

    /**
     * @return String with date without time
     */
    public String getBirthDateStringFormat() {
        return birthDate.toString().split(" ")[0];
    }

    public boolean getBanned() {
        return banned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return banned == user.banned &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(contacts, user.contacts) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                userStatus == user.userStatus &&
                Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contacts, login, password, name, surname, userStatus, birthDate, banned);
    }
}
