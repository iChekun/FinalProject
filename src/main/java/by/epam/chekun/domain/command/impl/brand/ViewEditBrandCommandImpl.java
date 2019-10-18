package by.epam.chekun.domain.command.impl.brand;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.brand.Brand;
import by.epam.chekun.domain.service.BrandService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditBrandCommandImpl implements Command {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private BrandService brandService = ServiceManager.getInstance().getBrandService();

    public ViewEditBrandCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        String brandId2 = request.getParameter("brandForAction");

        try {
            Brand brand = brandService.getById(brandId2);
            request.setAttribute("brand", brand);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return "work_with_brand";
    }
}
