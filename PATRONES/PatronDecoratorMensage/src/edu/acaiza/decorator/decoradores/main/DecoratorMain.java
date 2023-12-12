/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.decorator.decoradores.main;

import edu.acaiza.decorator.decoradores.EncryptMensaje;
import edu.acaiza.decorator.decoradores.SOAPEnvelopMensaje;
import edu.acaiza.decorator.decoradores.XMLFormateDecorator;
import edu.acaiza.decorator.mensaje.*;

/**
 *
 * @author USUARIO
 */
public class DecoratorMain {

    public static void main(String[] args) {
        MensajeCliente mensajeCliente = new MensajeCliente("Gabriel Caiza", "acaiza@uta.edu.ec", "0967329710");
        System.out.println("Mensaje Original = " + mensajeCliente);
        IMensaje mensaje1 = new EncryptMensaje("usuario", "HG58YZ3CR9123456",
                new SOAPEnvelopMensaje(
                        new XMLFormateDecorator(mensajeCliente)));
        mensaje1 = mensaje1.procesarMensaje();
        System.out.println("Mensaje 1 , Cncriptada ==\n"
                + mensaje1.getContenidoMensaje() + "\n\n");
        System.out.println("-------------------------------------------------------------------------------------");
        IMensaje mensaje2 = new SOAPEnvelopMensaje(new EncryptMensaje("usuario2", "HG58YZ3CR9123456",
                new XMLFormateDecorator(mensajeCliente)));
        mensaje2.procesarMensaje();

        System.out.println("Mensaje 2 , Cncriptada ==\n"
                + mensaje2.getContenidoMensaje() + "\n\n");
        System.out.println("-------------------------------------------------------------------------------------");
        IMensaje mensaje3 = new EncryptMensaje("usuario2", "HG58YZ3CR9123456",
                new XMLFormateDecorator(mensajeCliente));
         mensaje3.procesarMensaje();
        System.out.println("Mensaje 3 , Cncriptada ==\n"
                + mensaje3.getContenidoMensaje() + "\n\n");
    }

}
