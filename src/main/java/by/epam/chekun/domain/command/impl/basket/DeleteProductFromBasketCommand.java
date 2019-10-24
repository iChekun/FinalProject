package by.epam.chekun.domain.command.impl.basket;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_USER_BASKET_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_BASKET_PAGE;

public class DeleteProductFromBasketCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private BasketService basketService = ServiceManager.getInstance().getBasketService();

    public DeleteProductFromBasketCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        final HttpSession session = request.getSession();

        final String basketId = String.valueOf(session.getAttribute(BASKET_ID));
        final String productId = request.getParameter(PRODUCT_FOR_ACTION);

        try {
            basketService.deleteProductFromBasket(basketId, productId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_USER_BASKET_COMMAND);
        return USER_BASKET_PAGE;
    }
}
