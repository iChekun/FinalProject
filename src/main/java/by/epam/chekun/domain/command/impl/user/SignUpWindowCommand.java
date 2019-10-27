package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.impl.util.CheckMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.MESSAGE_TO_SIGN_UP;
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
        final HttpSession session = request.getSession();
        CheckMessage.checkMessageToJsp(session, request, MESSAGE_TO_SIGN_UP);
        return SIGN_UP_PAGE;
    }
}
