package com.supinfo.suprails.web.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bargenson
 */
@WebFilter(urlPatterns="/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if(session == null || session.getAttribute("user") == null) {
            httpResponse.sendRedirect(request.getServletContext().getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Do nothing
    }

}
