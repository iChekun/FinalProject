package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.entity.user.UserStatus;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.BannedUserServiceException;
import by.epam.chekun.domain.service.exception.user.InvalidUserInformationException;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.JspFilePass.MAIN_PAGE;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class SignInCommandImplTest {

    @Test(expectedExceptions = CommandException.class)
    public void testExecute_exceptionFromService_CommandException() throws CommandException, ServiceException {

        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponce = mock(HttpServletResponse.class);
        UserService userService = mock(UserService.class);
        BasketService basketService = mock(BasketService.class);
        Command command = new SignInCommandImpl(userService, basketService, mockRequest, mockResponce);
        //when
        when(mockRequest.getParameter("login")).thenReturn("userName");
        when(mockRequest.getParameter("password")).thenReturn("password");
        doThrow(ServiceException.class).when(userService).signIn(anyString(), anyString());
        command.execute();
        //then
        //assert exception
    }


    @Test
    public void testExecute_bannedUserExceptionFromSignIn_main() throws ServiceException, CommandException {
        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponce = mock(HttpServletResponse.class);
        UserService service = mock(UserService.class);
        BasketService basketService = mock(BasketService.class);
        User user = mock(User.class);
        UserStatus userStatus = UserStatus.ADMIN;
        HttpSession session = mock(HttpSession.class);
        Command command = new SignInCommandImpl(service, basketService, mockRequest, mockResponce);
        //when
        when(mockRequest.getParameter("username")).thenReturn("Username");
        when(mockRequest.getParameter("password")).thenReturn("Password");
        when(mockRequest.getSession()).thenReturn(session);
        doReturn(user).when(service).signIn(anyString(), anyString());
        when(user.getUserStatus()).thenReturn(userStatus);
        doThrow(BannedUserServiceException.class).when(service).signIn(anyString(), anyString());
        String result = command.execute();
        //then
        assertEquals(result, MAIN_PAGE);
    }

    @Test
    public void execute_invalidUserInformationExceptionFromSignIn_index() throws ServiceException, CommandException {
        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
        UserService service = mock(UserService.class);
        BasketService basketService = mock(BasketService.class);
        User user = mock(User.class);
        UserStatus userStatus = UserStatus.ADMIN;
        HttpSession session = mock(HttpSession.class);
        Command command = new SignInCommandImpl(service, basketService, mockRequest, mockResponse);
        //when
        when(mockRequest.getParameter("username")).thenReturn("Username");
        when(mockRequest.getParameter("password")).thenReturn("Password");
        when(mockRequest.getSession()).thenReturn(session);
        doReturn(user).when(service).signIn(anyString(), anyString());
        when(user.getUserStatus()).thenReturn(userStatus);
        doThrow(InvalidUserInformationException.class).when(service).signIn(anyString(), anyString());
        String result = command.execute();
        //then
        assertEquals(result, MAIN_PAGE);
    }


    @Test
    public void execute_validParameters_main() throws ServiceException, CommandException {
        //given
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
        UserService service = mock(UserService.class);
        BasketService basketService = mock(BasketService.class);
        User user = mock(User.class);
        UserStatus userStatus = UserStatus.ADMIN;
        HttpSession session = mock(HttpSession.class);
        Basket mockBasket = mock(Basket.class);
        Command command = new SignInCommandImpl(service, basketService, mockRequest, mockResponse);
        //when
        when(mockRequest.getParameter("username")).thenReturn("Username");
        when(mockRequest.getParameter("password")).thenReturn("Password");
        when(mockRequest.getSession()).thenReturn(session);
        when(service.signIn(anyString(), anyString())).thenReturn(user);
        when(user.getUserStatus()).thenReturn(userStatus);
//        doNothing().when(basketService).createBasket("userId");
        when(basketService.getBasket(user.getUserId())).thenReturn(mockBasket);
        when(mockBasket.getBasketId()).thenReturn("basketId");

        String result = command.execute();
        //then
        assertEquals(result, MAIN_PAGE);
    }
}