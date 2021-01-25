package com.afshin.Dao;

import com.afshin.General.Mysession;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public static void viewReport(String path,Map parameters){
        try {
            //compile .jrxml(Human Understanding) file to .jasper(Machine understanding)
            JasperReport jreport = JasperCompileManager.compileReport(path);
            Connection connection= Mysession.getconnection();
                JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, connection);
            connection.close();
            // Viewing the report
            JasperViewer.viewReport(jprint, false);
        }catch (JRException | SQLException e){e.printStackTrace();}
    }
}