/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.decorator.decoradores;

import edu.acaiza.decorator.mensaje.IMensaje;
import java.security.Key;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author USUARIO
 */
public class EncryptMensaje extends MensajeDecorador {

    private String usuario, password;

    public EncryptMensaje(String usuario, String password, IMensaje mensaje) {
        super(mensaje);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public IMensaje procesarMensaje() {
        this.mensaje = mensaje.procesarMensaje();
        encryptMensaje();
        return mensaje;

    }

    private IMensaje encryptMensaje() {
        try {
            Key key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(mensaje.getContenidoMensaje().getBytes());
            Encoder encoder = Base64.getEncoder();
            //String encode = encoder.encodeToString(data);
            String encryptedValue = encoder.encodeToString(encVal);
            //String encryptedValue = new BASE64Encoder().encode(encVal);
            mensaje.setContenido(encryptedValue);
            return mensaje;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();

        }
    }
}
