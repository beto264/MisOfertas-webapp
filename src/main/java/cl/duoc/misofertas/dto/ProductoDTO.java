/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

/**
 *
 * @author Beto
 */
public class ProductoDTO {
    
    private String nombre;
    private String descripcion;
    private RubroDTO rubro;

    public RubroDTO getRubro() {
        return rubro;
    }

    public void setRubro(RubroDTO rubro) {
        this.rubro = rubro;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", rubro=" + rubro + '}';
    }
    
    
}
