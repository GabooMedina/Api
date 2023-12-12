/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uta.patronFlyweight.Arbol;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author USUARIO
 */
public class TipoArbol {
    private String nombre;
    private Color color;
    private String otrodatoArbol;

    public TipoArbol(String nombre, Color color, String otrodatoArbol) {
        this.nombre = nombre;
        this.color = color;
        this.otrodatoArbol = otrodatoArbol;
    }
    
    public void  dibujar( Graphics g, int x, int y){
        g.setColor((Color.BLUE));
        g.fillRect(x-1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x-5, y-10, 10, 10);
    }
}
