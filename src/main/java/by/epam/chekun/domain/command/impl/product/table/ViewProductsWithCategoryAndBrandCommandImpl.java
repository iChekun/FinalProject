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
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.CUSTOMER_PRODUCT_PAGE;

public class ViewProductsWithCategoryAndBrandCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewProductsWithCategoryAndBrandCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final String categoryId = request.getParameter(CATEGORY_ID);
        final String brandId = request.getParameter(BRAND_ID);

        try {

            final List<Category> categories = categoryService.getAll();
            final List<Brand> brands = brandService.getAll();

            List<Product> products = null;
            if (categoryId != null && brandId != null) {
                products = productService.getAllByCategoryAndBrand(categoryId, brandId);
            } else if (brandId == null) {
                products = productService.getAllByCategory(categoryId);
            } else {
                products = productService.getAllByBrand(brandId);
            }

            request.setAttribute("products", products);
            request.setAttribute("currentBrandId", brandId);
            request.setAttribute("currentCategoryId", categoryId);
            request.setAttribute(CATEGORY_LIST, categories);
            request.setAttribute(BRAND_LIST, brands);


        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return CUSTOMER_PRODUCT_PAGE;
    }
}
