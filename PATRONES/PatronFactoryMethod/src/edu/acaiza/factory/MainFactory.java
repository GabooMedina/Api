/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factory;

import edu.acaiza.factorysolucion.CreateCricle;
import edu.acaiza.factorysolucion.CreatorDiamond;
import edu.acaiza.factorysolucion.CreatorDiamond;
import edu.acaiza.factorysolucion.CreatorSquare;
import edu.acaiza.factorysolucion.CreatorTriangle;
import edu.acaiza.factorysolucion.FigureFactory;
import edu.acaiza.factorysolucion.FigureManagerFactory;

/**
 *
 * @author USUARIO
 */
public class MainFactory {

    public static void main(String[] args) {
        //sin factory 
        /*FigureManager figuremanager = new FigureManager(FigureType.TRIANGLE);
        figuremanager.createFigure();
        System.out.println("Nombre = " + figuremanager.getFigure().getNombre());
        System.out.println("Area = " + figuremanager.getFigure().area());
        System.out.println("Side = " + figuremanager.getFigure().numeroOfSlides());*/
        //
        FigureManagerFactory figuremanager = new FigureManagerFactory(new CreateCricle());
        figuremanager.createFigure();
        System.out.println("Figure : " + figuremanager.getFigura().getNombre());
        System.out.println("Area : " + figuremanager.getFigura().area());
        System.out.println("Side : " + figuremanager.getFigura().numeroOfSlides());

        System.out.println("......................................");
        figuremanager = new FigureManagerFactory(new CreatorSquare());
        figuremanager.createFigure();
        figuremanager.createFigure();
        System.out.println("Figure : " + figuremanager.getFigura().getNombre());
        System.out.println("Area : " + figuremanager.getFigura().area());
        System.out.println("Side : " + figuremanager.getFigura().numeroOfSlides());

        System.out.println("......................................");
        figuremanager = new FigureManagerFactory(new CreatorDiamond());
        figuremanager.createFigure();
        System.out.println("Figure : " + figuremanager.getFigura().getNombre());
        System.out.println("Area : " + figuremanager.getFigura().area());
        System.out.println("Side : " + figuremanager.getFigura().numeroOfSlides());
    
}
}
