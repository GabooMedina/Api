/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.vichi.edu.TemplateMethod;

import java.util.Scanner;

/**
 *
 * @author jaevi
 */
public class MainTemplateMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        Network network = null;

        System.out.print("Ingrese nombre de usuario: ");
        String userName = tecla.nextLine();
        System.out.print("Ingrese el password: ");
        String password = tecla.nextLine();

        System.out.println("Ingrese el mensaje:");
        String mensaje = tecla.nextLine();

        System.out.println("""
                           
                           Seleccione la red social para postear el mensaje.
                           1. Facebook
                           2. Twitter""");

        int op = Integer.parseInt(tecla.nextLine());
        if (op == 1) {
            network = new Facebook(userName, password);
        } else if (op == 2) {
            network = new Twitter(userName, password);
        }
        network.post(mensaje);

    }

}
