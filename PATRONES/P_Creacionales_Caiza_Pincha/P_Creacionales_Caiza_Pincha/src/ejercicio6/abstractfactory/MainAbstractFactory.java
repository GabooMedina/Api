/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory;

import ejercicio6.abstractfactory.fabricacuentas.FabricaCuenta10;
import ejercicio6.abstractfactory.fabricacuentas.FabricaCuentaEstandar;
import ejercicio6.abstractfactory.fabricacuentas.FabricaCuentaJoven;
import ejercicio6.abstractfactory.fabricacuentas.FabricaCuentaOro;

/**
 *
 * @author USUARIO
 */
public class MainAbstractFactory {
    public static void main(String[] args) {
        System.out.println("--------------------CUENTA JOVEN---------------------------");
        FabricaAbstractTipoCuenta cJoven = new FabricaCuentaJoven();
        cJoven.crearCuenta();
        
        ICuenta c1 = cJoven.getCuenta();
        c1.generarCuenta();
        c1.getPropiedad();
        
        ITarjetaDebito td1 = cJoven.getTarjetaDebito();
        td1.generarTarjetaDebito();
        td1.getPropiedad();
        
        IRegalo r1 = cJoven.getRegalo();
        r1.generarRegalo();
        r1.getPropiedad();
        
        System.out.println("--------------------CUENTA 10---------------------------");
        
        FabricaAbstractTipoCuenta c10 = new FabricaCuenta10();
        c10.crearCuenta();
        
        ICuenta c2 = c10.getCuenta();
        c2.generarCuenta();
        c2.getPropiedad();
        
        ITarjetaDebito td2 = c10.getTarjetaDebito();
        td2.generarTarjetaDebito();
        td2.getPropiedad();
        
        ITarjetaCredito tc1 = c10.getTarjetaCredito();
        tc1.generarTarjetaCredito();
        tc1.getPropiedad();
        
        IRegalo r2 = c10.getRegalo();
        r2.generarRegalo();
        r2.getPropiedad();
        
        System.out.println("--------------------CUENTA ORO---------------------------");
        
        FabricaAbstractTipoCuenta cOro = new FabricaCuentaOro();
        cOro.crearCuenta();
        
        ICuenta c3 = cOro.getCuenta();
        c3.generarCuenta();
        c3.getPropiedad();
        
        ITarjetaDebito td3 = cOro.getTarjetaDebito();
        td3.generarTarjetaDebito();
        td3.getPropiedad();
        
        ITarjetaCredito tc2 = cOro.getTarjetaCredito();
        tc2.generarTarjetaCredito();
        tc2.getPropiedad();
        
        IRegalo r3 = cOro.getRegalo();
        r3.generarRegalo();
        r3.getPropiedad();
        
        
        
        System.out.println("--------------------CUENTA ESTANDAR---------------------------");
        
        FabricaAbstractTipoCuenta cEstandar = new FabricaCuentaEstandar();
        cEstandar.crearCuenta();
        
        ICuenta c4 = cEstandar.getCuenta();
        c4.generarCuenta();
        c4.getPropiedad();
        
        ITarjetaDebito td4 = cEstandar.getTarjetaDebito();
        td4.generarTarjetaDebito();
        td4.getPropiedad();
        
    }
    }
    

