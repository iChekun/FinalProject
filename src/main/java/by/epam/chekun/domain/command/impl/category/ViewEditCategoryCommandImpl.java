package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_ID;

public class ViewEditCategoryCommandImpl implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public ViewEditCategoryCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        HttpSession session = request.getSession();

        final String categoryId = request.getParameter(CATEGORY_ID);

        try {
            Category category = categoryService.getById(categoryId);
            session.setAttribute("category", category);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }


        return "work_with_category";
    }
}
