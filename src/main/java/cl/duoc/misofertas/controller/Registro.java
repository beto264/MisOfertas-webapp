/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.UsuarioDAO;
import cl.duoc.misofertas.dto.UsuarioDTO;
import java.io.IOException;
import java.sql.SQLException;
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
public class Registro extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        request.getRequestDispatcher("registro.jsp").forward(request, response);
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

        HttpSession sesion = request.getSession();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean exists = false;
        boolean registered = false;
        String mensajeError = "";

        try {
            usuarioDTO.setApellido(request.getParameter("apellido"));
            usuarioDTO.setDireccion(request.getParameter("direccion"));
            usuarioDTO.setFono(request.getParameter("fono"));
            usuarioDTO.setNombre(request.getParameter("nombre"));
            usuarioDTO.setPassword(request.getParameter("password"));
            usuarioDTO.setRut(request.getParameter("rut"));
            usuarioDTO.setUsername(request.getParameter("correo"));

            exists = usuarioDAO.userExists(usuarioDTO.getUsername(), usuarioDTO.getRut());
            mensajeError = exists ? "Ya fue registrado ese usuario." : "";

            if (!exists) {
                registered = usuarioDAO.addUser(usuarioDTO);

                //Traemos el usuario insertado
                usuarioDTO = usuarioDAO.getUserByEmail(request.getParameter("correo"));

                request.setAttribute("password", usuarioDTO.getPassword());
                request.setAttribute("correo", usuarioDTO.getUsername());

                sesion.setAttribute("usuario", usuarioDTO.getNombre());
                sesion.setAttribute("rol", usuarioDTO.getRol());
                
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.setAttribute("error", mensajeError);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            mensajeError = "Ocurrio un error inesperado. Intente nuevamente.";
            request.setAttribute("error", mensajeError);
            request.getRequestDispatcher("registro.jsp").forward(request, response);
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
