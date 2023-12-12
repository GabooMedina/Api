package ec.acaiza.proxy.services;

public class SecuirityService {

    public boolean authorization(String user, String password) {

        if (user.equals("acaiza") && password.equals("1234")) {
            System.out.println("Usuario:" + user + " Autorizado");
            return true;
        } else {
            System.out.println("Usuario . " + user + "No autorizado");
            return false;
        }

    }

}
