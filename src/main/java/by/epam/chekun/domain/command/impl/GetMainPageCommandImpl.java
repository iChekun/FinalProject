package by.epam.chekun.domain.command.impl;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.entity.category.Category;
import by.epam.chekun.domain.service.CategoryService;
import by.epam.chekun.domain.service.exception.ServiceException;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.CATEGORY_LIST;
import static by.epam.chekun.domain.configuration.JspFilePass.MAIN_PAGE;

public class GetMainPageCommandImpl implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final CategoryService categoryService = ServiceManager.getInstance().getCategoryService();

    public GetMainPageCommandImpl(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() throws CommandException {
        try {
            final HttpSession session = request.getSession();
            final List<Category> categories = categoryService.getAll();
            session.setAttribute(CATEGORY_LIST, categories);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return MAIN_PAGE;
    }
}
