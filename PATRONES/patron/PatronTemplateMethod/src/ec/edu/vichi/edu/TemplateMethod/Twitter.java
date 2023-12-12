/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.edu.TemplateMethod;

/**
 *
 * @author jaevi
 */
public class Twitter extends Network{
        public Twitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("Verificando datos del Usuario:");
        System.out.println("Nombre Usuario: " + this.username);

        System.out.println("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatencia();
        System.out.println("\nLogin Satisfactorio en Twitter");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messajePosted = true;
        if (messajePosted) {
            System.out.println("Mensaje: '" + new String(data) + "' fue posteado en twitter");
            return true;
        }
        return false;
    }

    @Override
    void logOut() {
        System.out.println("Usuario: '"+this.username+"' cerro cesion");
    }

    private void simulateNetworkLatencia() {
        try {
            int i = 0;
            System.out.println("");
            while (i < 10) {

                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
