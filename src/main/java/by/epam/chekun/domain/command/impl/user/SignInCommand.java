package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.basket.Basket;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.user.BannedUserServiceException;
import by.epam.chekun.domain.service.exception.user.InvalidUserInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.MAIN_PAGE;

public class SignInCommand implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final UserService userService;
    private final BasketService basketService;

    public SignInCommand(final HttpServletRequest request,
                         final HttpServletResponse response) {
        this(ServiceManager.getInstance().getUserService(),
                ServiceManager.getInstance().getBasketService(),
                request, response);
    }

    public SignInCommand(UserService userService, BasketService basketService,
                         final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.userService = userService;
        this.basketService = basketService;
    }

    @Override
    public String execute() throws CommandException {

        final String login = request.getParameter(USER_LOGIN);
        final String password = request.getParameter(USER_PASSWORD);

        final HttpSession session = request.getSession();

        try {
            final User user = userService.signIn(login, password);
            ///
            session.setAttribute(USER_ID, user.getUserId());
            session.setAttribute(USER_STATUS_ID, user.getUserStatus().getUserStatusId());
            ///
            basketService.createBasket(user.getUserId());

            final Basket basket = basketService.getBasket(user.getUserId());

            final String basketId = basket.getBasketId();

            session.setAttribute(BASKET_ID, basketId);
            session.setAttribute(MESSAGE_TO_JSP, "message.successful_login");
        } catch (BannedUserServiceException ex) {
            session.setAttribute(MESSAGE_TO_JSP, "message.user_is_banned");
        } catch (InvalidUserInformationException ex) {
            session.setAttribute(MESSAGE_TO_JSP, "message.invalid_sign_parameters");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return MAIN_PAGE;
    }
}
