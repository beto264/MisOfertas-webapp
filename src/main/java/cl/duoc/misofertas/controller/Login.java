/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.UsuarioDAO;
import cl.duoc.misofertas.dto.UsuarioDTO;
import cl.duoc.misofertas.utils.Constants;
import cl.duoc.misofertas.utils.Roles;
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
public class Login extends HttpServlet {

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

        //login/out
//        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
//        HttpSession sesion = request.getSession();
//        if (action.equals("/out")) {
//            sesion.invalidate();
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("home.jsp").forward(request, response);
//        }
        response.sendRedirect("login.jsp");

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
        usuarioDTO.setUsername(request.getParameter("correo"));
        usuarioDTO.setPassword(request.getParameter("password"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean isValidUser = false;
        try {
            isValidUser = usuarioDAO.validUser(usuarioDTO);
            usuarioDTO = usuarioDAO.getUserByEmail(usuarioDTO.getUsername());
            
            //acá traer las valoraciones realizadas por el usuario
            //las visualizaciones totales
            //los puntos acumulados
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if (isValidUser) {
            if (!usuarioDTO.getRol().equalsIgnoreCase(Roles.Consumidor.name()) && !usuarioDTO.getRol().equalsIgnoreCase(Roles.Gerente.name())) {
                request.setAttribute("error",  Constants.NO_POSEE_PERMISOS_USUARIO);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                sesion.setAttribute("usuario", usuarioDTO);
                sesion.setAttribute("rol", usuarioDTO.getRol());
                request.getRequestDispatcher("home").forward(request, response);
            }
        } else {
            request.setAttribute("error", Constants.DATOS_INVALIDOS_USUARIO);
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
