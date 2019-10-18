package by.epam.chekun.domain.command.impl.paymentmethod;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.PAYMENT_METHOD_TABLE_PAGE;

public class ViewPaymentMethodTableCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PaymentMethodService paymentMethodService = ServiceManager.getInstance().getPaymentMethodService();

    public ViewPaymentMethodTableCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();
        try {
            List<PaymentMethod> paymentMethods = paymentMethodService.getAll();
            request.setAttribute(PAYMENT_METHODS_LIST, paymentMethods);

            if (session.getAttribute(ERROR_TO_JSP_PAYMENT_METHOD) != null) {
                String error = String.valueOf(session.getAttribute(ERROR_TO_JSP_PAYMENT_METHOD));
                request.setAttribute(ERROR_TO_JSP, error);
                session.removeAttribute(ERROR_TO_JSP_PAYMENT_METHOD);
            }
        } catch (PaymentMethodServiceException e) {
            throw new CommandException(e);
        }

        return PAYMENT_METHOD_TABLE_PAGE;
    }
}
