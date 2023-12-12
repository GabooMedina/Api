/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6.abstractfactory.regalo;

import ejercicio6.abstractfactory.IRegalo;

/**
 *
 * @author USUARIO
 */
public class RegaloJoven  implements IRegalo{

    @Override
    public void getPropiedad() {
        System.out.println(" Ragala un  CD musica");    }

    @Override
    public void generarRegalo() {
        System.out.println("--Generando Regalo....");    }
    
}
