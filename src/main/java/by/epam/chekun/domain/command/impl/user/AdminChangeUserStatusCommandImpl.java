package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.service.UserService;
import by.epam.chekun.domain.service.manager.ServiceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.JspFilePass.USERS_TABLE_PAGE;

public class AdminChangeUserStatusCommandImpl implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private UserService service = ServiceManager.getInstance().getUserService();

    public AdminChangeUserStatusCommandImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    @Override
    public String execute() throws CommandException {
//        try {
//            String userIdForAction = String.valueOf(request.getParameter("userForAction"));
//            System.out.println("choosed req= " + userIdForAction);
////            service.updateUserStatus(userIdForAction,);
//        } catch (ServiceException ex) {
//            System.out.println(ex.getMessage());
//        }

//        return new ViewUsersTableCommandImpl(request, response).execute();
        return USERS_TABLE_PAGE;
    }
}
