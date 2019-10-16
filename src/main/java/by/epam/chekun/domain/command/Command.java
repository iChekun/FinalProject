package by.epam.chekun.domain.command;

import by.epam.chekun.domain.command.exception.CommandException;

public interface Command {

    String execute() throws CommandException;
}
