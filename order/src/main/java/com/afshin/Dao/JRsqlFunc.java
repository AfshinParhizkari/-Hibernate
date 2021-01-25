package com.afshin.Dao;

import com.afshin.General.Mysession;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    public static void viewReport(String path,Map parameters,String fileType){
        try {
            //compile .jrxml(Human Understanding) file to .jasper(Machine understanding)
            JasperReport jreport = JasperCompileManager.compileReport(path);
            Connection connection= Mysession.getconnection();
                JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, connection);
            connection.close();
            // Viewing the report
            if(fileType.equals("web"))
                JasperViewer.viewReport(jprint, false);
            else{

                File file=new File(System.getProperty("user.home")+"/OrderReport."+fileType);
                OutputStream outputStream=new FileOutputStream(file);
                if(fileType.equals("pdf"))  JasperExportManager.exportReportToPdfStream(jprint,outputStream);
                if(fileType.equals("xml"))  JasperExportManager.exportReportToXmlStream(jprint,outputStream);

            }
        }catch (JRException | SQLException | FileNotFoundException e){e.printStackTrace();}
    }
}