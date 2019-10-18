package by.epam.chekun.domain.command.factory.impl;

import by.epam.chekun.domain.command.Command;
import by.epam.chekun.domain.command.exception.CommandException;
import by.epam.chekun.domain.command.factory.CommandFactory;
import by.epam.chekun.domain.command.impl.GetMainPageCommandImpl;
import by.epam.chekun.domain.command.impl.basket.AddProductToBasketCommandImpl;
import by.epam.chekun.domain.command.impl.basket.DeleteProductFromBasketCommandImpl;
import by.epam.chekun.domain.command.impl.basket.ViewUserBasketCommandImpl;
import by.epam.chekun.domain.command.impl.brand.*;
import by.epam.chekun.domain.command.impl.category.*;
import by.epam.chekun.domain.command.impl.order.AddNewOrderCommandImpl;
import by.epam.chekun.domain.command.impl.order.ChangeOrderStatusCommand;
import by.epam.chekun.domain.command.impl.order.ViewOrderDetailCommandImpl;
import by.epam.chekun.domain.command.impl.order.ViewOrdersHistoryCommandImpl;
import by.epam.chekun.domain.command.impl.paymentmethod.AddNewPaymentMethodCommandImpl;
import by.epam.chekun.domain.command.impl.paymentmethod.DeletePaymentMethodCommandImpl;
import by.epam.chekun.domain.command.impl.paymentmethod.ViewPaymentMethodTableCommandImpl;
import by.epam.chekun.domain.command.impl.product.*;
import by.epam.chekun.domain.command.impl.product.table.ViewCustomerProductTableCommandImpl;
import by.epam.chekun.domain.command.impl.product.table.ViewProductsTableCommandImpl;
import by.epam.chekun.domain.command.impl.product.table.ViewProductsWithCategoryAndBrandCommandImpl;
import by.epam.chekun.domain.command.impl.product.table.ViewProductsWithCategoryCommandImpl;
import by.epam.chekun.domain.command.impl.user.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.epam.chekun.domain.configuration.JspActionCommand.*;


public class CommandFactoryImpl implements CommandFactory {

    private static final CommandFactoryImpl instance = new CommandFactoryImpl();

    public static CommandFactoryImpl getInstance() {
        return instance;
    }

    private CommandFactoryImpl() {

    }

