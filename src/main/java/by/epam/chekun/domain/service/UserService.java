package by.epam.chekun.domain.service;

import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.UserServiceException;

import java.sql.Date;
import java.util.List;

public interface UserService {


    User getById(String userId) throws UserServiceException;
    
    List<User> getAll() throws UserServiceException;

    List<User> getAllUsersSorted(String sortedBy, String sortType) throws UserServiceException;

    void changeBanStatus(String userId) throws UserServiceException;

    void changeUserStatus(String userId) throws UserServiceException;

    void update(String userId, int userStatusId, boolean banned,
                String login,
                String name, String surname, Date birthDate,
                String contactsId, String email, String phoneNumber,
                String country, String city, String street,
                int houseNumber, int apartmentNumber) throws UserServiceException;


    User signIn(String login, String password) throws UserServiceException;

    void add(String login, String password, String confirmedPassword,
             String name, String surname, Date birthDate,
             String email, String phoneNumber,
             String country, String city, String street,
             int houseNumber, int apartmentNumber) throws UserServiceException;
    
    
    void changePassword(String userId, String currentPassword,
                        String newPassword, String confirmedPassword) throws UserServiceException;
}
