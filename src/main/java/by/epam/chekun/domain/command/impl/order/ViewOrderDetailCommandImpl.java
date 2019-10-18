package by.epam.chekun.domain.command.impl.order;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.order.Order;
import by.epam.chekun.domain.entity.order.ProductOrder;
import by.epam.chekun.domain.service.OrderService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewOrderDetailCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();


    public ViewOrderDetailCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final String orderId = request.getParameter("orderId");

        try {
            final List<ProductOrder> productOrders = orderService.getAllProductsFromOrder(orderId);
            final Order order = orderService.getOrderById(orderId);

            request.setAttribute("orderId", orderId);
            request.setAttribute("currentOrderStatusId", order.getOrderStatus().getOrderStatusId());
            request.setAttribute("productOrders", productOrders);

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            throw new CommandException(e);
        }

        return "order_detail";
    }
}
