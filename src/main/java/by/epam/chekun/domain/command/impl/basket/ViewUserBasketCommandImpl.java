package by.epam.chekun.domain.command.impl.basket;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.basket.ProductBasket;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.service.BasketService;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.USER_ID;
import static by.epam.chekun.domain.configuration.JspFilePass.USER_BASKET_PAGE;

public class ViewUserBasketCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private BasketService basketService = ServiceManager.getInstance().getBasketService();
    private PaymentMethodService paymentMethodService = ServiceManager.getInstance().getPaymentMethodService();

    public ViewUserBasketCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute(USER_ID));

        try {
            final List<ProductBasket> productBasket = basketService.getAllProductInBasket(userId);

            final double productsCost = basketService.getCostOfProductsInBasket(userId);

            final List<PaymentMethod> paymentMethods = paymentMethodService.getAll();


            request.setAttribute("productsInBasket", productBasket);
            request.setAttribute("productsCost", productsCost);
            request.setAttribute("paymentMethods", paymentMethods);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return USER_BASKET_PAGE;
    }
}

