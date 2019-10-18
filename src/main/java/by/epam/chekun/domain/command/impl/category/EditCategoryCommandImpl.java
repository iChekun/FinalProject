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
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_CATEGORIES_TABLE_COMMAND;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_EDIT_CATEGORY_COMMAND;
import static by.epam.chekun.domain.configuration.JspFilePass.WORK_WITH_CATEGORY_PAGE;

public class EditCategoryCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public EditCategoryCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        HttpSession session = request.getSession();

        final String categoryId = request.getParameter(CATEGORY_ID);
        final String categoryName = request.getParameter(CATEGORY_NAME);
        final String categoryDescription = request.getParameter(CATEGORY_DESCRIPTION);
        final String categoryImagePath = request.getParameter(CATEGORY_IMAGE_PATH);

        try {
            categoryService.update(categoryId, categoryName, categoryDescription, categoryImagePath);
            session.setAttribute(REDIRECT_COMMAND, VIEW_CATEGORIES_TABLE_COMMAND);
        } catch (InvalidCategoryInformationException ex) {
            session.setAttribute(ERROR_TO_JSP, "message.category_invalid_info");
            session.setAttribute(REDIRECT_COMMAND, VIEW_EDIT_CATEGORY_COMMAND);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return WORK_WITH_CATEGORY_PAGE;

    }
}
