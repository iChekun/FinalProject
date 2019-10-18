package by.epam.chekun.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.*;

//"/main",
@WebFilter(urlPatterns = {
        "/users_table", "/signUp", "/personal_cabinet",
        "/work_with_category", "/category_table",
        "/work_with_brand", "/brand_table",
        "/work_with_product", "/product_table",
        "/payment_method_table",
        "/user_basket", "/customer_product_table",
        "/orders_history", "/order_detail"})
//@WebFilter(urlPatterns = {MAIN_PAGE,
//        USERS_TABLE_PAGE, SIGN_UP_PAGE, USER_PERSONAL_CABINET_PAGE,
//        WORK_WITH_CATEGORY_PAGE, CATEGORY_TABLE_PAGE,
//        WORK_WITH_BRAND_PAGE, BRAND_TABLE_PAGE,
//        WORK_WITH_PRODUCT_PAGE, PRODUCT_TABLE_PAGE,
//        PAYMENT_METHOD_TABLE_PAGE,
//        USER_BASKET_PAGE, CUSTOMER_PRODUCT_PAGE,
//        ORDERS_HISTORY_PAGE, ORDER_DETAIL_PAGE})
public class PageRedirectSecurityFilter implements Filter {
    private static final String PATH_TO_CONTROLLER_WITH_ACTION = "/mainWindow?action=";

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (session.getAttribute(USER_STATUS_ID) == null
                && session.getAttribute(ERROR_TO_JSP) == null) {
            response.sendRedirect(INDEX_PAGE);
        } else if (session.getAttribute(USER_STATUS_ID) != null
                && session.getAttribute(ERROR_TO_JSP) == null) {

            String redirectTo = request.getContextPath() +
                    PATH_TO_CONTROLLER_WITH_ACTION + session.getAttribute(REDIRECT_COMMAND);
            response.sendRedirect(redirectTo);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
