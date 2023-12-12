/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.acaiza.proxy.main;

import ec.acaiza.proxy.implement.DefaultProcessEjecutor;
import ec.acaiza.proxy.implement.IProcessProxy;
import ec.acaiza.proxy.implement.SeriviceFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class MainProxy {

    public static void main(String[] args) {
        String usuario = "acaiza";
            String clave = "1234";
            int process=1;
             IProcessProxy ejecutarProceso = SeriviceFactory.createProcessEjecutor();
        try {
            
           
            ejecutarProceso.ejecuteProcess(process, usuario, clave);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
