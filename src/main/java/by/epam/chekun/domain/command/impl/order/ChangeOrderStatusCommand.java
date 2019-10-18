package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_ORDERS_HISTORY_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.ORDER_DETAIL_PAGE;

public class ChangeOrderStatusCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();


    public ChangeOrderStatusCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        final String orderId = request.getParameter(ORDER_ID);
        final String currentOrderStatusId = request.getParameter(CURRENT_ORDER_STATUS_ID);
        final HttpSession session = request.getSession();
        try {
            orderService.updateOrderStatus(orderId, currentOrderStatusId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        session.setAttribute(REDIRECT_COMMAND, VIEW_ORDERS_HISTORY_COMMAND);

        return ORDER_DETAIL_PAGE;
    }
}
