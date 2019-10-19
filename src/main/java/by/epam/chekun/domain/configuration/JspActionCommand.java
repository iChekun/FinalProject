package by.epam.chekun.domain.configuration;

/**
 * final class with all commands from jsp
 */
public final class JspActionCommand {
    private JspActionCommand() {

    }
    ////////////////////////////////////////////////////

    public static final String ACTION_TYPE = "action";

    public static final String VIEW_SIGN_UP_WINDOW_COMMAND = "signUpWindow";

    public static final String SIGN_IN_COMMAND = "signIn";

    public static final String SIGN_UP_COMMAND = "signUp";

    public static final String CHANGE_PASSWORD_COMMAND = "changePassword";

    public static final String CHANGE_USER_STATUS_COMMAND = "changeUserStatus";

    public static final String LOGOUT_COMMAND = "logout";

    public static final String VIEW_MAIN_PAGE_COMMAND = "main";


    /////USER
    public static final String VIEW_USER_CABINET_COMMAND = "viewUserCabinet";
    public static final String VIEW_USERS_TABLE_COMMAND = "viewUsersTable";
    public static final String CHANGE_BAN_STATUS_COMMAND = "updateBanStatus";
    public static final String VIEW_USERS_TABLE_SORTED_COMMAND = "viewUsersTableSorted";
    public static final String EDIT_USER_COMMAND = "editUser";

    public static final String SORT_BY_ACTION_IN_USERS_TABLE = "sortBy";
    public static final String SORT_TYPE_ACTION_IN_USERS_TABLE = "sortType";


    /////////////////////////////////////////////////////////////
    //CATEGORY
    public static final String ADD_NEW_CATEGORY_COMMAND = "addNewCategory";
    public static final String EDIT_CATEGORY_COMMAND = "editCategory";
    public static final String VIEW_EDIT_CATEGORY_COMMAND = "viewEditCategory";
    public static final String DELETE_CATEGORY_COMMAND = "deleteCategory";
    public static final String VIEW_CATEGORIES_TABLE_COMMAND = "viewCategoriesTable";

    /////////////////////////////////////////////////////////////
    //BRAND
    public static final String VIEW_BRANDS_TABLE_COMMAND = "viewBrandsTable";
    public static final String ADD_NEW_BRAND_COMMAND = "addNewBrand";
    public static final String DELETE_BRAND_COMMAND = "deleteBrand";
    public static final String VIEW_EDIT_BRAND_COMMAND = "viewEditBrand";
    public static final String EDIT_BRAND_COMMAND = "editBrand";


    /////////////////////////////////////////////////////////////
    //PRODUCT
    public static final String VIEW_PRODUCTS_TABLE_COMMAND = "viewProductTable";
    public static final String ADD_NEW_PRODUCT_COMMAND = "addNewProduct";
    public static final String DELETE_PRODUCT_COMMAND = "deleteProduct";
    public static final String VIEW_EDIT_PRODUCT_COMMAND = "viewEditProduct";
    public static final String EDIT_PRODUCT_COMMAND = "editProduct";


    public static final String VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_AND_BRAND_COMMAND = "viewCustomerProductTableWithBrandAndCategory";
    public static final String VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_COMMAND = "ViewCustomerProductTableWithCategory";

    public static final String VIEW_CUSTOMER_PRODUCT_TABLE_COMMAND = "viewCustomerProductTable";
    /////////////////////////////////////////////////////////////
    //PRODUCT BASKET
    public static final String ADD_PRODUCT_TO_BASKET_COMMAND = "addProductToBasket";
    public static final String DELETE_PRODUCT_FROM_BASKET_COMMAND = "deleteProductFromBasket";
    public static final String VIEW_USER_BASKET_COMMAND = "viewUserBasket";


    /////////////////////////////////////////////////////////////
    //PAYMENT METHOD
    public static final String VIEW_PAYMENT_METHOD_TABLE_COMMAND = "viewPaymentsMethodTable";
    public static final String ADD_NEW_PAYMENT_METHOD_COMMAND = "addNewPaymentMethod";
    public static final String DELETE_PAYMENT_METHOD_COMMAND = "deletePaymentMethod";

    /////////////////////////////////////////////////////////////
    //ORDER
    public static final String ADD_NEW_ORDER_COMMAND = "addNewOrder";
    public static final String VIEW_ORDERS_HISTORY_COMMAND = "viewOrdersHistory";
    public static final String VIEW_ORDER_DETAIL_COMMAND = "ViewOrderDetail";
    public static final String CHANGE_ORDER_STATUS_COMMAND = "changeOrderStatus";


}
