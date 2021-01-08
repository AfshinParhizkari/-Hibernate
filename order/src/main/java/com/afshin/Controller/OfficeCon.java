package com.afshin.Controller;

import com.afshin.Dao.OfficeDao;
import com.afshin.Entity.Office;
import com.afshin.General.GeneralFunc;

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
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        officeList.clear();
        String action=req.getParameter("crud");
        if (action.equals("read")) {
            String officecode = req.getParameter("offcode");
            if (officecode == null || officecode.isEmpty()) officeList = dao.findall();
            else officeList.add(dao.findbyid("officecode"));
        }
        if (action.equals("create")){
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
            dao.insert(office);
            officeList.add(office);
        }
        if (action.equals("update")){
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
            dao.update(office);
            officeList.add(office);
        }
        req.setAttribute("Offices", officeList);
        req.getRequestDispatcher("WEB-INF/views/Office.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        officeList.clear();
        String action = req.getParameter("crud");
        if (action.equals("delete")){
            Office office = dao.findbyid(req.getParameter("offcode"));
            dao.delete(office);
            req.getRequestDispatcher("WEB-INF/views/Office.jsp").forward(req, resp);
        }
        if(action.equals("edit")){
            Office office = dao.findbyid(req.getParameter("offcode"));
            req.setAttribute("office", office);
            req.getRequestDispatcher("WEB-INF/views/OfficeMerge.jsp").forward(req, resp);
        }
    }
}
