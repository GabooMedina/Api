/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.singleton;

/**
 *
 * @author USUARIO
 */
public class Employee {

    private String name;
    private String role;
    private String assignment;

    public Employee(String name, String role, String assignment) {
        this.name = name;
        this.role = role;
        this.assignment = assignment;
    }

    public void printCurrentAssignment() {
        Printer printer = Printer.getInstance();
        printer.print("Employe = " + name + "\n"
                + "Role =" + role + "\n"
                + "Assognment =" + assignment + "\n");

    }

}
