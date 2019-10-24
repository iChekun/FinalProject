package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.JspFilePass.SIGN_UP_PAGE;

public class SignUpWindowCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public SignUpWindowCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }



    @Override
    public String execute() {
        return SIGN_UP_PAGE;
    }
}
