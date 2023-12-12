/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio6.abstractfactory;

/**
 *
 * @author USUARIO
 */
public interface FabricaAbstractTipoCuenta {
    
    ICuenta getCuenta();
    ITarjetaCredito getTarjetaCredito();
    ITarjetaDebito getTarjetaDebito();
    IRegalo getRegalo();
    
     void crearCuenta();
    
    
}
