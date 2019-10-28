package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.util.CheckMessage;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.MESSAGE_TO_ORDERS_HISTORY;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.ORDERS_LIST;
import static by.epam.chekun.domain.configuration.JspFilePass.ORDERS_HISTORY_PAGE;

public class ViewAllOrdersHistoryCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();
    private UserService userService = ServiceManager.getInstance().getUserService();

    public ViewAllOrdersHistoryCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();

        try {
            final List<Order> orders = orderService.getAllOrders();

            request.setAttribute(ORDERS_LIST, orders);
            CheckMessage.checkMessageToJsp(session, request, MESSAGE_TO_ORDERS_HISTORY);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return ORDERS_HISTORY_PAGE;
    }
}
