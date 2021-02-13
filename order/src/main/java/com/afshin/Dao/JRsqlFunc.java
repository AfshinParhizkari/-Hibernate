package com.afshin.Dao;

import com.afshin.General.GeneralFunc;
import com.afshin.General.Mysession;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
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
            JasperReport jreport = JasperCompileManager.compileReport(path);
            GeneralFunc.logger.trace("JRsqlFunc.{}|Try: compile .jrxml(Human Understanding) file to .jasper(Machine understanding)",Thread.currentThread().getStackTrace()[1].getMethodName());
            Connection connection= Mysession.getconnection();
                JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, connection);
            GeneralFunc.logger.trace("JRsqlFunc.{}|Try: fill-report by sending connection to report)",Thread.currentThread().getStackTrace()[1].getMethodName());
            connection.close();
            // Viewing the report
            if(fileType.equals("web")){
                JasperViewer.viewReport(jprint, false);
                GeneralFunc.logger.trace("JRsqlFunc.{}|Try: view report in Web)",Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            else{

                File file=new File(System.getProperty("user.home")+"/OrderReport."+fileType);
                OutputStream outputStream=new FileOutputStream(file);
                if(fileType.equals("pdf"))  JasperExportManager.exportReportToPdfStream(jprint,outputStream);
                if(fileType.equals("xml"))  JasperExportManager.exportReportToXmlStream(jprint,outputStream);
                GeneralFunc.logger.trace("JRsqlFunc.{}|Try: view report in File)",Thread.currentThread().getStackTrace()[1].getMethodName());
            }
        }catch (JRException | SQLException | FileNotFoundException e)
        {
            GeneralFunc.logger.error("JRsqlFunc.{}|Exception:{}",Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
}