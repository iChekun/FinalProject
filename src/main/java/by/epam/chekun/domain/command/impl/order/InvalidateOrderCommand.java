package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.order.OrderServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_ORDERS_HISTORY_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.ORDERS_HISTORY_PAGE;

public class InvalidateOrderCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();


    public InvalidateOrderCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final String orderId = request.getParameter(ORDER_ID);
        try {
            final Order order = orderService.getOrderById(orderId);
            if (order.getOrderStatus().getOrderStatusId().equals(OPEN_ORDER_STATUS_ID)) {
                orderService.invalidateOrder(orderId);
                session.setAttribute(MESSAGE_TO_ORDERS_HISTORY, "message.order_invalidate");
            } else {
                session.setAttribute(MESSAGE_TO_ORDERS_HISTORY, "message.order.cant_close_closed_order");
            }
        } catch (OrderServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_ORDERS_HISTORY_COMMAND);
        return ORDERS_HISTORY_PAGE;
    }
}
