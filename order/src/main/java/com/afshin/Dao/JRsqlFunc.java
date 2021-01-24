package com.afshin.Dao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2021 - 01 - 23
 * @Time 12:01 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class JRsqlFunc {
    /*Remove all below tags in Reports
        <fieldDescription><![CDATA[]]></fieldDescription>*/
    public static Connection getConnection(){
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order", "admin", "123456");
        }
        catch (Exception e){System.out.println(e);}
        return con;
    }
    public static void viewReport(String path,Map parameters){
        try {
            //compile .jrxml(Human Understanding) file to .jasper(Machine understanding)
            net.sf.jasperreports.engine.JasperReport jreport = JasperCompileManager.compileReport(path);
            // Set a connection
             JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, getConnection());
            // Viewing the report
            JasperViewer.viewReport(jprint, false);
        }catch (JRException e){e.printStackTrace();}
    }
}