    @Override
    public Command createCommand(final String actionName,
                                 final HttpServletRequest request,
                                 final HttpServletResponse response)
            throws CommandException {

        switch (actionName) {
//            case VIEW_SIGN_IN_WINDOW_COMMAND:
//                return new ViewSignInCommand();
            case VIEW_SIGN_UP_WINDOW_COMMAND:
                return new SignUpWindowCommandImpl(request, response);
            case SIGN_UP_COMMAND:
                return new SignUpCommandImpl(request, response);
            case SIGN_IN_COMMAND:
                return new SignInCommandImpl(request, response);
            case "updatePassword":
                return new ChangePasswordUserCommandImpl(request, response);
            case "viewChangePassword":
                return new ViewChangePasswordCommandImpl();
            case LOGOUT_COMMAND:
                return new LogoutCommandImpl(request, response);
            case VIEW_MAIN_PAGE_COMMAND:
                return new GetMainPageCommandImpl(request, response);
            case VIEW_USER_CABINET_COMMAND:
                return new ViewUserCabinetCommandImpl(request, response);
            case VIEW_USERS_TABLE_COMMAND:
                return new ViewUsersTableCommandImpl(request, response);
            case CHANGE_BAN_STATUS_COMMAND:
                return new AdminChangeBanStatusCommandImpl(request, response);
            case "changeUserStatus":
                return new AdminChangeUserStatusCommandImpl(request, response);
            case VIEW_USERS_TABLE_SORTED_COMMAND:
                return new ViewUsersTableSortedCommandImpl(request, response);
            case EDIT_USER_COMMAND:
                return new EditUserCommandImpl(request, response);


//            case VIEW_ADD_NEW_CATEGORY_COMMAND:
//                return new ViewAddNewCategoryCommandImpl();

            ///////////////////////////////////////////////////////////////////////////
            case ADD_NEW_CATEGORY_COMMAND:
                return new AddNewCategoryCommandImpl(request, response);
            case VIEW_CATEGORIES_TABLE_COMMAND:
                return new ViewCategoriesTableCommandImpl(request, response);
            case "editCategory":
                return new EditCategoryCommandImpl(request, response);
            case "viewEditCategory":
                return new ViewEditCategoryCommandImpl(request, response);
            case "deleteCategory":
                return new DeleteCategoryCommandImpl(request, response);
            ///////////////////////////////////////////////////////////////////////////


            ///////////////////////////////////////////////////////////////////////////
            case VIEW_BRANDS_TABLE_COMMAND:
                return new ViewBrandsTableCommandImpl(request, response);
            case "viewEditBrand":
                return new ViewEditBrandCommandImpl(request, response);
            case "editBrand":
                return new EditBrandCommandImpl(request, response);
            case "addNewBrand":
                return new AddNewBrandCommandImpl(request, response);
            case "deleteBrand":
                return new DeleteBrandCommandImpl(request, response);
            ///////////////////////////////////////////////////////////////////////////

            ///////////////////////////////////////////////////////////////////////////
            case VIEW_PRODUCTS_TABLE_COMMAND:
                return new ViewProductsTableCommandImpl(request, response);
            case VIEW_ADD_NEW_PRODUCT_COMMAND:
                return new ViewAddNewProductCommandImpl(request, response);
            case ADD_NEW_PRODUCT_COMMAND:
                return new AddNewProductCommandImpl(request, response);
            case DELETE_PRODUCT_COMMAND:
                return new DeleteProductCommandImpl(request, response);
            case "viewEditProduct":
                return new ViewEditProductCommandImpl(request, response);
            case "editProduct":
                return new EditProductCommandImpl(request, response);
            ///////////////////////////////////////////////////////////////////////////
//
//            case "viewProductsWith"
            case "viewCustomerProductTableWithBrandAndCategory":
                return new ViewProductsWithCategoryAndBrandCommandImpl(request, response);

            ///////////////////////////////////////////////////////////////////////////
            case ADD_PRODUCT_TO_BASKET:
                return new AddProductToBasketCommandImpl(request, response);
            case VIEW_USER_BASKET_COMMAND:
                return new ViewUserBasketCommandImpl(request, response);
            case "deleteProductFromBasket":
                return new DeleteProductFromBasketCommandImpl(request, response);

            ///////////////////////////////////////////////////////////////////////////

            case VIEW_PAYMENT_METHOD_TABLE_COMMAND:
                return new ViewPaymentMethodTableCommandImpl(request, response);
//            case VIEW_ADD_NEW_PAYMENT_METHOD_COMMAND:
//                return new ViewAddNewPaymentMethodCommandImpl();
            case ADD_NEW_PAYMENT_METHOD_COMMAND:
                return new AddNewPaymentMethodCommandImpl(request, response);
            case "deletePaymentMethod":
                return new DeletePaymentMethodCommandImpl(request, response);

            ///////////////////////////////////////////////////////////////////////////

            ///////////////////////////////////////////////////////////////////////////
            case "addNewOrder":
                return new AddNewOrderCommandImpl(request, response);
            case "viewOrdersHistory":
                return new ViewOrdersHistoryCommandImpl(request, response);
            case "ViewOrderDetail":
                return new ViewOrderDetailCommandImpl(request, response);
            case "changeOrderStatus":
                return new ChangeOrderStatusCommand(request, response);
            ///////////////////////////////////////////////////////////////////////////

            case "viewCustomerProductTable":
                return new ViewCustomerProductTableCommandImpl(request, response);
            case "ViewCustomerProductTableWithCategory":
                return new ViewProductsWithCategoryCommandImpl(request, response);
        }

        throw new CommandException("No command with name " + actionName);
    }


}
