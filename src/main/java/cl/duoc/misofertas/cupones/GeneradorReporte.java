/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.cupones;

import cl.duoc.misofertas.db.DBConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Beto
 */
public class GeneradorReporte {

    public void generar() throws JRException, SQLException {
        Connection con = new DBConnection().connect();
   
        final ClassLoader cl = Thread.currentThread().getContextClassLoader();
try {
   Thread.currentThread().setContextClassLoader(null);

      JasperReport report = JasperCompileManager.compileReport(
          "C:\\Users\\Beto\\Documents\\NetBeansProjects\\MisOfertas\\src\\main\\java\\cl\\duoc\\misofertas\\cupones\\cupon.jrxml");
      
 
         final JasperPrint jasperPrint = JasperFillManager.fillReport
     (report, null, con);
      
      
      // Exporta el informe a PDF
      JasperExportManager.exportReportToPdfFile(jasperPrint,
          "C:\\Users\\Beto\\Desktop\\test.pdf");
      //Para visualizar el pdf directamente desde java
      JasperViewer.viewReport(jasperPrint, false);
    
    
        
        
        } finally {
    con.close();
   Thread.currentThread().setContextClassLoader(cl);
}
    }

    public static void main(String[] args) {
        GeneradorReporte g = new GeneradorReporte();
        try {
            g.generar();
        } catch (JRException ex) {
            Logger.getLogger(GeneradorReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
