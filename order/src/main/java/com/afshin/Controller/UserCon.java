package com.afshin.Controller;

import com.afshin.Dao.UserDao;
import com.afshin.Entity.User;
import com.afshin.General.Logback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            if (!SecurityCon.isLogin(req)) {req.getRequestDispatcher("index.jsp").forward(req, resp); return;}
            userList.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String userid = req.getParameter("userid");
                if (userid.isEmpty()) userList = dao.findall();
                else userList.add(dao.findbyid(Integer.parseInt(userid)));
                if(userList.isEmpty() || userList.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
                req.setAttribute("users", userList);
            }
            if (action.equals("add")) {
                User user = new User();
                user.setIdusers(Integer.parseInt(req.getParameter("userid")));
                user.setUsername(req.getParameter("uname"));
                user.setPassword(req.getParameter("pwd"));
                user.setEmployeeid(Integer.parseInt(req.getParameter("empid")));
                Integer status = dao.insert(user);
                if(status==user.getIdusers()) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                userList.add(dao.findbyid(status));
                req.setAttribute("users", userList);
            }
            if (action.equals("update")) {
                String userid = req.getParameter("userid");
                User user = dao.findbyid(Integer.parseInt(userid));
                user.setUsername(req.getParameter("uname"));
                user.setPassword(req.getParameter("pwd"));
                user.setEmployeeid(Integer.parseInt(req.getParameter("empid")));
                Integer status = dao.update(user);
                if(status==user.getIdusers()) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                userList.add(dao.findbyid(status));
                req.setAttribute("users", userList);
            }
            req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {req.getRequestDispatcher("index.jsp").forward(req, resp); return;}
            userList.clear();
            String action = req.getParameter("crud");
            String userid = req.getParameter("userid");
            if (action.equals("delete")) {
                User user = dao.findbyid(Integer.parseInt(userid));
                Integer status = dao.delete(user);
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/User.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
                }
            }
            if (action.equals("edit")) {
                User user = dao.findbyid(Integer.parseInt(userid));
                req.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/views/UserMerge.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
