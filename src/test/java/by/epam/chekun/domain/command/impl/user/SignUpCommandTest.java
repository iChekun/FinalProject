package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.user.InvalidLoginException;
import by.epam.chekun.domain.service.exception.user.UserServiceException;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class SignUpCommandTest {


    @Test
    public void testExecute_signUp_correct() throws UserServiceException, CommandException {
        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponce = mock(HttpServletResponse.class);
        UserService userService = mock(UserService.class);
        HttpSession session = mock(HttpSession.class);
        //
        Command command = new SignUpCommand(mockRequest, mockResponce, userService);
        //when
        when(mockRequest.getParameter("login")).thenReturn("login");
        when(mockRequest.getParameter("password")).thenReturn("password");
        when(mockRequest.getParameter("confirmedPassword")).thenReturn("confirmedPassword");
        when(mockRequest.getParameter("name")).thenReturn("name");
        when(mockRequest.getParameter("surname")).thenReturn("surname");
        when(mockRequest.getParameter("birthDate")).thenReturn("2019-09-09");
        when(mockRequest.getParameter("email")).thenReturn("email");
        when(mockRequest.getParameter("phoneNumber")).thenReturn("1234");
        when(mockRequest.getParameter("country")).thenReturn("login");
        when(mockRequest.getParameter("city")).thenReturn("login");
        when(mockRequest.getParameter("street")).thenReturn("phoneNumber");
        when(mockRequest.getParameter("houseNumber")).thenReturn("12");
        when(mockRequest.getParameter("apartmentNumber")).thenReturn("12");
        when(mockRequest.getSession()).thenReturn(session);
        doThrow(InvalidLoginException.class).when(userService).add(
                anyString(), anyString(), anyString(),
                anyString(), anyString(), anyObject(),
                anyString(), anyString(),
                anyString(), anyString(), anyString(),
                anyInt(), anyInt());
        String result = command.execute();
        //then
        assertEquals(result, "signUp");
    }


    @Test(expectedExceptions = CommandException.class)
    public void testExecute_signUp_badLogin() throws UserServiceException, CommandException {
        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponce = mock(HttpServletResponse.class);
        UserService userService = mock(UserService.class);
        HttpSession session = mock(HttpSession.class);
        //
        Command command = new SignUpCommand(mockRequest, mockResponce, userService);
        //when
        when(mockRequest.getParameter("login")).thenReturn("1");
        when(mockRequest.getParameter("password")).thenReturn("password");
        when(mockRequest.getParameter("confirmedPassword")).thenReturn("confirmedPassword");
        when(mockRequest.getParameter("name")).thenReturn("name");
        when(mockRequest.getParameter("surname")).thenReturn("surname");
        when(mockRequest.getParameter("birthDate")).thenReturn("2019-09-09");
        when(mockRequest.getParameter("email")).thenReturn("email");
        when(mockRequest.getParameter("phoneNumber")).thenReturn("1234");
        when(mockRequest.getParameter("country")).thenReturn("login");
        when(mockRequest.getParameter("city")).thenReturn("login");
        when(mockRequest.getParameter("street")).thenReturn("phoneNumber");
        when(mockRequest.getParameter("houseNumber")).thenReturn("12");
        when(mockRequest.getParameter("apartmentNumber")).thenReturn("12");
        when(mockRequest.getSession()).thenReturn(session);
        //
        doThrow(CommandException.class).when(userService).add(
                anyString(), anyString(), anyString(),
                anyString(), anyString(), anyObject(),
                anyString(), anyString(),
                anyString(), anyString(), anyString(),
                anyInt(), anyInt());
        String result = command.execute();
        //then

        //exception

    }

}