/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uta.patronFlyweight.Bosque;

import edu.uta.patronFlyweight.Arbol.Arbol;
import edu.uta.patronFlyweight.Arbol.FabricaArboles;
import edu.uta.patronFlyweight.Arbol.TipoArbol;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Bosque  extends JFrame{
    private List<Arbol> arboles= new ArrayList<Arbol>();
    
    public void plantarArbol(int x, int y, String nombre, Color color, String OtrodatoArbol){
        TipoArbol tipo = FabricaArboles.obtenerelTipo(nombre, color, OtrodatoArbol);
        Arbol arbol= new Arbol(x, y, tipo);
        arboles.add(arbol);
        
    }
    @Override
    public void paint( Graphics grafico){
        for (Arbol arbol: arboles) {
            arbol.dibujar(grafico);
            
        }
    }
    
}
