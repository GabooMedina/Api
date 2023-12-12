/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.factory;

/**
 *
 * @author USUARIO
 */
public class FigureManager {

    private Figure figure;
    private FigureType type;

    public FigureManager(FigureType type) {
        this.type = type;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public FigureType getType() {
        return type;
    }

    public void setType(FigureType type) {
        this.type = type;
    }
    
    

    public void createFigure() {
        if (this.type == FigureType.CIRCLE) {
            this.figure = new Circle("Circulo", 1);

        } else if (this.type == FigureType.SQUARE) {
            this.figure = new Square("Cuadrado", 3);

        } else if (this.type == FigureType.TRIANGLE) {
            this.figure = new Triangle("Cuadrado", 3, 4);

        } else {
            assert false : "unexpected";
        }

    }

    @Override
    public String toString() {
        return "FigureManager{" + "figure=" + figure + ", type=" + type + '}';
    }

}
