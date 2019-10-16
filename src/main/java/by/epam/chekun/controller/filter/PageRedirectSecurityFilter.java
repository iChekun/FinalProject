package by.epam.chekun.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/main", "/personal_cabinet", "/category_table", "/work_with_category",
        "/add_category"})
public class PageRedirectSecurityFilter implements Filter {
    private String indexPath;

    public void init(FilterConfig fConfig) throws ServletException {
//        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("page re s f ");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();

        String command = request.getParameter("action");

        System.out.println("received path   " + path);
        System.out.println("received command : " + command);
        System.out.println(request.getContextPath());
        HttpSession session = request.getSession();



        if (session.getAttribute("userStatusId") == null && !path.endsWith("main")) {
            System.out.println("redirect to index");
            response.sendRedirect("index");
        } else if (session.getAttribute("userStatusId") != null
                && !path.endsWith("index")
                && !path.endsWith("main")) {
            System.out.println("redirect to main");
            response.sendRedirect("main");}

//        } else if (session.getAttribute("userStatusId") != null
//                && path.endsWith("add_category")) {
//
//            System.out.println("cat table");
//            response.sendRedirect(request.getContextPath() +"/category_table");
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
