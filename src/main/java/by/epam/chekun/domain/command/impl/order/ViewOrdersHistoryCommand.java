package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.user.User;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.ORDERS_HISTORY_PAGE;

public class ViewOrdersHistoryCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();
    private UserService userService = ServiceManager.getInstance().getUserService();

    public ViewOrdersHistoryCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final String userId = String.valueOf(session.getAttribute(USER_ID));

        try {
            final List<Order> orders = orderService.getAllUserOrdersByUserId(userId);
            final User user = userService.getById(userId);
            request.setAttribute(USER_OBJECT, user);
            request.setAttribute(ORDERS_LIST, orders);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return ORDERS_HISTORY_PAGE;
    }
}
