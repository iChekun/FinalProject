package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.product.InvalidProductInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.PRODUCT_TABLE_PAGE;

public class EditProductCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();

    public EditProductCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();

        final String categoryId = request.getParameter(CATEGORY_ID);
        final String brandId = request.getParameter(BRAND_ID);


        final String productId = request.getParameter(PRODUCT_ID);
        final String productName = request.getParameter(PRODUCT_NAME);
        final String productDescription = request.getParameter(PRODUCT_DESCRIPTION);
        final String productImagePath = request.getParameter(PRODUCT_IMAGE_PATH);
        final String productCost = (request.getParameter(PRODUCT_COST));


        try {
            productService.update(productId, productName, productDescription, productImagePath, productCost,
                    categoryId, brandId);
            session.setAttribute("redirectToCommand", "viewProductTable");
        } catch (InvalidProductInformationException ex) {
            session.setAttribute("errorMessage", "message.invalid_product_info");
            session.setAttribute("redirectToCommand", "viewEditProduct");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return PRODUCT_TABLE_PAGE;
    }
}
