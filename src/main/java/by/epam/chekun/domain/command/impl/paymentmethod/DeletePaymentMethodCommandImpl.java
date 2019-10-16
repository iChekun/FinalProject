package by.epam.chekun.domain.command.impl.paymentmethod;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.JspFilePass.PAYMENT_METHOD_TABLE_PAGE;

public class DeletePaymentMethodCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private PaymentMethodService paymentMethodService = ServiceManager.getInstance().getPaymentMethodService();

    public DeletePaymentMethodCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final String paymentMethodId = request.getParameter("paymentMethodIdForAction");

        try {
            paymentMethodService.deletePaymentMethod(paymentMethodId);
        } catch (PaymentMethodServiceException e) {
            throw new CommandException(e);
        }

//        final String path = new ViewPaymentMethodTableCommandImpl(request, response).execute();
        return PAYMENT_METHOD_TABLE_PAGE;
    }
}
