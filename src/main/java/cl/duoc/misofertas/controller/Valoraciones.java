/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.ValoracionDAO;
import cl.duoc.misofertas.dto.ValoracionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Beto
 */
public class Valoraciones extends HttpServlet {

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
        request.getRequestDispatcher("valoraciones.jsp").forward(request, response);
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
        
        try {
            HttpSession session = request.getSession();
            
            ValoracionDAO valoracionDAO = new ValoracionDAO();
            List<ValoracionDTO> valoraciones =  valoracionDAO.getValoraciones(request.getParameter("id"));
            
            session.setAttribute("valoraciones", valoraciones);
            request.getRequestDispatcher("valoraciones.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Valoraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

        String idOferta = "";
        String rut = "";
        String nota = "";
        String comentario = "";

        try {

            String fileName = "";

            final String DATA_DIRECTORY = "boletas";
            final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
            final int MAX_REQUEST_SIZE = 1024 * 1024;

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Sets the size threshold beyond which files are written directly to
            // disk.
            factory.setSizeThreshold(MAX_MEMORY_SIZE);

            // Sets the directory used to temporarily store files that are larger
            // than the configured size threshold. We use temporary directory for
            // java
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            // constructs the folder where uploaded file will be stored
            String uploadFolder = getServletContext().getRealPath("/")
                    + File.separator + DATA_DIRECTORY;

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(MAX_REQUEST_SIZE);

            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            ListIterator iter = items.listIterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                //Refactorizar codigo
                if (item.isFormField()) {
                    String idValue = (String) item.getFieldName();
                    if (idValue.equalsIgnoreCase("id_oferta")) {
                        idOferta = (String) item.getString();
                    }
                    if (idValue.equalsIgnoreCase("rut")) {
                        rut = (String) item.getString();
                    }
                    if (idValue.equalsIgnoreCase("nota")) {
                        nota = (String) item.getString();
                    }
                    if (idValue.equalsIgnoreCase("comentario")) {
                        comentario = (String) item.getString();
                    }
                }

            }

            while (iter.hasPrevious()) {
                FileItem item = (FileItem) iter.previous();
                if (!item.isFormField()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    fileName = new File(idOferta + "--" + rut + "--" + sdf.format(new Date()) + "--" +  item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }

            }

            ValoracionDAO valoracionDAO = new ValoracionDAO();

            valoracionDAO.addValoracion(idOferta, rut, fileName, nota, comentario);
            
            request.setAttribute("success", "OK");
            
            request.getRequestDispatcher(
                    "home.jsp").forward(request, response);

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            Logger.getLogger(Valoraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
