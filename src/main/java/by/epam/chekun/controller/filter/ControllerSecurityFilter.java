package by.epam.chekun.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspActionCommand.*;
import static by.epam.chekun.domain.configuration.JspFilePass.INDEX_PAGE;
import static by.epam.chekun.domain.entity.user.UserStatus.*;


@WebFilter(urlPatterns = {"*"}, servletNames = {"mainWindow"})
public class ControllerSecurityFilter implements Filter {

    private List<String> adminActions;
    private List<String> customerActions;
    private List<String> guestActions;

    @Override
    public void init(FilterConfig filterConfig) {
        //
        guestActions = new ArrayList<>();
        customerActions = new ArrayList<>();
        adminActions = new ArrayList<>();
        //
        addAdminActions();
        //
        addCustomerActions();
        //
        addGuestActions();
        //
    }


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpSession session = request.getSession();
        final String action = request.getParameter(ACTION_TYPE);

        if (action != null) {

            int userStatusId = GUEST.getUserStatusId();

            if (session.getAttribute(USER_STATUS_ID) != null) {
                userStatusId = (int) (session.getAttribute(USER_STATUS_ID));
            }

            if (userStatusId == GUEST.getUserStatusId() && guestActions.contains(action)
                    || userStatusId == ADMIN.getUserStatusId() && adminActions.contains(action)
                    || userStatusId == CUSTOMER.getUserStatusId() && customerActions.contains(action)) {
                request.setAttribute(ALLOWED, true);
            } else {
                request.setAttribute(ALLOWED, false);
                request.setAttribute(REDIRECT_COMMAND, INDEX_PAGE);
            }

            if (!(boolean) request.getAttribute(ALLOWED)) {
                session.setAttribute(SECURITY_MESSAGE, "message.not_allowed");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }


    private void addGuestActions() {
        ////
        guestActions.add(VIEW_MAIN_PAGE_COMMAND);
        guestActions.add(SIGN_IN_COMMAND);
        guestActions.add(SIGN_UP_COMMAND);
        guestActions.add(VIEW_SIGN_UP_WINDOW_COMMAND);
        guestActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_COMMAND);
        guestActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_COMMAND);
        guestActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_AND_BRAND_COMMAND);
    }

    private void addCustomerActions() {
        ////
        customerActions.add(VIEW_MAIN_PAGE_COMMAND);
        customerActions.add(VIEW_SIGN_UP_WINDOW_COMMAND);
        customerActions.add(SIGN_IN_COMMAND);
        customerActions.add(SIGN_UP_COMMAND);
        customerActions.add(CHANGE_PASSWORD_COMMAND);
        customerActions.add(LOGOUT_COMMAND);
        customerActions.add(VIEW_USER_CABINET_COMMAND);
        customerActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_AND_BRAND_COMMAND);
        customerActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_COMMAND);
        customerActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_COMMAND);
        customerActions.add(ADD_PRODUCT_TO_BASKET_COMMAND);
        customerActions.add(DELETE_PRODUCT_FROM_BASKET_COMMAND);
        customerActions.add(VIEW_USER_BASKET_COMMAND);
        customerActions.add(ADD_NEW_ORDER_COMMAND);
        customerActions.add(VIEW_ORDERS_HISTORY_COMMAND);
        customerActions.add(VIEW_ORDER_DETAIL_COMMAND);
        customerActions.add(INVALIDATE_ORDER_COMMAND);
    }

    private void addAdminActions() {
        ////
        adminActions.add(VIEW_SIGN_UP_WINDOW_COMMAND);
        adminActions.add(SIGN_IN_COMMAND);
        adminActions.add(SIGN_UP_COMMAND);
        adminActions.add(CHANGE_PASSWORD_COMMAND);
        adminActions.add(CHANGE_USER_STATUS_COMMAND);
        adminActions.add(LOGOUT_COMMAND);
        adminActions.add(VIEW_USER_CABINET_COMMAND);
        adminActions.add(VIEW_MAIN_PAGE_COMMAND);
        adminActions.add(VIEW_USERS_TABLE_COMMAND);
        adminActions.add(CHANGE_BAN_STATUS_COMMAND);
        adminActions.add(VIEW_USERS_TABLE_SORTED_COMMAND);
        adminActions.add(EDIT_USER_COMMAND);
        adminActions.add(ADD_NEW_CATEGORY_COMMAND);
        adminActions.add(EDIT_CATEGORY_COMMAND);
        adminActions.add(VIEW_EDIT_CATEGORY_COMMAND);
        adminActions.add(DELETE_CATEGORY_COMMAND);
        adminActions.add(VIEW_CATEGORIES_TABLE_COMMAND);
        adminActions.add(VIEW_BRANDS_TABLE_COMMAND);
        adminActions.add(ADD_NEW_BRAND_COMMAND);
        adminActions.add(DELETE_BRAND_COMMAND);
        adminActions.add(VIEW_EDIT_BRAND_COMMAND);
        adminActions.add(EDIT_BRAND_COMMAND);
        adminActions.add(VIEW_PRODUCTS_TABLE_COMMAND);
        adminActions.add(ADD_NEW_PRODUCT_COMMAND);
        adminActions.add(DELETE_PRODUCT_COMMAND);
        adminActions.add(VIEW_EDIT_PRODUCT_COMMAND);
        adminActions.add(EDIT_PRODUCT_COMMAND);
        adminActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_AND_BRAND_COMMAND);
        adminActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_WITH_CATEGORY_COMMAND);
        adminActions.add(VIEW_CUSTOMER_PRODUCT_TABLE_COMMAND);
        adminActions.add(ADD_PRODUCT_TO_BASKET_COMMAND);
        adminActions.add(DELETE_PRODUCT_FROM_BASKET_COMMAND);
        adminActions.add(VIEW_USER_BASKET_COMMAND);
        adminActions.add(VIEW_PAYMENT_METHOD_TABLE_COMMAND);
        adminActions.add(ADD_NEW_PAYMENT_METHOD_COMMAND);
        adminActions.add(DELETE_PAYMENT_METHOD_COMMAND);
        adminActions.add(ADD_NEW_ORDER_COMMAND);
        adminActions.add(VIEW_ORDERS_HISTORY_COMMAND);
        adminActions.add(VIEW_ORDER_DETAIL_COMMAND);
        adminActions.add(CHANGE_ORDER_STATUS_COMMAND);
        adminActions.add(INVALIDATE_ORDER_COMMAND);
    }


}

