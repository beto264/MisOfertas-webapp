/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

import java.util.ArrayList;
import java.util.List;
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
    private String visitas;
    private String valoraciones;
    private List<TiendaDTO> tiendas;
    private UsuarioDTO publicador;

    public OfertaDTO() {
    }

    

    public List<TiendaDTO> getTiendas() {
        if (tiendas == null) {
            tiendas = new ArrayList<>();
        }
        return tiendas;
    }

    public void setTiendas(List<TiendaDTO> tiendas) {
        this.tiendas = tiendas;
    }
    
    

    public String getVisitas() {
        return visitas;
    }

    public void setVisitas(String visitas) {
        this.visitas = visitas;
    }

    public String getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(String valoraciones) {
        this.valoraciones = valoraciones;
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

    public UsuarioDTO getPublicador() {
        return publicador;
    }

    public void setPublicador(UsuarioDTO publicador) {
        this.publicador = publicador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idOferta);
        hash = 97 * hash + Objects.hashCode(this.idProducto);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.descuento);
        hash = 97 * hash + Objects.hashCode(this.valorFinal);
        hash = 97 * hash + Objects.hashCode(this.imagen);
        hash = 97 * hash + Objects.hashCode(this.rutPublicador);
        hash = 97 * hash + Objects.hashCode(this.productoDTO);
        hash = 97 * hash + Objects.hashCode(this.visitas);
        hash = 97 * hash + Objects.hashCode(this.valoraciones);
        hash = 97 * hash + Objects.hashCode(this.tiendas);
        hash = 97 * hash + Objects.hashCode(this.publicador);
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
        if (!Objects.equals(this.visitas, other.visitas)) {
            return false;
        }
        if (!Objects.equals(this.valoraciones, other.valoraciones)) {
            return false;
        }
        if (!Objects.equals(this.productoDTO, other.productoDTO)) {
            return false;
        }
        if (!Objects.equals(this.tiendas, other.tiendas)) {
            return false;
        }
        if (!Objects.equals(this.publicador, other.publicador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfertaDTO{" + "idOferta=" + idOferta + ", idProducto=" + idProducto + ", descripcion=" + descripcion + ", descuento=" + descuento + ", valorFinal=" + valorFinal + ", imagen=" + imagen + ", rutPublicador=" + rutPublicador + ", productoDTO=" + productoDTO + ", visitas=" + visitas + ", valoraciones=" + valoraciones + ", tiendas=" + tiendas + ", publicador=" + publicador + '}';
    }    
    
}
