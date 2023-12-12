package edu.acaiza.factory;

public abstract class Figure {

    private String nombre;

    public Figure(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double area();

    public abstract double numeroOfSlides();

}
