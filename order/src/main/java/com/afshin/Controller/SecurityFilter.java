package com.afshin.Controller; /**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2021 - 01 - 09
 * @Time 1:30 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.comcom.mysql.cj.jdbc.Driver
 * Description:
 */

import com.afshin.General.Logback;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter",servletNames = {"CustomerAct","EmployeeAct","OfficeAct","OrderAct","OrderdetailAct","PaymentAct","ProductAct","ProductlineAct","UserAct"})//urlPatterns = "/WEB-INF/views/*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;
        if(req.getSession()!=null && req.getSession().getAttribute("sessionUser") != null)
            chain.doFilter(request, response);
        else {
            Logback.logger.warn("{}.{}| Session is not Valid", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            req.setAttribute("message", "Session is not Valid, Please login");
            ((HttpServletResponse) response).sendRedirect("index.jsp");
        }
    }
}
