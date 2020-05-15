package ua.training.controller.filters;

import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = request.getServletContext();
        System.out.println(session);
        System.out.println(session.getAttribute("role"));
        System.out.println(context.getAttribute("loggedUsers"));

        Role role = (Role) session.getAttribute("role");
        String path = req.getRequestURI();
        if(path.contains("admin")) {
            if(role.equals(Role.USER)) {
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/access_denied.jsp");
                dispatcher.forward(req, res);
            }else if(role.equals(Role.ADMIN)) {
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/admin");
                    dispatcher.forward(req, res);
            }else {
                response.getWriter().append("AccessDenied");
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
