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
import by.epam.chekun.domain.service.exception.product.ProductServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.NEXT_PAGE;

public class ViewProductsWithCategoryAndBrandCommand implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private final ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewProductsWithCategoryAndBrandCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final String categoryId = request.getParameter(CATEGORY_ID);
        final String brandId = request.getParameter(BRAND_ID);
        final String nextPage = request.getParameter(NEXT_PAGE);

        try {

            final List<Category> categories = categoryService.getAll();
            final List<Brand> brands = brandService.getAll();
            final List<Product> products = getProducts(categoryId, brandId);

            request.setAttribute(PRODUCT_LIST, products);
            request.setAttribute(CURRENT_BRAND_ID, brandId);
            request.setAttribute(CURRENT_CATEGORY_ID, categoryId);
            request.setAttribute(CATEGORY_LIST, categories);
            request.setAttribute(BRAND_LIST, brands);


        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return nextPage;
    }


    /**
     * Method check ids from table and returns correct list.
     */
    private List<Product> getProducts(String categoryId,
                                      String brandId) throws ProductServiceException {

        List<Product> products = null;

        if (categoryId != null && categoryId.equals("")) {
            categoryId = null;
        }
        if (brandId != null && brandId.equals("")) {
            brandId = null;
        }

        if (brandId == null && categoryId == null) {
            products = productService.getAll();
        } else if (brandId != null && categoryId != null) {
            products = productService.getAllByCategoryAndBrand(categoryId, brandId);
        } else if (brandId == null) {
            products = productService.getAllByCategory(categoryId);
        } else {
            products = productService.getAllByBrand(brandId);
        }

        return products;
    }

}
