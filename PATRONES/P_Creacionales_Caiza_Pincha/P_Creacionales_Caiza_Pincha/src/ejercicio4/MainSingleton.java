/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author USUARIO
 */
public class MainSingleton {
    public static void main(String[] args) throws InterruptedException {
        
        Reloj r = Reloj.getInstance();

        while (true) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(r.getHora());
        }
    }
    
}
