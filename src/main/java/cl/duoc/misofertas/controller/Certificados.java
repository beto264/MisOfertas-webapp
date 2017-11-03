/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.CertificadoDAO;
import cl.duoc.misofertas.dao.DescuentoDAO;
import cl.duoc.misofertas.dao.UsuarioDAO;
import cl.duoc.misofertas.dto.CertificadoDTO;
import cl.duoc.misofertas.dto.DescuentoDTO;
import cl.duoc.misofertas.dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Beto
 */
public class Certificados extends HttpServlet {

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
        HttpSession session = request.getSession();

        UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute("usuario");
        DescuentoDAO descuentoDAO = new DescuentoDAO();
        CertificadoDAO certificadoDAO = new CertificadoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (request.getParameter("action").equalsIgnoreCase("add")) {

            List<DescuentoDTO> descuentos = new ArrayList<>();

            boolean exist = false;
            try {
                exist = certificadoDAO.certificadoExists();
            } catch (SQLException ex) {
                Logger.getLogger(Certificados.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Certificados.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!exist) {
                try {
                    UsuarioDTO user = usuarioDAO.getUserByEmail(usuarioDTO.getUsername());

                    descuentos = descuentoDAO.getDescuentosByPuntos(user.getPuntosAcumulados());

                    CertificadoDTO certificadoDTO = new CertificadoDTO();
                    certificadoDTO.setRut(usuarioDTO.getRut());

                    //codigo de barra:
                    //3 utimos digitos del rut
                    //id certificado
                    //fecha completa
                    long codigoBarra = crearCodigoBarra(usuarioDTO, certificadoDTO);
                    certificadoDTO.setCodigoBarra(codigoBarra);

                    for (DescuentoDTO descuento : descuentos) {
                        //agregamos los descuentos al certificado
                        certificadoDTO.setDescuento(descuento);
                        certificadoDAO.addCertificado(certificadoDTO);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Certificados.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("mensaje", "Cupón generado correctamente");
                request.setAttribute("cupon", null);
            } else {
                request.setAttribute("cupon", null);
            }
                    request.getRequestDispatcher("perfil").forward(request, response);
        } else if (request.getParameter("action").equalsIgnoreCase("list")) {
            UsuarioDTO user = new UsuarioDTO();
            try {
                user = usuarioDAO.getUserByEmail(usuarioDTO.getUsername());
                List<CertificadoDTO> certificados = certificadoDAO.getByRut(user.getRut());
                request.setAttribute("certificados", certificados);
                request.getRequestDispatcher("cupones.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Certificados.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Certificados.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (request.getParameter("action").equalsIgnoreCase("get")) {
            String rut = usuarioDTO.getRut();
            String idCertificado = request.getParameter("id");
            
            //con estos 2 datos podemos generar el reporte
            
            
            
            request.getRequestDispatcher("home").forward(request, response);
            
        }else{
            request.getRequestDispatcher("cupones.jsp").forward(request, response);
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

    private long crearCodigoBarra(UsuarioDTO usuarioDTO, CertificadoDTO certificadoDTO) {
        String[] rutSplitted = usuarioDTO.getRut().split("-");
        String rutSinDigito = rutSplitted[0];

        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        StringBuilder sb = new StringBuilder();
        sb.append(rutSinDigito.substring(5, 8))
                .append(year)
                .append(month)
                .append(day)
                .append(hour)
                .append(minute);

        return Long.valueOf(sb.toString());
    }

}
