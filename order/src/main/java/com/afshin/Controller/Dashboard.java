package com.afshin.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 15
 * @Time 7:08 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "Dispatcher" , urlPatterns = {"/Dispatcher"})
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity=req.getParameter("entity");
        req.getRequestDispatcher("WEB-INF/views/"+entity+".jsp").forward(req,resp);
        //req.getRequestDispatcher("WEB-INF/views/EmployeeMerge.jsp").forward(req,resp);
    }
}