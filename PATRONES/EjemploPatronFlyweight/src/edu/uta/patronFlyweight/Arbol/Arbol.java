/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uta.patronFlyweight.Arbol;

import java.awt.Graphics;

/**
 *
 * @author USUARIO
 */
public class Arbol {
    private int x;
    private int y;
     private TipoArbol tipo;

    public Arbol(int x, int y, TipoArbol tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }
     
     public void dibujar(Graphics g){
         tipo.dibujar(g, x, y);
     }
    
}
