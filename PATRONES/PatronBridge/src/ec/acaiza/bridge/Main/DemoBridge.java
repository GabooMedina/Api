
package ec.acaiza.bridge.Main;

import ec.acaiza.bridge.abstracion.ControlAvanzado;
import ec.acaiza.bridge.abstracion.ControlRemotoBasico;
import ec.acaiza.bridge.implementacion.IDispositivo;
import ec.acaiza.bridge.implementacion.Tv;


public class DemoBridge {
    public static void main(String[] args) {
  
        pruebaDeDispositivo(new Tv());
    }
    public static void pruebaDeDispositivo(IDispositivo dispositivo){
      System.out.println("Prueba de control remoto Basica");
        ControlRemotoBasico controlBasico = new ControlRemotoBasico(dispositivo);
        controlBasico.encender();
        dispositivo.imprimirEstado();
        controlBasico.subirVolumen();
        controlBasico.subirCanal();
        dispositivo.imprimirEstado();
        controlBasico.encender();
        dispositivo.imprimirEstado();
        controlBasico.encender();
        controlBasico.bajarVolumen();
        dispositivo.imprimirEstado();
        System.out.println("Prueba con el control remoto avanzado");
        ControlAvanzado controlAvanzado = new ControlAvanzado(dispositivo);
        controlAvanzado.subirVolumen();
        controlAvanzado.bajarCanal();
        controlAvanzado.mute();
        dispositivo.imprimirEstado();
        
    }
    }

