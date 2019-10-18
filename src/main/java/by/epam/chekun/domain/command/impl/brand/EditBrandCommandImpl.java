package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.brand.InvalidBrandInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_BRANDS_TABLE_COMMAND;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_EDIT_BRAND_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.BRAND_TABLE_PAGE;

public class EditBrandCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public EditBrandCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        final HttpSession session = request.getSession();
        final String brandId = request.getParameter(BRAND_ID);
        final String brandName = request.getParameter(BRAND_NAME);
        final String brandDescription = request.getParameter(BRAND_DESCRIPTION);
        final String brandImagePath = request.getParameter(BRAND_IMAGE_PATH);


        try {
            brandService.update(brandId, brandName, brandDescription, brandImagePath);
            session.setAttribute(REDIRECT_COMMAND, VIEW_BRANDS_TABLE_COMMAND);
        } catch (InvalidBrandInformationException e) {
            session.setAttribute("ERROR_TO_JSP", "message.brand_invalid_info");
            session.setAttribute(REDIRECT_COMMAND, VIEW_EDIT_BRAND_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return BRAND_TABLE_PAGE;
    }
}
