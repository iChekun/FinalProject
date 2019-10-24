package by.epam.chekun.domain.command.factory.impl;

import static org.testng.Assert.*;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.factory.CommandFactory;
import by.epam.chekun.domain.command.impl.basket.AddProductToBasketCommand;
import by.epam.chekun.domain.command.impl.brand.AddNewBrandCommand;
import by.epam.chekun.domain.command.impl.user.SignInCommand;
import by.epam.chekun.domain.command.impl.user.ViewUserCabinetCommand;
import org.testng.annotations.Test;

import static by.epam.chekun.domain.configuration.JspActionCommand.*;

public class CommandFactoryImplTest {

    private CommandFactory factory = CommandFactoryImpl.getInstance();


    @Test(expectedExceptions = CommandException.class)
    public void testCreateCommand_invalidCommand_CommandException() throws CommandException {

        factory.createCommand("noCommand", null, null);
    }


    @Test
    public void createCommand_signInCommand_correct() throws CommandException {
        Command command = factory.createCommand(SIGN_IN_COMMAND, null, null);

        assertTrue(command instanceof SignInCommand);
    }


    @Test
    public void createCommand_addBrand_correct() throws CommandException {
        Command command = factory.createCommand(ADD_NEW_BRAND_COMMAND, null, null);

        assertTrue(command instanceof AddNewBrandCommand);
    }

    @Test
    public void createCommand_addProductToBasket_correct() throws CommandException {
        Command command = factory.createCommand(ADD_PRODUCT_TO_BASKET_COMMAND, null, null);

        assertTrue(command instanceof AddProductToBasketCommand);
    }


    @Test
    public void createCommand_viewUserCabinet_correct() throws CommandException {
        Command command = factory.createCommand(VIEW_USER_CABINET_COMMAND, null, null);

        assertTrue(command instanceof ViewUserCabinetCommand);
    }
}