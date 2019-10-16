package by.epam.chekun.domain.command.impl.paymentmethod;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;

import static by.epam.chekun.domain.configuration.JspFilePass.ADD_NEW_PAYMENT_METHOD_PAGE;

public class ViewAddNewPaymentMethodCommandImpl implements Command {


    @Override
    public String execute() throws CommandException {
        return ADD_NEW_PAYMENT_METHOD_PAGE;
    }
}
