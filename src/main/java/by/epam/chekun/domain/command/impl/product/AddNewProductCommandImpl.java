package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.product.table.ViewProductsTableCommandImpl;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.product.InvalidProductInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.PRODUCT_TABLE_PAGE;

public class AddNewProductCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService service = ServiceManager.getInstance().getProductService();

    public AddNewProductCommandImpl(HttpServletRequest request, HttpServletResponse response) {
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
            session.setAttribute("workWithProductMessage", "message.invalid_product_info");
            return "work_with_product";
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
       // String path = new ViewProductsTableCommandImpl(request, response).execute();
        return PRODUCT_TABLE_PAGE;
    }
}
