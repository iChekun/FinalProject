package by.epam.chekun.dao.impl.user;

final class UserSqlUtil {

    static final String SORT_USERS_BY_SURNAME = "bySurname";
    static final String SORT_USERS_BY_NAME = "ByName";
    static final String SORT_USERS_BY_BIRTH_DATE = "byBirthDate";

    static final String SORT_TYPE_ASC = "ASC";
    static final String SORT_TYPE_DESC = "DESC";
    /////////////////////////////////////////
    static final String GET_USER_BY_LOGIN_AND_PASS = "SELECT " +
            "u.userId," + "s.userStatusId," + "u.login," + "u.name," + "u.surname," +
            "u.birthDate," + "u.banned," + "c.contactsId," + "c.email," +
            "c.phoneNumber," + "c.country," + "c.city," + "c.street," + "c.houseNumber," +
            "c.apartmentNumber" +
            " FROM Users u" +
            " INNER JOIN UserStatus s" +
            " ON s.userStatusId = u.userStatusId" +
            " INNER JOIN Contacts c" +
            " ON c.contactsId=u.contactsId " +
            " WHERE login= ? " +
            " AND password = ? ";

    static final String GET_USER_BY_ID = "SELECT " +
            " u.userId, s.userStatusId,  u.login, u.name," +
            " u.surname, u.birthDate, u.banned, c.contactsId," +
            " c.email,  c.phoneNumber, c.country, c.city," +
            " c.street, c.houseNumber,  c.apartmentNumber" +
            " FROM Users u" +
            " INNER JOIN UserStatus s" +
            " ON s.userStatusId = u.userStatusId" +
            " INNER JOIN Contacts c" +
            " ON c.contactsId=u.contactsId" +
            " WHERE userId=?";

    static final String ADD_NEW_USER =
            "INSERT INTO users " +
                    "(userId, contactsId, userStatusId, login, password,name,surname,birthDate,banned) " +
                    "VALUES(UUID(),?,?,?,?,?,?,?,?)";

    static final String GET_USER_BY_LOGIN =
            "SELECT userId FROM users where login=?";


    static final String REMOVE_USER_BY_ID = "DELETE FROM Users WHERE userId = ?";

    static final String UPDATE_BAN_STATUS = "UPDATE Users SET banned=? WHERE UserId=?";

    static final String UPDATE_USER_STATUS = "UPDATE users SET userStatusId=?  WHERE userId=? ";

    static final String GET_ALL_USERS_SORTED_BY_SURNAME_ASC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY surname ASC";

    static final String GET_ALL_USERS_SORTED_BY_SURNAME_DESC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY surname DESC";


    static final String GET_ALL_USERS_SORTED_BY_BIRTH_DATE_ASC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY birthDate ASC";

    static final String GET_ALL_USERS_SORTED_BY_BIRTH_DATE_DESC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY birthDate DESC";

    static final String GET_ALL_USERS_SORTED_BY_NAME_ASC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY name ASC";

    static final String GET_ALL_USERS_SORTED_BY_NAME_DESC =
            "SELECT " +
                    "u.userId," +
                    "s.userStatusId," +
                    "u.login," +
                    "u.name," +
                    "u.surname," +
                    "u.birthDate," +
                    "u.banned," +
                    "c.contactsId," +
                    "c.email," +
                    "c.phoneNumber," +
                    "c.country," +
                    "c.city," +
                    "c.street," +
                    "c.houseNumber," +
                    "c.apartmentNumber" +
                    " FROM Users u" +
                    " INNER JOIN UserStatus s" +
                    " ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN Contacts c" +
                    " ON c.contactsId=u.contactsId" +
                    " ORDER BY name DESC";

    static final String GET_ALL_USERS = "SELECT " +
            "u.userId," +
            "s.userStatusId," +
            "u.login," +
            "u.name," +
            "u.surname," +
            "u.birthDate," +
            "u.banned," +
            "c.contactsId," +
            "c.email," +
            "c.phoneNumber," +
            "c.country," +
            "c.city," +
            "c.street," +
            "c.houseNumber," +
            "c.apartmentNumber" +
            " FROM Users u" +
            " INNER JOIN UserStatus s" +
            " ON s.userStatusId = u.userStatusId" +
            " INNER JOIN Contacts c" +
            " ON c.contactsId=u.contactsId";


    static final String UPDATE_USER =
            "UPDATE Users SET " +
                    "    contactsId=?, " +
                    "    login= ?," +
                    "    name= ?," +
                    "    surname= ?," +
                    "    birthDate= ?," +
                    "    banned= ?" +
                    "  WHERE userId=?";

    static final String UPDATE_USER_PASSWORD =
            " UPDATE users SET password=? WHERE userId=?";

    /////////////////////////
    private UserSqlUtil() {

    }
}
