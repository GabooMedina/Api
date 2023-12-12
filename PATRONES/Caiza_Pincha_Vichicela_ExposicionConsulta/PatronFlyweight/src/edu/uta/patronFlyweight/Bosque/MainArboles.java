/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uta.patronFlyweight.Bosque;

import java.awt.Color;

/**
 *
 * @author USUARIO
 */
public class MainArboles {

    static int tamañoVenta = 500;
    static int arboles_a_dibujar = 1000;
    static int tipoArboles = 4;

    public static void main(String[] args) {
        Bosque bosque = new Bosque();
        for (int i = 0; i < Math.floor(arboles_a_dibujar / tipoArboles); i++) {
            bosque.plantarArbol(random(0, tamañoVenta), random(0, tamañoVenta), "Roble", Color.GREEN, "La textura es de roble ");
            bosque.plantarArbol(random(0, tamañoVenta), random(0, tamañoVenta), "Eucalipto", Color.blue, "La textura es de Eucalipto ");
            bosque.plantarArbol(random(0, tamañoVenta), random(0, tamañoVenta), "Pino", Color.DARK_GRAY, "eXPORTADO DESDE EEUU");
            bosque.plantarArbol(random(0, tamañoVenta), random(0, tamañoVenta), "Ceprez", Color.MAGENTA, "Nuevo arbol ");
        }

        bosque.setSize(tamañoVenta, tamañoVenta);
        bosque.setVisible(true);
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
