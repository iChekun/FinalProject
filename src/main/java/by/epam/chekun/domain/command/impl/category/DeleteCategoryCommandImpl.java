package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_ID;
import static by.epam.chekun.domain.configuration.JspFilePass.CATEGORY_TABLE_PAGE;

public class DeleteCategoryCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public DeleteCategoryCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {

        final String categoryId = request.getParameter(CATEGORY_ID);

        try {
            categoryService.delete(categoryId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

      //  final String path = new ViewCategoriesTableCommandImpl(request, response).execute();
        return CATEGORY_TABLE_PAGE;
    }
}
