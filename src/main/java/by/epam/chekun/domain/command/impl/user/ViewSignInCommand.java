package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;

import static by.epam.chekun.domain.configuration.JspFilePass.SIGN_IN_PAGE;

public class ViewSignInCommand implements Command {

    public ViewSignInCommand() {
    }

    @Override
    public String execute() {
        return SIGN_IN_PAGE;
    }
}
