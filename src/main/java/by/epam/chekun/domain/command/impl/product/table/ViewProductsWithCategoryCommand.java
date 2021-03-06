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
import static by.epam.chekun.domain.configuration.JspFilePass.CUSTOMER_PRODUCT_PAGE;

public class ViewProductsWithCategoryCommand implements Command {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewProductsWithCategoryCommand(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        try {
            //1
            final String categoryId = request.getParameter(CATEGORY_ID);
            final List<Product> products = productService.getAllByCategory(categoryId);
            final List<Category> categories = categoryService.getAll();
            //2
            final List<Brand> brands = brandService.getAll();
            //3

            request.setAttribute(CURRENT_BRAND_ID, null);
            request.setAttribute(CURRENT_CATEGORY_ID, categoryId);
            request.setAttribute(CATEGORY_LIST, categories);
            request.setAttribute(BRAND_LIST, brands);
            request.setAttribute(PRODUCT_LIST, products);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return CUSTOMER_PRODUCT_PAGE;
    }
}
