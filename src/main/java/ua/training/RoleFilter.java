/*package ua.training;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy(){};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws ServletException, IOException{
        HttpRequest httpRequest = (HttpRequest) req;
        HttpResponse httpResponse = (HttpResponse) resp;

        User user = (User) httpRequest.getSession().getAttribute("user");
        if(user != null && equals(User.ROLE.ADMIN) ){
            chain.doFilter(req, resp);
        } else{
            httpResponse.sendRedirect("/WEB-INF/pages/accesDenied.jsp")
        }
    }

}
*/