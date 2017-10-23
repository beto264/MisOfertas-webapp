/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.utils;

import java.text.DecimalFormat;

/**
 *
 * @author Beto
 */
public class StringUtil {
    
    public static String separarMiles(String texto){
        final DecimalFormat formato = new DecimalFormat("###,###.##");
        return formato.format(texto);
    }
}
