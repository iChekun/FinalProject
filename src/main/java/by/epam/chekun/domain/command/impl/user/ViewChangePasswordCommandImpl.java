package by.epam.chekun.domain.command.impl.user;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;

public class ViewChangePasswordCommandImpl implements Command {


    @Override
    public String execute() throws CommandException {
        return "change_password";
    }
}
