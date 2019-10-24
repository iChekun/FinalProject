package by.epam.chekun.domain.command.impl.product.table;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.PRODUCT_TABLE_PAGE;

public class ViewProductsTableCommand implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewProductsTableCommand(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        HttpSession session = request.getSession();

        try {
            final List<Category> categories = categoryService.getAll();
            request.setAttribute(CATEGORY_LIST, categories);
        } catch (ServiceException ignore) { /*NOP*/}

        //2
        try {
            final List<Brand> brands = brandService.getAll();
            request.setAttribute(BRAND_LIST, brands);
        } catch (ServiceException ignore) { /*NOP*/}

        try {
            final List<Product> products = productService.getAll();
            request.setAttribute(PRODUCT_LIST, products);
        } catch (ServiceException ignore) { /*NOP*/}

        if (session.getAttribute(ERROR_TO_JSP_PRODUCT) != null) {
            String error = String.valueOf(session.getAttribute("errorMessageProduct"));
            request.setAttribute(ERROR_MESSAGE_TO_JSP, error);
            session.removeAttribute(ERROR_TO_JSP_PRODUCT);
        }
        return PRODUCT_TABLE_PAGE;
    }
}
