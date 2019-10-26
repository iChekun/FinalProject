package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.util.CheckMessage;
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
import static by.epam.chekun.domain.configuration.JspFilePass.WORK_WITH_PRODUCT_PAGE;

public class ViewEditProductCommand implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewEditProductCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        final String productId = request.getParameter(PRODUCT_FOR_ACTION);

        try {

            final Product product = productService.getById(productId);
            //1
            final List<Category> categories = categoryService.getAll();
            //2
            final List<Brand> brands = brandService.getAll();
            //3

            request.setAttribute(CATEGORY_LIST, categories);
            request.setAttribute(BRAND_LIST, brands);

            request.setAttribute(PRODUCT_OBJECT, product);
            request.setAttribute(CURRENT_CATEGORY_ID, product.getCategory().getCategoryId());
            request.setAttribute(CURRENT_BRAND_ID, product.getBrand().getBrandId());

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return WORK_WITH_PRODUCT_PAGE;
    }
}
