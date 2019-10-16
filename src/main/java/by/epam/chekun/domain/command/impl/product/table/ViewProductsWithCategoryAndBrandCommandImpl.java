package by.epam.chekun.domain.command.impl.product.table;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.product.Product;
import by.epam.chekun.domain.service.ProductService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_ID;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_ID;
import static by.epam.chekun.domain.configuration.JspFilePass.CUSTOMER_PRODUCT_PAGE;

public class ViewProductsWithCategoryAndBrandCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private ProductService service = ServiceManager.getInstance().getProductService();

    public ViewProductsWithCategoryAndBrandCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();

        final String categoryId = request.getParameter(CATEGORY_ID);
        final String brandId = request.getParameter(BRAND_ID);

        System.out.println(categoryId);
        System.out.println(brandId);

        try {
            List<Product> products = service.getAllByCategoryAndBrand(categoryId, brandId);
            session.setAttribute("products", products);
            session.setAttribute("currentBrandId", brandId);
            session.setAttribute("currentCategoryId", categoryId);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }


//        return new ViewCustomerProductTableCommandImpl(request, response).execute();
        return CUSTOMER_PRODUCT_PAGE;
    }
}
