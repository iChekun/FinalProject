package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.exception.category.InvalidCategoryInformationException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;

public class AddNewCategoryCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public AddNewCategoryCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
        final HttpSession session = request.getSession();
        final String categoryName = request.getParameter(CATEGORY_NAME);
        final String categoryDescription = request.getParameter(CATEGORY_DESCRIPTION);
        final String categoryImagePath = request.getParameter(CATEGORY_IMAGE_PATH);

        try {
            categoryService.add(categoryName, categoryDescription, categoryImagePath);

        } catch (InvalidCategoryInformationException e) {
            session.setAttribute("errorMessage", "message.category_invalid_info");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute("redirectToCommand", "viewCategoriesTable");
        return "category_table";

    }
}
