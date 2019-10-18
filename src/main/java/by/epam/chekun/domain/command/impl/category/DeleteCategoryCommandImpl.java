package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_ID;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.REDIRECT_COMMAND;
import static by.epam.chekun.domain.configuration.JspActionCommand.VIEW_CATEGORIES_TABLE_COMMAND;
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
        final HttpSession session = request.getSession();
        try {
            categoryService.delete(categoryId);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        session.setAttribute(REDIRECT_COMMAND, VIEW_CATEGORIES_TABLE_COMMAND);
        return CATEGORY_TABLE_PAGE;
    }
}
