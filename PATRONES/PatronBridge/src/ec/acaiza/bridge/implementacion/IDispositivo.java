/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.acaiza.bridge.implementacion;

/**
 *
 * @author USUARIO
 */
public interface IDispositivo {
    boolean estHabilitado();
    void habilitar();
    void inhabilitado();
    int  getVolumen();
    void setVolumen(int porcentaje);
    int getCanal();
    void setCanal(int canal);
    void imprimirEstado();
    
    
}
