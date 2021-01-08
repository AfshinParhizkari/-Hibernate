package com.afshin.Controller;

import com.afshin.Dao.UserDao;
import com.afshin.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao=new UserDao();
        String action = req.getParameter("crud");
        if (action.equals("login")) {
            String userName = req.getParameter("usrnam");
            String passWord = req.getParameter("paswrd");
            User user = dao.login(userName);
            HttpSession session = req.getSession(true);
            if (passWord.equals(user.getPassword())) {
                session.setAttribute("sessionUser", user);
                session.setAttribute("message", "Login successful!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                session.setAttribute("message", "User or Password is incorrect");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
        if (action.equals("logout")) {
            req.getSession(true).invalidate();
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entity=req.getParameter("entity");
        req.getRequestDispatcher("WEB-INF/views/"+entity+".jsp").forward(req,resp);
        //req.getRequestDispatcher("WEB-INF/views/EmployeeMerge.jsp").forward(req,resp);
    }
}