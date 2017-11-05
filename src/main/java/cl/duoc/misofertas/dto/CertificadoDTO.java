/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

import java.sql.Date;

/**
 *
 * @author Beto
 */
public class CertificadoDTO {
    
    private String idCertificado;
    private Date fechaEmision;
    private String rut;
    private long codigoBarra;
    private UsuarioDTO usuarioDTO;
    private DescuentoDTO descuento;

    public CertificadoDTO() {
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
    
    

    public CertificadoDTO(DescuentoDTO descuento) {
        this.descuento = descuento;
    }

    public DescuentoDTO getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentoDTO descuento) {
        this.descuento = descuento;
    }

    public String getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(String idCertificado) {
        this.idCertificado = idCertificado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public long getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(long codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    
    
    
}
