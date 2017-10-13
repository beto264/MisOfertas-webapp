/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

import java.util.Objects;

/**
 *
 * @author Beto
 */
public class OfertaDTO {

    private String idOferta;
    private String idProducto;
    private String descripcion;
    private String descuento;
    private String valorFinal;
    private String imagen;
    private String rutPublicador;
    private ProductoDTO productoDTO;

    public OfertaDTO() {
    }

    public OfertaDTO(String idOferta, String idProducto, String descripcion, String descuento, String valorFinal, String imagen, String rutPublicador) {
        this.idOferta = idOferta;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.valorFinal = valorFinal;
        this.imagen = imagen;
        this.rutPublicador = rutPublicador;
    }

    public String getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(String idOferta) {
        this.idOferta = idOferta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRutPublicador() {
        return rutPublicador;
    }

    public void setRutPublicador(String rutPublicador) {
        this.rutPublicador = rutPublicador;
    }
    
    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

    @Override
    public String toString() {
        return "OfertaDTO{" + "idOferta=" + idOferta + ", idProducto=" + idProducto + ", descripcion=" + descripcion + ", descuento=" + descuento + ", valorFinal=" + valorFinal + ", imagen=" + imagen + ", rutPublicador=" + rutPublicador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idOferta);
        hash = 37 * hash + Objects.hashCode(this.idProducto);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.descuento);
        hash = 37 * hash + Objects.hashCode(this.valorFinal);
        hash = 37 * hash + Objects.hashCode(this.imagen);
        hash = 37 * hash + Objects.hashCode(this.rutPublicador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OfertaDTO other = (OfertaDTO) obj;
        if (!Objects.equals(this.idOferta, other.idOferta)) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.descuento, other.descuento)) {
            return false;
        }
        if (!Objects.equals(this.valorFinal, other.valorFinal)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.rutPublicador, other.rutPublicador)) {
            return false;
        }
        return true;
    }
    
    
}
