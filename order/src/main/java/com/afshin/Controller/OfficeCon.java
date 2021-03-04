package com.afshin.Controller;

import com.afshin.Dao.OfficeDao;
import com.afshin.Entity.Office;
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
 * @Date 2020 - 12 - 31
 * @Time 6:20 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "OfficeAct",urlPatterns = {"/OfficeAct"})
public class OfficeCon extends HttpServlet {
    List<Office> officeList=new ArrayList<>();
    OfficeDao dao=new OfficeDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {req.getRequestDispatcher("index.jsp").forward(req, resp); return;}
            officeList.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String officecode = req.getParameter("offcode");
                if (officecode == null || officecode.isEmpty()) officeList = dao.findall();
                else officeList.add(dao.findbyid(officecode));
                if(officeList.isEmpty() || officeList.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Office office = new Office();
                office.setOfficeCode(req.getParameter("offcode"));
                office.setCity(req.getParameter("city"));
                office.setPhone(req.getParameter("phone"));
                office.setAddressLine1(req.getParameter("addl1"));
                office.setAddressLine2(req.getParameter("addl2"));
                office.setState(req.getParameter("state"));
                office.setCountry(req.getParameter("coun"));
                office.setPostalCode(req.getParameter("pcode"));
                office.setTerritory(req.getParameter("ter"));
                String status=dao.insert(office);
                if(status.equals(office.getOfficeCode())) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                officeList.add(dao.findbyid(status));
            }
            if (action.equals("update")) {
                Office office = new Office();
                office.setOfficeCode(req.getParameter("offcode"));
                office.setCity(req.getParameter("city"));
                office.setPhone(req.getParameter("phone"));
                office.setAddressLine1(req.getParameter("addl1"));
                office.setAddressLine2(req.getParameter("addl2"));
                office.setState(req.getParameter("state"));
                office.setCountry(req.getParameter("coun"));
                office.setPostalCode(req.getParameter("pcode"));
                office.setTerritory(req.getParameter("ter"));
                String status = dao.update(office);
                if(status.equals(office.getOfficeCode())) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                officeList.add(dao.findbyid(status));
            }
            req.setAttribute("Offices", officeList);
            req.getRequestDispatcher("WEB-INF/views/Office.jsp").forward(req, resp);
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
            officeList.clear();
            String action = req.getParameter("crud");
            if (action.equals("delete")) {
                Office office = dao.findbyid(req.getParameter("offcode"));
                Integer status = dao.delete(office);
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/Office.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
                }
            }
            if (action.equals("edit")) {
                Office office = dao.findbyid(req.getParameter("offcode"));
                req.setAttribute("office", office);
                req.getRequestDispatcher("WEB-INF/views/OfficeMerge.jsp").forward(req, resp);
            }
        }catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
