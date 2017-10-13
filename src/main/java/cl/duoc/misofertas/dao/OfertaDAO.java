/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.OfertaDTO;
import cl.duoc.misofertas.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beto
 */
public class OfertaDAO {


    public List<OfertaDTO> getAll() throws SQLException {

        Connection con = new DBConnection().connect();
        PreparedStatement ps = con.prepareStatement("select oferta.id_oferta, oferta.id_producto, oferta.descuento, oferta.descripcion, oferta.imagen, oferta.valor_final, oferta.rut_publicador, producto.nombre "
                + "from oferta "
                + "inner join producto "
                + "on producto.id_producto = oferta.id_producto "
                + "order by oferta.numero_visitas desc");
        ResultSet rs = ps.executeQuery();
        List<OfertaDTO> ofertas = new ArrayList<>();

        while (rs.next()) {
            OfertaDTO ofertaDTO = new OfertaDTO();
            ofertaDTO.setIdOferta(rs.getString("id_oferta"));
            ofertaDTO.setIdProducto(rs.getString("id_producto"));
            ofertaDTO.setDescuento(rs.getString("descuento"));
            ofertaDTO.setDescripcion(rs.getString("descripcion"));
            ofertaDTO.setImagen(rs.getString("imagen"));
            ofertaDTO.setValorFinal(rs.getString("valor_final"));
            ofertaDTO.setRutPublicador(rs.getString("rut_publicador"));
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(rs.getString("nombre"));
            ofertaDTO.setProductoDTO(productoDTO);
            ofertas.add(ofertaDTO);
        }

        return ofertas;
    }
    
    public static void main(String[] args) {
        OfertaDAO ofertaDAO = new OfertaDAO();
        try {
            List<OfertaDTO> ofertas = ofertaDAO.getAll();
            for (OfertaDTO oferta : ofertas) {
                System.out.println(oferta.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfertaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
