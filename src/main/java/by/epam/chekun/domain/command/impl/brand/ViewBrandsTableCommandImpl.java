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
import static by.epam.chekun.domain.configuration.JspFilePass.BRAND_TABLE_PAGE;

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

        try {
            List<Brand> brands = brandService.getAll();
            request.setAttribute(BRAND_LIST, brands);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return "brand_table";
    }
}