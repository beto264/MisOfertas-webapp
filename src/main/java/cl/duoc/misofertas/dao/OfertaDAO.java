/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.controller.Oferta;
import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.OfertaDTO;
import cl.duoc.misofertas.dto.ProductoDTO;
import cl.duoc.misofertas.dto.RubroDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Beto
 */
public class OfertaDAO {

    public List<OfertaDTO> getAll() throws SQLException {

        Connection con = new DBConnection().connect();

        String sp = "{call get_ofertas(?, ?, ?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, "ALIMENTOS");
        cs.setString(2, "ELECTRONICA");
        cs.setString(3, "ROPA");
        cs.registerOutParameter(4, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(4);

        List<OfertaDTO> ofertas = new ArrayList<>();

        while (rs.next()) {
            OfertaDTO ofertaDTO = new OfertaDTO();
            ofertaDTO.setIdOferta(rs.getString("id_oferta"));
            ofertaDTO.setIdProducto(rs.getString("id_producto"));
            ofertaDTO.setDescuento(rs.getString("descuento"));
            ofertaDTO.setDescripcion(rs.getString("descripcion_oferta"));
            ofertaDTO.setImagen(rs.getString("imagen"));
            ofertaDTO.setValorFinal(rs.getString("valor_final"));
            ofertaDTO.setRutPublicador(rs.getString("rut_publicador"));
            ofertaDTO.setVisitas(rs.getString("visitas_oferta"));
            ofertaDTO.setValoraciones(rs.getString("valoraciones"));

            RubroDTO rubroDTO = new RubroDTO();
            rubroDTO.setNombre(rs.getString("rubro"));

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(rs.getString("producto"));
            productoDTO.setDescripcion(rs.getString("descripcion_producto"));
            productoDTO.setRubro(rubroDTO);

            ofertaDTO.setProductoDTO(productoDTO);

            if (ofertaDTO.getImagen() == null || ofertaDTO.getImagen().isEmpty()) {
                ofertaDTO.setImagen("not_found.png");
            }

            ofertas.add(ofertaDTO);
        }

        return ofertas;
    }

    public OfertaDTO getOfertaById(String id) throws SQLException {

        Connection con = new DBConnection().connect();

        PreparedStatement ps = con.prepareStatement("select * from oferta where id_oferta = ? ");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        OfertaDTO ofertaDTO = null;
        while (rs.next()) {
            ofertaDTO = new OfertaDTO();
            ofertaDTO.setIdOferta(rs.getString("id_oferta"));
            ofertaDTO.setIdProducto(rs.getString("id_producto"));
            ofertaDTO.setDescuento(rs.getString("descuento"));
            ofertaDTO.setDescripcion(rs.getString("descripcion"));
            ofertaDTO.setImagen(rs.getString("imagen"));
            ofertaDTO.setValorFinal(rs.getString("valor_final"));
            ofertaDTO.setRutPublicador(rs.getString("rut_publicador"));
            ofertaDTO.setVisitas(rs.getString("numero_visitas"));
        }

        return ofertaDTO;
    }
    
    public int addVisita(String id, String conteoVisita) throws SQLException{
        Connection con = new DBConnection().connect();

        String sp = "{call add_visita(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, id);
        cs.setString(2, conteoVisita);

        int count = cs.executeUpdate();
        return count;
        
    }
    
    public static void main(String[] args) {
        OfertaDAO o = new OfertaDAO();
        try {
            List<OfertaDTO> ofertas = o.getAll();
            for (OfertaDTO oferta : ofertas) {
                         System.out.println(oferta);   
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
