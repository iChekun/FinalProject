package by.epam.chekun.domain.command.impl.product;

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

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_LIST;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_LIST;

public class ViewEditProductCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewEditProductCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

//        HttpSession session = request.getSession();

        final String productId = request.getParameter("productForAction");


        try {


            final Product product = productService.getById(productId);
            //1
            final List<Category> categories = categoryService.getAll();
            //2
            final List<Brand> brands = brandService.getAll();
            //3

            System.out.println(product.getCategory().getCategoryId());

            request.setAttribute(CATEGORY_LIST, categories);
            request.setAttribute(BRAND_LIST, brands);

            request.setAttribute("product", product);
            request.setAttribute("currentCategoryId", product.getCategory().getCategoryId());
            request.setAttribute("currentBrandId", product.getBrand().getBrandId());

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return "work_with_product";
    }
}
