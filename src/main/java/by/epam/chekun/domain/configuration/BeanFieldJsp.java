package by.epam.chekun.domain.configuration;

/**
 * Final class with all bean fields that using in jsp
 * and servlets
 */
public final class BeanFieldJsp {
    private BeanFieldJsp() {

    }

    //////////////////////////////
    public static final String ALLOWED = "allowed";

    public static final String SECURITY_MESSAGE = "message";
    public static final String MESSAGE_TO_JSP = "errorMessage";
    public static final String MESSAGE_TO_SIGN_UP = "errorMessageSingUp";
    public static final String MESSAGE_TO_USER_BASKET = "errorToUserBasket";
    public static final String MESSAGE_TO_ORDERS_HISTORY = "errorOrdersHistory";
    public static final String MESSAGE_TO_EDIT_USER = "errorMessageEditUser";
    public static final String MESSAGE_TO_JSP_PASSWORD = "errorMessagePassword";
    public static final String MESSAGE_TO_JSP_BRAND = "errorMessageBrand";
    public static final String MESSAGE_TO_JSP_CATEGORY = "errorMessageCategory";
    public static final String MESSAGE_TO_JSP_PRODUCT = "errorMessageProduct";
    public static final String MESSAGE_TO_JSP_PAYMENT_METHOD = "errorMessagePaymentMethod";
    public static final String REDIRECT_COMMAND = "redirectToCommand";


    public static final String USER_FOR_ACTION_IN_USERS_TABLE = "userForAction";
    public static final String USER_ID_FOR_ACTION_IN_USERS_TABLE = "workUserId";
    public static final String PRODUCT_FOR_ACTION = "productForAction";
    public static final String BRAND_FOR_ACTION = "brandForAction";
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //USER
    public static final String USER_OBJECT = "user";
    public static final String USERS_LIST = "users";

    public static final String USER_BANNED_STATUS = "banned";
    public static final String USER_ID = "userId";
    public static final String USER_STATUS_ID = "userStatusId";
    public static final String USER_CONTACTS_ID = "contactsId";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_CONFIRMED_PASSWORD = "confirmedPassword";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_BIRTH_DATE = "birthDate";
    public static final String USER_CONTACTS_EMAIL = "email";
    public static final String USER_CONTACTS_PHONE_NUMBER = "phoneNumber";
    public static final String USER_CONTACTS_ADDRESS_COUNTRY = "country";
    public static final String USER_CONTACTS_ADDRESS_CITY = "city";
    public static final String USER_CONTACTS_ADDRESS_STREET = "street";
    public static final String USER_CONTACTS_ADDRESS_HOUSE_NUMBER = "houseNumber";
    public static final String USER_CONTACTS_ADDRESS_USER_APARTMENT_NUMBER = "apartmentNumber";

    public static final String USER_CURRENT_PASSWORD = "currentPassword";
    public static final String USER_NEW_PASSWORD = "newPassword";
    public static final String USER_CONFIRMED_NEW_PASSWORD = "confirmedPassword";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //product
    public static final String PRODUCT_OBJECT = "product";
    public static final String PRODUCT_LIST = "products";

    public static final String PRODUCT_ID = "productId";
    public static final String PRODUCT_NAME = "productName";
    public static final String PRODUCT_DESCRIPTION = "productDescription";
    public static final String PRODUCT_IMAGE_PATH = "productImagePath";
    public static final String PRODUCT_COST = "productCost";


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //CATEGORY
    public static final String CURRENT_CATEGORY_ID = "currentCategoryId";
    public static final String CATEGORY_OBJECT = "category";
    public static final String CATEGORY_LIST = "categories";

    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String CATEGORY_DESCRIPTION = "categoryDescription";
    public static final String CATEGORY_IMAGE_PATH = "categoryImagePath";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //BRAND
    public static final String CURRENT_BRAND_ID = "currentBrandId";
    public static final String BRAND_OBJECT = "brand";
    public static final String BRAND_LIST = "brands";

    public static final String BRAND_ID = "brandId";
    public static final String BRAND_NAME = "brandName";
    public static final String BRAND_DESCRIPTION = "brandDescription";
    public static final String BRAND_IMAGE_PATH = "brandImagePath";
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //BASKET


    public static final String BASKET_ID = "basketId";

    public static final String PRODUCTS_BASKET = "productsInBasket";
    public static final String PRODUCTS_COST = "productsCost";

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //payment method
    public static final String PAYMENT_METHODS_LIST = "paymentMethods";

    public static final String PAYMENT_METHOD_ID = "paymentMethodId";
    public static final String PAYMENT_METHOD_FOR_ACTION = "paymentMethodIdForAction";

    public static final String PAYMENT_METHOD_NAME = "paymentMethodName";
    //ORDER
    public static final String PRODUCTS_ORDER_ID = "productOrders";
    public static final String ORDER_ID = "orderId";
    public static final String ORDERS_LIST = "orders";
    public static final String CURRENT_ORDER_STATUS_ID = "currentOrderStatusId";
    public static final String OPEN_ORDER_STATUS_ID = "1";
    public static final String CLOSE_ORDER_STATUS_ID = "2";

}
