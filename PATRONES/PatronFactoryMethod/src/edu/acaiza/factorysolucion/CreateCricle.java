/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factorysolucion;

import edu.acaiza.factory.Circle;
import edu.acaiza.factory.Figure;

/**
 *
 * @author USUARIO
 */
public class CreateCricle extends FigureFactory {

    @Override
    public Figure createFigure() {
        return new Circle("Circulo", 2);

    }

}
