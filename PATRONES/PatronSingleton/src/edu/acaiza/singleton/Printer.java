/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.singleton;

public class Printer {

    private static Printer instance;
    private int nOfPages;

    private Printer() {

    }

    public static Printer getInstance() {

        return instance == null ? instance = new Printer() : instance;

    }

    public void print(String text) {
        System.out.println(text + " \n"
                + " Numero impresas hoy: " + ++nOfPages + "\n"
                + "----------");

    }

}
