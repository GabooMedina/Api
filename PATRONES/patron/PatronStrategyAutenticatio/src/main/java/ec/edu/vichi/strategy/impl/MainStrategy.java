/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.vichi.strategy.impl;

import ec.edu.vichi.strategy.providers.OnMemoryAutenticationProvider;
import ec.edu.vichi.strategy.providers.SQLAutenticationProvider;
import ec.edu.vichi.strategy.providers.XMLAutenticationProvider;
import java.io.*;

/**
 *
 * @author jaevi
 */
public class MainStrategy {
            

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AuntenticationProvide contexto;
        contexto = new AuntenticationProvide(); 
        char pregunta;
        String usuario, password;

        do {
            System.out.println("""
                               Tipo de Auntetificacion a utilizar:
                               1. OnMemory Authentication
                               2. SQL Authentication
                               3. XML Authentication
                               """);
            System.out.println("Por favor, Seleccione una opción: ");
            String opcion = reader.readLine();
            switch (opcion) {
                case "1" -> {
                    System.out.println("Authentication OnMemory selecionada =>");
                    contexto.setAuntenticationProvideide(new OnMemoryAutenticationProvider());
                }
                case "2" -> {
                    System.out.println("Authentication SQL selecionada =>");
                    contexto.setAuntenticationProvideide(new SQLAutenticationProvider());
                }
                case "3" -> {
                    System.out.println("Authentication XML selecionada =>");
                    contexto.setAuntenticationProvideide(new XMLAutenticationProvider());
                }
                default -> {
                }
            }
            System.out.println("");
            System.out.println("Favor autenticarse:");
            System.out.print("Usuartio: ");
            usuario = reader.readLine();
            System.out.print("Contraseña: ");
            password = reader.readLine();
            Principal p1 = contexto.autenticate(usuario, password);
            if (p1 != null) {
                System.out.println("Autentificación Exitosa!.");
                System.out.println(p1.toString());
                pregunta = 'N';
            } else {
                System.out.println("Usuario o Contraseña Invalidos..");
                System.out.println("Desea cambiar el Método de autenticación? (S/N) = ");
                pregunta = reader.readLine().toUpperCase().charAt(0);
            }

        } while (pregunta == 'S');
    }
}
