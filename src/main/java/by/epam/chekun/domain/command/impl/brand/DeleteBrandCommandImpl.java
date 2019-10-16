package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.BRAND_ID;

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

        try {
            brandService.delete(brandId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        //return new ViewBrandsTableCommandImpl(request, response).execute();
        return "brand_table";
    }
}
