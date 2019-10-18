package by.epam.chekun.domain.command.impl.paymentmethod;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.paymentmethod.InvalidPaymentMethodInformationException;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.PAYMENT_METHOD_NAME;
import static by.epam.chekun.domain.configuration.JspFilePass.PAYMENT_METHOD_TABLE_PAGE;

public class AddNewPaymentMethodCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private PaymentMethodService paymentMethodService = ServiceManager.getInstance().getPaymentMethodService();

    public AddNewPaymentMethodCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        final HttpSession session = request.getSession();
        final String paymentMethodName = request.getParameter(PAYMENT_METHOD_NAME);

        try {
            paymentMethodService.addNewPaymentMethod(paymentMethodName);
        } catch (InvalidPaymentMethodInformationException e) {
            session.setAttribute("errorMessage", "message.invalid_payment_method_info");
        } catch (PaymentMethodServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute("redirectToCommand", "viewPaymentsMethodTable");

        return PAYMENT_METHOD_TABLE_PAGE;
    }
}
