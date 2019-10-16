package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public interface UserService {


    User getById(String userId) throws ServiceException;
    
    List<User> getAll() throws ServiceException;

    List<User> getAllUsersSorted(String sortedBy, String sortType) throws ServiceException;

    void changeBanStatus(String userId) throws ServiceException;

    void changeUserStatus(String userId, int userStatusId) throws ServiceException;

    void update(String userId, int userStatusId, boolean banned,
                String login,
                String name, String surname, Date birthDate,
                String contactsId, String email, String phoneNumber,
                String country, String city, String street,
                int houseNumber, int apartmentNumber) throws ServiceException;


    User signIn(String login, String password) throws ServiceException;

    void add(String login, String password, String confirmedPassword,
             String name, String surname, Date birthDate,
             String email, String phoneNumber,
             String country, String city, String street,
             int houseNumber, int apartmentNumber) throws ServiceException;
    
    
    void changePassword(String userId, String currentPassword,
                        String newPassword, String confirmedPassword) throws ServiceException;
}
