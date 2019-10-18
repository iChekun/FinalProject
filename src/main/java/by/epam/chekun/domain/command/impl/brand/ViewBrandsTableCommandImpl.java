package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_LIST;

public class ViewBrandsTableCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewBrandsTableCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();
        try {
            List<Brand> brands = brandService.getAll();
            request.setAttribute(BRAND_LIST, brands);

            if (session.getAttribute("errorMessageBrand") != null) {
                String error = String.valueOf(session.getAttribute("errorMessageBrand"));
                request.setAttribute("errorMessage", error);
                session.removeAttribute("errorMessageBrand");
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return "brand_table";
    }
}