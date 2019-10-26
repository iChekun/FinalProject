package by.epam.chekun.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.chekun.domain.configuration.BeanFieldJsp.*;
import static by.epam.chekun.domain.configuration.JspFilePass.*;


@WebFilter(urlPatterns = {
//        SLASH + MAIN_PAGE,
        SLASH + USERS_TABLE_PAGE,
        SLASH + SIGN_UP_PAGE,
        SLASH + USER_PERSONAL_CABINET_PAGE,
        SLASH + WORK_WITH_CATEGORY_PAGE,
        SLASH + CATEGORY_TABLE_PAGE,
        SLASH + WORK_WITH_BRAND_PAGE,
        SLASH + BRAND_TABLE_PAGE,
        SLASH + WORK_WITH_PRODUCT_PAGE,
        SLASH + PRODUCT_TABLE_PAGE,
        SLASH + PAYMENT_METHOD_TABLE_PAGE,
        SLASH + USER_BASKET_PAGE,
        SLASH + CUSTOMER_PRODUCT_PAGE,
        SLASH + ORDERS_HISTORY_PAGE,
        SLASH + ORDER_DETAIL_PAGE})
public class PageRedirectSecurityFilter implements Filter {

    private static final String PATH_TO_CONTROLLER_WITH_ACTION = "/mainWindow?action=";

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (session.getAttribute(USER_STATUS_ID) == null
                && session.getAttribute(MESSAGE_TO_JSP) == null) {
            response.sendRedirect(INDEX_PAGE);
        } else if (session.getAttribute(USER_STATUS_ID) != null
                && session.getAttribute(MESSAGE_TO_JSP) == null) {

            String redirectTo = request.getContextPath() +
                    PATH_TO_CONTROLLER_WITH_ACTION + session.getAttribute(REDIRECT_COMMAND);
            response.sendRedirect(redirectTo);
        }


    }

    public void destroy() {
    }
}
