/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.CertificadoDAO;
import cl.duoc.misofertas.dto.CertificadoDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Beto
 */
public class Cupon extends HttpServlet {

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

            String idCupon = request.getParameter("idCupon");

            CertificadoDAO certificadoDAO = new CertificadoDAO();
            java.util.List<CertificadoDTO> certificados = new ArrayList<>();
            certificados = certificadoDAO.getById(idCupon);
            CertificadoDTO certificado = certificados.get(0);

            //Informacion del cliente - rut, nombre, apellido, puntos acumulados
            String rut = certificado.getUsuarioDTO().getRut();
            String nombre = certificado.getUsuarioDTO().getNombre();
            String apellido = certificado.getUsuarioDTO().getApellido();
            String puntosAcumulados = String.valueOf(certificado.getUsuarioDTO().getPuntosAcumulados());
            //Fecha emision
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fechaEmision = dateFormat.format(certificado.getFechaEmision());
            //Codigo de barra
            String codigoBarra = String.valueOf(certificado.getCodigoBarra());
            //Descuento - categoria, porcentaje, tope
            String porcentaje = certificado.getDescuento().getPorcentaje();
            String categoria = certificado.getDescuento().getRubro().getNombre();
            String tope = certificado.getDescuento().getTope();

            response.setContentType("application/pdf");

            OutputStream outputStream = response.getOutputStream();
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfReader reader = new PdfReader("C:\\Users\\Beto\\Documents\\NetBeansProjects\\MisOfertas\\src\\main\\java\\cl\\duoc\\misofertas\\controller\\Cupon.pdf");
            PdfImportedPage page = writer.getImportedPage(reader, 1);
            cb.addTemplate(page, 0, 0);

            Image img = Image.getInstance("C:\\Users\\Beto\\Documents\\NetBeansProjects\\MisOfertas\\src\\main\\java\\cl\\duoc\\misofertas\\controller\\new_logo.png");
            img.setAlignment(Image.ALIGN_CENTER);
            document.add(img);

            document.add(new Phrase("\n"));
            document.add(new Phrase("\n"));

            Font f = new Font(FontFamily.HELVETICA, 30.0f, Font.BOLD, BaseColor.BLACK);
            Paragraph title = new Paragraph("Cupón de descuento", f);

            title.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(title);
            document.add(new Phrase("\n"));

            Paragraph p = new Paragraph("Se ha generado un nuevo cupón de descuento con fecha de emisión "
                    + fechaEmision
                    + " para el usuario "
                    + nombre
                    + " con RUT ");

            p.setIndentationLeft(20);
            p.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(p);
            document.add(new Paragraph(rut
                    + " con el siguiente detalle: "));

            document.add(new Phrase("\n"));

            document.add(new Paragraph("Hasta el momento tienes " + puntosAcumulados + " puntos acumulados.  Con este puntaje puedes acceder a realizar compras en las siguientes categorias:"));

            document.add(new Phrase("\n"));

            List list = new List(List.UNORDERED);
            ListItem item = new ListItem("Categoria: " + categoria.toUpperCase());
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            document.add(list);
            //document.add(new Paragraph(codigoBarra));
            document.add(new Phrase("\n"));

            document.add(new Paragraph("El porcentaje de descuento es de un " + porcentaje + " sobre el total de la compra, con un tope de $" + tope + " pesos, y ¡aplica para todas las tiendas donde esté disponible este producto!."));

            document.add(new Phrase("\n"));

            document.add(new Paragraph("Imprime y presenta este cupón en en las tiendas asociadas a la oferta. Código: " + codigoBarra));

            document.add(new Phrase("\n"));

            Font f2 = new Font(FontFamily.HELVETICA, 13.0f, Font.ITALIC, BaseColor.BLACK);
            Paragraph condiciones = new Paragraph("Condiciones del cupón: ", f2);
            document.add(condiciones);

            document.add(new Phrase("\n"));

            List listCondiciones = new List(List.ORDERED);
            ListItem firstItem = new ListItem("Sólo se puede hacer efectivo el canje de un cupón por mes");
            ListItem thirdItem = new ListItem("El cliente tiene derecho a generar el cupón las veces que lo requiera incluyendo los nuevos puntos acumulados");
            ListItem fourItem = new ListItem("Las ofertas pueden variar durante el tiempo, MisOfertas no se hace responsable por productos no disponibles.");
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            listCondiciones.add(firstItem);
            listCondiciones.add(thirdItem);
            listCondiciones.add(fourItem);
            document.add(listCondiciones);

            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Cupon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cupon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Cupon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void PlaceChunck(PdfWriter writer, String text, int x, int y) throws DocumentException, IOException {
        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.saveState();
        cb.beginText();
        cb.moveText(x, y);
        cb.setFontAndSize(bf, 12);
        cb.showText(text);
        cb.endText();
        cb.restoreState();
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
