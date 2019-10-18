package by.epam.chekun.domain.command.impl.paymentmethod;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.PAYMENT_METHOD_FOR_ACTION;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.REDIRECT_COMMAND;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_PAYMENT_METHOD_TABLE_COMMAND;
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
        final HttpSession session = request.getSession();
        final String paymentMethodId = request.getParameter(PAYMENT_METHOD_FOR_ACTION);

        try {
            paymentMethodService.deletePaymentMethod(paymentMethodId);
        } catch (PaymentMethodServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_PAYMENT_METHOD_TABLE_COMMAND);
        return PAYMENT_METHOD_TABLE_PAGE;
    }
}
