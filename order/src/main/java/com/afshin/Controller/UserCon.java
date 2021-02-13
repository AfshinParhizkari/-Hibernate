package com.afshin.Controller;

import com.afshin.Dao.UserDao;
import com.afshin.Entity.Payment;
import com.afshin.Entity.User;
import com.afshin.General.GeneralFunc;
import com.afshin.General.GregorianDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:52 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "UserAct",urlPatterns = "/UserAct")
public class UserCon extends HttpServlet {
    UserDao dao = new UserDao();
    List<User> userList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
            userList.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String userid = req.getParameter("userid");
                if (userid.isEmpty()) userList = dao.findall();
                else userList.add(dao.findbyid(Integer.parseInt(userid)));
                req.setAttribute("users", userList);
                req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
            }
            if (action.equals("add")) {
                User user = new User();
                user.setIdusers(Integer.parseInt(req.getParameter("userid")));
                user.setUsername(req.getParameter("uname"));
                user.setPassword(req.getParameter("pwd"));
                user.setEmployeeid(Integer.parseInt(req.getParameter("empid")));
                dao.insert(user);
                userList.add(user);
                req.setAttribute("users", userList);
                req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
            }
            if (action.equals("update")) {
                String userid = req.getParameter("userid");
                User user = dao.findbyid(Integer.parseInt(userid));
                user.setUsername(req.getParameter("uname"));
                user.setPassword(req.getParameter("pwd"));
                user.setEmployeeid(Integer.parseInt(req.getParameter("empid")));
                dao.update(user);
                userList.add(user);
                req.setAttribute("users", userList);
                req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            GeneralFunc.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
            userList.clear();
            String action = req.getParameter("crud");
            String userid = req.getParameter("userid");
            if (action.equals("delete")) {
                User user = dao.findbyid(Integer.parseInt(userid));
                dao.delete(user);
                req.setAttribute("message", "record was deleted");
                req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
            }
            if (action.equals("edit")) {
                User user = dao.findbyid(Integer.parseInt(userid));
                req.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/views/UserMerge.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            GeneralFunc.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
        }
    }
}
