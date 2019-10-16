package by.epam.chekun.domain.command.impl.category;

import by.epam.chekun.domain.command.Command;

import static by.epam.chekun.domain.configuration.JspFilePass.ADD_NEW_CATEGORY_PAGE;

public class ViewAddNewCategoryCommandImpl implements Command {

    @Override
    public String execute() {
        return ADD_NEW_CATEGORY_PAGE;
    }
}
