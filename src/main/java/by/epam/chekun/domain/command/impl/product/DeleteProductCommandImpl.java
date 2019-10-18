package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        final HttpSession session = request.getSession();
        final String productId = request.getParameter("productId");

        try {
            productService.delete(productId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute("redirectToCommand", "viewProductTable");
        return PRODUCT_TABLE_PAGE;
    }
}
