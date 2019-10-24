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

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.BRAND_TABLE_PAGE;

public class ViewBrandsTableCommand implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewBrandsTableCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        final HttpSession session = request.getSession();
        try {
            final List<Brand> brands = brandService.getAll();
            request.setAttribute(BRAND_LIST, brands);

            if (session.getAttribute(ERROR_TO_JSP_BRAND) != null) {
                final String error = String.valueOf(session.getAttribute(ERROR_TO_JSP_BRAND));
                request.setAttribute(ERROR_MESSAGE_TO_JSP, error);
                session.removeAttribute(ERROR_TO_JSP_BRAND);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return BRAND_TABLE_PAGE;
    }
}