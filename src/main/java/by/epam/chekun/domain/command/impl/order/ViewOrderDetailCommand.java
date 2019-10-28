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

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.NEXT_PAGE;
import static by.epam.chekun.domain.configuration.JspFilePass.ORDER_DETAIL_PAGE;

public class ViewOrderDetailCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private OrderService orderService = ServiceManager.getInstance().getOrderService();


    public ViewOrderDetailCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final String orderId = request.getParameter(ORDER_ID);
        //   final String actionTypeAllOrders = request.getParameter(ACTION_TYPE_VIEW_ALL_ORDERS);
        final String nextPage = request.getParameter(NEXT_PAGE);
        try {
            final List<ProductOrder> productOrders = orderService.getAllProductsFromOrder(orderId);
            final Order order = orderService.getOrderById(orderId);

            //request.setAttribute(ACTION_TYPE_VIEW_ALL_ORDERS, actionTypeAllOrders);
            request.setAttribute(NEXT_PAGE, nextPage);
            request.setAttribute(ORDER_OBJECT, order);
            request.setAttribute(CURRENT_ORDER_STATUS_ID, order.getOrderStatus().getOrderStatusId());
            request.setAttribute(PRODUCTS_ORDER_ID, productOrders);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return ORDER_DETAIL_PAGE;
    }
}
