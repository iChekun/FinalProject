package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_ID;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_OBJECT;
import static by.epam.chekun.domain.configuration.JspFilePass.WORK_WITH_CATEGORY_PAGE;

public class ViewEditCategoryCommand implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public ViewEditCategoryCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        final String categoryId = request.getParameter(CATEGORY_ID);

        try {
            final Category category = categoryService.getById(categoryId);
            request.setAttribute(CATEGORY_OBJECT, category);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return WORK_WITH_CATEGORY_PAGE;
    }
}
