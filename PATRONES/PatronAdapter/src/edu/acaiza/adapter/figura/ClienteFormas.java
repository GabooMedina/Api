/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.adapter.figura;

import java.util.List;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class ClienteFormas {

    public static void main(String[] args) {
        IForma linea = new Linea();
        IForma rombo = new Rombo();
        IForma texto = new CuadradoTextoAdapter();

        List<IForma> formas = new ArrayList<IForma>();
        formas.add(linea);
        formas.add(rombo);
        formas.add(texto);

        for (IForma forma : formas) {
            forma.dibujar();

        }
    }

}

