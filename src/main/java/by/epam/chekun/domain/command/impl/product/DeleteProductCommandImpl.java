package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.product.table.ViewProductsTableCommandImpl;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.PRODUCT_ID;
import static by.epam.chekun.domain.configuration.JspFilePass.PRODUCT_TABLE_PAGE;

public class DeleteProductCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();

    public DeleteProductCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final String productId = request.getParameter("productForAction");

        try {
            productService.delete(productId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

       // String path = new ViewProductsTableCommandImpl(request, response).execute();
        return PRODUCT_TABLE_PAGE;
    }
}
