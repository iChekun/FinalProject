package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.JspFilePass.MAIN_PAGE;

public class LogoutCommand implements Command {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public LogoutCommand(final HttpServletRequest request, final HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() {
        request.getSession().invalidate();
        return MAIN_PAGE;
    }
}
