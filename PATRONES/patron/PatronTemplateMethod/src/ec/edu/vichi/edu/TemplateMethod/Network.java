/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.edu.TemplateMethod;

/**
 *
 * @author jaevi
 */
public abstract class Network {

    String username;
    String password;

    //metodo plantilla
    public boolean post(String mensaje) {
        if (logIn(this.username, this.password)) {
            boolean result = sendData(mensaje.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String username, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}
