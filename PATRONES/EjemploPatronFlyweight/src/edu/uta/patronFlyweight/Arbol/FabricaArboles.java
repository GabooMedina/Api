/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uta.patronFlyweight.Arbol;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class FabricaArboles {
    static  Map<String, TipoArbol> tipodArbol= new HashMap<>();
    
    
    public static TipoArbol obtenerelTipo( String nombre, Color color, String otrodatoArbol){
        TipoArbol resultado = tipodArbol.get(nombre);
        if (resultado == null) {
            resultado= new TipoArbol(nombre, color, otrodatoArbol);
            tipodArbol.put(nombre, resultado);
            
        }
        return resultado;
    }
    
    
}
