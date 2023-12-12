/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package edu.acaiza.factorysolucion;

import edu.acaiza.factory.Figure;

/**
 *
 * @author USUARIO
 */
public class FigureManagerFactory {

    private Figure figura;
    private FigureFactory factory;

    public FigureManagerFactory(FigureFactory fabrica) {
        this.factory = fabrica;
    }

    public void createFigure() {
        this.figura = this.factory.createFigure();

    }

    public Figure getFigura() {
        return figura;
    }

}
