package by.epam.chekun.domain.configuration;

public final class JspActionCommand {
    private JspActionCommand() {

    }

    public static final String ACTION_TYPE = "action";

    public static final String VIEW_SIGN_IN_WINDOW_COMMAND = "signInWindow";

    public static final String VIEW_SIGN_UP_WINDOW_COMMAND = "signUpWindow";

    public static final String SIGN_IN_COMMAND = "signIn";

    public static final String SIGN_UP_COMMAND = "signUp";

    public static final String LOGOUT_COMMAND = "logout";

    public static final String VIEW_MAIN_PAGE_COMMAND = "main";

    public static final String VIEW_USER_CABINET_COMMAND = "viewUserCabinet";
    public static final String VIEW_USERS_TABLE_COMMAND = "viewUsersTable";


    public static final String CHANGE_BAN_STATUS_COMMAND = "updateBanStatus";
    public static final String VIEW_USERS_TABLE_SORTED_COMMAND = "viewUsersTableSorted";

    public static final String EDIT_USER_COMMAND = "editUser";
    public static final String CHANGE_USER_STATUS_COMMAND = "editUserStatus";

    public static final String USER_FOR_ACTION_IN_USERS_TABLE = "userForAction";
    public static final String USER_ID_FOR_ACTION_IN_USERS_TABLE = "workUserId";

    public static final String PRODUCT_FOR_ACTION_PRODUCT_TABLE = "productForAction";
    public static final String CATEGORY_FOR_ACTION_CATEGORY_TABLE = "categoryForAction";
    public static final String BRAND_FOR_ACTION_BRAND_TABLE = "brandForAction";
    public static final String BASKET_FOR_ACTION_BASKET_TABLE = "basketForAction";


    public static final String SORT_BY_ACTION_IN_USERS_TABLE = "sortBy";
    public static final String SORT_TYPE_ACTION_IN_USERS_TABLE = "sortType";


    public static final String VIEW_PRODUCTS_TABLE_COMMAND = "viewProductTable";

    public static final String VIEW_ADD_NEW_CATEGORY_COMMAND = "viewAddNewCategory";

    public static final String ADD_NEW_CATEGORY_COMMAND = "addNewCategory";
    public static final String VIEW_CATEGORIES_TABLE_COMMAND = "viewCategoriesTable";


    public static final String VIEW_BRANDS_TABLE_COMMAND = "viewBrandsTable";
    public static final String ADD_NEW_BRAND_COMMAND = "addNewBrand";
    public static final String VIEW_ADD_NEW_BRAND_COMMAND = "viewAddNewBrand";
    public static final String VIEW_EDIT_BRAND = "viewEditBrand";


    public static final String VIEW_ADD_NEW_PRODUCT_COMMAND = "viewAddNewProduct";
    public static final String ADD_NEW_PRODUCT_COMMAND = "addNewProduct";
    public static final String DELETE_PRODUCT_COMMAND = "deleteProduct";
    public static final String ADD_PRODUCT_TO_BASKET = "addProductToBasket";
    public static final String VIEW_USER_BASKET_COMMAND = "viewUserBasket";


    public static final String VIEW_WORK_WITH_STORE_TABLE_COMMAND = "viewWorkWithStoreTable";

    public static final String VIEW_PAYMENT_METHOD_TABLE_COMMAND = "viewPaymentsMethodTable";
    public static final String VIEW_ADD_NEW_PAYMENT_METHOD_COMMAND = "viewAddNewPaymentMethod";
    public static final String ADD_NEW_PAYMENT_METHOD_COMMAND = "addNewPaymentMethod";


    public static final String VIEW_ORDERS_TABLE = "viewOrdersTable";

}
