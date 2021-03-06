package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_FOR_ACTION;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_OBJECT;
import static by.epam.chekun.domain.configuration.JspFilePass.WORK_WITH_BRAND_PAGE;

public class ViewEditBrandCommand implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewEditBrandCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final String brandId = request.getParameter(BRAND_FOR_ACTION);
        try {
            final Brand brand = brandService.getById(brandId);
            request.setAttribute(BRAND_OBJECT, brand);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return WORK_WITH_BRAND_PAGE;
    }
}
