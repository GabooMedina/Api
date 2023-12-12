/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class Reloj {
    private static Reloj instance;

    private Reloj() {

    }
    
    public static Reloj getInstance() {
        if (instance == null) {
            return new Reloj();
        }
        return instance;
    }

    public Date getHora() {
        Date hora = new Date(System.currentTimeMillis());

        return hora;
    }
    
}
