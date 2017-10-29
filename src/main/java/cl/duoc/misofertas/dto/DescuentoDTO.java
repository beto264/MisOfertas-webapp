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
public class DescuentoDTO {
    
    private String idDescuento;
    private RubroDTO rubro;
    private String porcentaje;
    private String tope;

    public DescuentoDTO() {
    }

    public DescuentoDTO(String idDescuento, RubroDTO rubro, String porcentaje, String tope) {
        this.idDescuento = idDescuento;
        this.rubro = rubro;
        this.porcentaje = porcentaje;
        this.tope = tope;
    }

    public String getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(String idDescuento) {
        this.idDescuento = idDescuento;
    }

    public RubroDTO getRubro() {
        return rubro;
    }

    public void setRubro(RubroDTO rubro) {
        this.rubro = rubro;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTope() {
        return tope;
    }

    public void setTope(String tope) {
        this.tope = tope;
    }

    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
}
