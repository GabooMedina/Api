/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factorysolucion;

import edu.acaiza.factory.Figure;
import edu.acaiza.factory.Square;

/**
 *
 * @author USUARIO
 */
public class CreatorSquare extends FigureFactory {

    @Override
    public Figure createFigure() {
        return new Square("Cuadrado", 4);
        
    }
    
    
}
