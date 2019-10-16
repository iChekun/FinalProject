package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.USER_ID;

public class ViewOrdersHistoryCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();


    public ViewOrdersHistoryCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        HttpSession session = request.getSession();
        final String userId = String.valueOf(session.getAttribute(USER_ID));

        try {
            List<Order> orders = orderService.getAllUserOrdersByUserId(userId);

            request.setAttribute("orders", orders);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        return "orders_history";
    }
}
