package by.epam.chekun.domain.command.impl.product;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_LIST;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_LIST;
import static by.epam.chekun.domain.configuration.JspFilePass.ADD_NEW_PRODUCT_PAGE;

public class ViewAddNewProductCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService productService = ServiceManager.getInstance().getProductService();
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewAddNewProductCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() {

        try {
            //1
            final List<Category> categories = categoryService.getAll();
            //2
            final List<Brand> brands = brandService.getAll();
            //3
            HttpSession session = request.getSession();

            session.setAttribute(CATEGORY_LIST, categories);
            session.setAttribute(BRAND_LIST, brands);

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        return ADD_NEW_PRODUCT_PAGE;
    }
}
