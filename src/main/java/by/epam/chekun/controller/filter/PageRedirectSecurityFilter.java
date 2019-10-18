package by.epam.chekun.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/main",
        "/users_table", "/signUp", "/personal_cabinet",
        "/work_with_category", "/category_table",
        "/work_with_brand", "/brand_table",
        "/work_with_product", "/product_table",
        "/payment_method_table",
        "/user_basket", "/customer_product_table",
        "/orders_history", "/order_detail"})
public class PageRedirectSecurityFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();


        String path = request.getRequestURI();

        System.out.println(path);
        System.out.println(session.getAttribute("redirectToCommand"));
        System.out.println(session.getAttribute("userStatusId"));
        System.out.println(session.getAttribute("userId"));

        if (session.getAttribute("userStatusId") == null
                && session.getAttribute("errorMessage") == null) {
            System.out.println("redirect to index");
            response.sendRedirect("index");
        } else if (session.getAttribute("userStatusId") != null
                && session.getAttribute("errorMessage") == null) {

            String redirectTo = request.getContextPath() + "/mainWindow?action="
                    + session.getAttribute("redirectToCommand");

            System.out.println("redirect to:  " + redirectTo);
            response.sendRedirect(redirectTo);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
