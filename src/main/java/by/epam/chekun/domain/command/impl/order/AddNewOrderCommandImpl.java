package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_USER_BASKET_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_BASKET_PAGE;

public class AddNewOrderCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();
    private final BasketService basketService = ServiceManager.getInstance().getBasketService();

    public AddNewOrderCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();

        try {
            final String basketId = String.valueOf(session.getAttribute(BASKET_ID));

            if (basketService.getProductCountInBasket(basketId) > 0) {
                final String userId = String.valueOf(session.getAttribute(USER_ID));

                //paymentMethodId
                final String paymentMethodId = request.getParameter(PAYMENT_METHOD_ID);
                //

                //
                orderService.add(userId, paymentMethodId, basketId);


                session.setAttribute(ERROR_TO_JSP, "order.message.sessusful");
            } else {
                session.setAttribute(ERROR_TO_JSP, "order.message.buy_something");
            }
        } catch (ServiceException e) {
            session.setAttribute(ERROR_TO_JSP, "order.message.bad");
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_USER_BASKET_COMMAND);
        return USER_BASKET_PAGE;
    }
}
