/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.TiendaDAO;
import cl.duoc.misofertas.dao.UsuarioDAO;
import cl.duoc.misofertas.dao.ValoracionDAO;
import cl.duoc.misofertas.dto.TiendaDTO;
import cl.duoc.misofertas.dto.UsuarioDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Beto
 */
public class Reporte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            generarGraficos(response);
        } catch (DocumentException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void generarGraficos(HttpServletResponse response) throws DocumentException, IOException, SQLException {
        response.setContentType("application/pdf");

        Document document = new Document();
        

        try {
            OutputStream outputStream = response.getOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfReader reader = new PdfReader("C:\\Users\\Beto\\Documents\\NetBeansProjects\\MisOfertas\\src\\main\\java\\cl\\duoc\\misofertas\\controller\\Graficos.pdf");
            PdfImportedPage page = writer.getImportedPage(reader, 1);

            PdfTemplate pdfTemplateChartHolder = cb.createTemplate(500, 400);
            Graphics2D graphicsChart = pdfTemplateChartHolder.createGraphics(500, 400, new DefaultFontMapper());
            Rectangle2D chartRegion = new Rectangle2D.Double(0, 0, 500, 400);

            PdfTemplate pdfTemplateChartHolder2 = cb.createTemplate(500, 400);
            Graphics2D graphicsChart2 = pdfTemplateChartHolder2.createGraphics(500, 400, new DefaultFontMapper());
            Rectangle2D chartRegion2 = new Rectangle2D.Double(0, 0, 500, 400);

            generateBarChart().draw(graphicsChart, chartRegion);
            generatePieChart().draw(graphicsChart2, chartRegion2);

            graphicsChart.dispose();
            graphicsChart2.dispose();
            cb.addTemplate(pdfTemplateChartHolder, 50, 0);
            cb.addTemplate(pdfTemplateChartHolder2, 50, 420);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    public static JFreeChart generatePieChart() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        java.util.List<UsuarioDTO> usuarios = usuarioDAO.getAll();

        DefaultPieDataset dataSet = new DefaultPieDataset();

        int consumidores = 0;
        int encargados = 0;
        int administrador = 0;
        int gerentes = 0;
        
        for (UsuarioDTO usuario : usuarios) {
            String rol = usuario.getRol();
            if (rol.equalsIgnoreCase("Encargado de Tienda")) {
                encargados = encargados + 1;
            }else if(rol.equalsIgnoreCase("Administrador")){
                administrador = administrador + 1;
            }else if(rol.equalsIgnoreCase("Consumidor")){
                consumidores = consumidores + 1;
            }else if(rol.equalsIgnoreCase("Gerente")){
                gerentes = gerentes + 1;
            }
        }

        dataSet.setValue("Consumidores", consumidores);
        dataSet.setValue("Encargados de tienda", encargados);
        dataSet.setValue("Administradores", administrador);
        dataSet.setValue("Gerentes", gerentes);

        JFreeChart chart = ChartFactory.createPieChart(
                "Usuarios registrados por perfil", dataSet, false, true, true);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSimpleLabels(true);

        return chart;
    }

    public static JFreeChart generateBarChart() throws SQLException {
        //Obtenemos todas las tiendas
        TiendaDAO tiendaDAO = new TiendaDAO();
        ValoracionDAO valoracionDAO = new ValoracionDAO();
        java.util.List<TiendaDTO> tiendas = tiendaDAO.getAll();
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (TiendaDTO tienda : tiendas) {
            int valoracion = valoracionDAO.getValoracionesTienda(tienda.getIdtienda());
            String nombreTienda = tienda.getNombre();
            dataSet.setValue(valoracion, "Population", nombreTienda);
        }

        /*dataSet.setValue(791, "Population", "1750 AD");
        dataSet.setValue(978, "Population", "1800 AD");
        dataSet.setValue(1262, "Population", "1850 AD");
        dataSet.setValue(1650, "Population", "1900 AD");
        dataSet.setValue(2519, "Population", "1950 AD");
        dataSet.setValue(6070, "Population", "2000 AD");*/
        JFreeChart chart = ChartFactory.createBarChart(
                "Valoraciones por tienda", "Tiendas", "Cantidad de valoraciones",
                dataSet, PlotOrientation.VERTICAL, false, true, true);

        return chart;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
