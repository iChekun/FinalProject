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
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_PRODUCTS_TABLE_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.PRODUCT_TABLE_PAGE;

public class AddNewProductCommand implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService service = ServiceManager.getInstance().getProductService();

    public AddNewProductCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final String categoryId = request.getParameter(CATEGORY_ID);
        final String brandId = request.getParameter(BRAND_ID);

        final String productName = request.getParameter(PRODUCT_NAME);
        final String productDescription = request.getParameter(PRODUCT_DESCRIPTION);
        final String productImagePath = request.getParameter(PRODUCT_IMAGE_PATH);
        final String productCost = (request.getParameter(PRODUCT_COST));


        try {
            service.add(productName, productDescription, productImagePath, productCost,
                    categoryId, brandId);
        } catch (InvalidProductInformationException e) {
            session.setAttribute(MESSAGE_TO_JSP_PRODUCT, "message.invalid_product_info");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_PRODUCTS_TABLE_COMMAND);
        return PRODUCT_TABLE_PAGE;
    }
}
