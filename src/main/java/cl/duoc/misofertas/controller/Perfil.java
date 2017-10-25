/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.UsuarioDAO;
import cl.duoc.misofertas.dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class Perfil extends HttpServlet {

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

        request.getRequestDispatcher("perfil.jsp").forward(request, response);

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

        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String fono = request.getParameter("fono");
        String direccion = request.getParameter("direccion");
        String rut = request.getParameter("rut");

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsername(correo);
        usuarioDTO.setPassword(password);
        usuarioDTO.setFono(fono);
        usuarioDTO.setDireccion(direccion);
        usuarioDTO.setRut(rut);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean inserted = false;
        try {
            inserted = usuarioDAO.update(usuarioDTO);

            if (!inserted) {
                request.setAttribute("mensaje", "Ocurrió un error inesperado al actualizar el perfil. Intente nuevamente más tarde.");
            } else {
                request.setAttribute("mensaje", "Su perfil se ha actualizado correctamente.");
            }

        } catch (SQLException ex) {
             request.setAttribute("mensaje", "Ocurrió un error inesperado al actualizar el perfil. Intente nuevamente más tarde.");
        }

        request.getRequestDispatcher("perfil.jsp").forward(request, response);

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
