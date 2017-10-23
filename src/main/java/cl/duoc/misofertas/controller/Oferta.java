/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.controller;

import cl.duoc.misofertas.dao.OfertaDAO;
import cl.duoc.misofertas.dto.OfertaDTO;
import cl.duoc.misofertas.dto.TiendaDTO;
import cl.duoc.misofertas.services.GoogleMapsGeoClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class Oferta extends HttpServlet {

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
        List<TiendaDTO> tiendas = new ArrayList<>();
        
        String id = request.getParameter("id");

        OfertaDTO ofertaDTO = null;

        OfertaDAO ofertaDAO = new OfertaDAO();
        try {
            ofertaDTO = ofertaDAO.getOfertaById(id);
            String visitasActuales =ofertaDTO.getVisitas();
            int visitas = Integer.valueOf(visitasActuales) + 1;
            ofertaDAO.addVisita(id, String.valueOf(visitas));
            tiendas = ofertaDAO.getTiendasByOferta(id);
            setLocaciones(tiendas);
            
        } catch (Exception ex) {
            Logger.getLogger(Oferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("tiendas", tiendas);
        session.setAttribute("oferta", ofertaDTO);
        request.getRequestDispatcher("oferta.jsp").forward(request, response);
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

    private void setLocaciones(List<TiendaDTO> tiendas) {
        for (TiendaDTO tienda : tiendas) {
            GoogleMapsGeoClient googleMapsGeoClient = new GoogleMapsGeoClient(tienda.getDireccion(), tienda.getNumero());
            Double[] locacion = googleMapsGeoClient.getLocacion();
            tienda.setLongitud(locacion[0]);
            tienda.setLatitud(locacion[1]);
        }
    }

}
