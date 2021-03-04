package com.afshin.Controller;

import com.afshin.Dao.JRsqlFunc;
import com.afshin.Dao.ProductlineDao;
import com.afshin.Entity.Productline;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import com.afshin.General.Logback;
import org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 16
 * @Time 7:06 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "ProductlineAct" , urlPatterns = {"/ProductlineAct"})
@MultipartConfig
public class ProductlineCon extends HttpServlet {
    ProductlineDao dao = new ProductlineDao();
    List<Productline> productlines = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }
            productlines.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String prolineNum = req.getParameter("prolineNum");
                if (prolineNum.isEmpty()) productlines = dao.findall();
                else productlines.add(dao.findbyid(prolineNum));
                if(productlines.isEmpty() || productlines.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Productline productline = new Productline();
                productline.setProductLine(req.getParameter("proline"));
                productline.setTextDescription(req.getParameter("txtDesc"));
                productline.setHtmlDescription(req.getParameter("htmDesc"));
                Part filePart = req.getPart("img");
                if (filePart != null) productline.setImage(IOUtils.toByteArray(filePart.getInputStream()));
                String status= dao.insert(productline);
                if(status.equals(productline.getProductLine())) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                productlines.add(dao.findbyid(status));
            }
            if (action.equals("update")) {
                Productline productline = dao.findbyid(req.getParameter("proline"));
                productline.setTextDescription(req.getParameter("txtDesc"));
                productline.setHtmlDescription(req.getParameter("htmDesc"));
                Part filePart = req.getPart("img");
                if (filePart != null) productline.setImage(IOUtils.toByteArray(filePart.getInputStream()));
                String status= dao.update(productline);
                if(status.equals(productline.getProductLine())) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                productlines.add(dao.findbyid(status));
            }
            req.setAttribute("products", productlines);
            req.getRequestDispatcher("WEB-INF/views/Productline.jsp").forward(req, resp);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }
            productlines.clear();
            String action = req.getParameter("crud");
            if (action.equals("delete")) {
                Integer status = dao.delete(dao.findbyid(req.getParameter("proline")));
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/Productline.jsp").forward(req, resp);
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
                }}
            if (action.equals("edit")) {
                Productline productline = dao.findbyid(req.getParameter("proline"));
                req.setAttribute("productline", productline);
                req.getRequestDispatcher("WEB-INF/views/ProductlineMerge.jsp").forward(req, resp);
                //req.getRequestDispatcher("WEB-INF/views/ProductlineMergeJSP.jsp").forward(req,resp);
            }
            if (action.equals("report")) {
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/reports/Productline.jrxml");
                JRsqlFunc.viewReport(path, null, "web");
                req.getRequestDispatcher("WEB-INF/views/Productline.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}