/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.PaisSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PaisesList {

    private static PaisesList instance = null;

    private List paises = null;

    private PaisesList() {

    }

    public static PaisesList getInstance() {
        return instance == null ? instance = new PaisesList() : instance;
    }

    public List getPaises() {

        if (paises == null) {
            paises = new ArrayList();

            Pais p1 = new Pais("PERU");
            Pais p2 = new Pais("COLOMBIA");
            Pais p3 = new Pais("ECUADOR");
            paises.add(p1);
            paises.add(p2);
            paises.add(p3);

        }

        return paises ;
    }

}
