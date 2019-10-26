package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.impl.util.CheckMessage;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_LIST;
import static by.epam.chekun.domain.configuration.BeanFieldJsp.MESSAGE_TO_JSP_CATEGORY;
import static by.epam.chekun.domain.configuration.JspFilePass.CATEGORY_TABLE_PAGE;

public class ViewCategoriesTableCommand implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public ViewCategoriesTableCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {

        try {
            final HttpSession session = request.getSession();
            final List<Category> categories = categoryService.getAll();
            request.setAttribute(CATEGORY_LIST, categories);

            CheckMessage.checkMessageToJsp(session, request, MESSAGE_TO_JSP_CATEGORY);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return CATEGORY_TABLE_PAGE;
    }
}
