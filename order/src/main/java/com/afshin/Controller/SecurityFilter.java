package com.afshin.Controller; /**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2021 - 01 - 09
 * @Time 1:30 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter",servletNames = {"CustomerAct","OrderAct","OrderdetailAct","ProductAct","ProductlineAct","UserAct"})//urlPatterns = "/WEB-INF/views/*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;
        if(req.getSession()!=null && req.getSession().getAttribute("sessionUser") != null)
            chain.doFilter(request, response);
        else ((HttpServletResponse)response).sendRedirect("index.jsp");
    }
}
