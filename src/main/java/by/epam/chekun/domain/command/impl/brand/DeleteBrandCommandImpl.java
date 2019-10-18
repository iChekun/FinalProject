package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_ID;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.REDIRECT_COMMAND;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_BRANDS_TABLE_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.BRAND_TABLE_PAGE;

public class DeleteBrandCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public DeleteBrandCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        final String brandId = request.getParameter(BRAND_ID);
        final HttpSession session = request.getSession();
        try {
            brandService.delete(brandId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_BRANDS_TABLE_COMMAND);
        return BRAND_TABLE_PAGE;
    }
}
