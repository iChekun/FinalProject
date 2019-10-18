package by.epam.chekun.domain.command.impl.basket;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.USER_ID;
import static by.epam.chekun.domain.configuration.JspFilePass.CUSTOMER_PRODUCT_PAGE;

public class AddProductToBasketCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private BasketService basketService = ServiceManager.getInstance().getBasketService();

    public AddProductToBasketCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute(USER_ID));

        if (!(userId == null || userId.equals("null"))) {
            String productId = request.getParameter("productForAction");

            try {
                basketService.addProductToBasket(userId, productId);
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        } else {
            session.setAttribute("errorMessage", "message.need_to_signIn_or_signUp");
        }

        session.setAttribute("redirectToCommand", "viewCustomerProductTable");
        return CUSTOMER_PRODUCT_PAGE;
    }
}
