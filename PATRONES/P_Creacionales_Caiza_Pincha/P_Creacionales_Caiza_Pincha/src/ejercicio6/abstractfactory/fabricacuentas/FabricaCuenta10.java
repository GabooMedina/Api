/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.fabricacuentas;

import ejercicio6.abstractfactory.FabricaAbstractTipoCuenta;
import ejercicio6.abstractfactory.ICuenta;
import ejercicio6.abstractfactory.IRegalo;
import ejercicio6.abstractfactory.ITarjetaCredito;
import ejercicio6.abstractfactory.ITarjetaDebito;
import ejercicio6.abstractfactory.regalo.Regalo10;
import ejercicio6.abstractfactory.tarjetacredito.TarjetaCredito10;
import ejercicio6.abstractfactory.tarjetadebito.TarjetaDebito10;
import ejercicio6.abstractfactory.tipocuenta.Cuenta10;

/**
 *
 * @author USUARIO
 */
public class FabricaCuenta10 implements FabricaAbstractTipoCuenta {

    private Cuenta10 cuenta10;
    private TarjetaDebito10 tarjetaDebito10;
    private TarjetaCredito10 tarjetaCredito10;
    private Regalo10 regalo10;

    @Override
    public void crearCuenta() {
        cuenta10 = new Cuenta10();
        tarjetaDebito10 = new TarjetaDebito10();
        tarjetaCredito10 = new TarjetaCredito10();
        regalo10 = new Regalo10();

    }

    @Override
    public ICuenta getCuenta() {
        return cuenta10;
    }

    @Override
    public ITarjetaCredito getTarjetaCredito() {
        return   tarjetaCredito10;
    }

    @Override
    public ITarjetaDebito getTarjetaDebito() {
        return  tarjetaDebito10;
    }

    @Override
    public IRegalo getRegalo() {
        return regalo10;
    }

}
