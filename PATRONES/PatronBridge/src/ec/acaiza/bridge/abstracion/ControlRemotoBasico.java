package ec.acaiza.bridge.abstracion;

import ec.acaiza.bridge.implementacion.IDispositivo;

public class ControlRemotoBasico implements IControlRemoto {

    protected IDispositivo dispositivo;

    public ControlRemotoBasico(IDispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void encender() {
        System.out.println("Remoto:Botón de encender");
        if (dispositivo.estHabilitado() == true) {
            dispositivo.inhabilitado();

        } else {
            dispositivo.habilitar();

        }
    }

    @Override
    public void bajarVolumen() {
        System.out.println("Remoto: Presionando bajar volumen");
        dispositivo.setVolumen(dispositivo.getVolumen() -10);
    }

    @Override
    public void subirVolumen() {
        System.out.println("Remoto: Presionando subir volumen");
        dispositivo.setVolumen(dispositivo.getVolumen() +10);
    }

    @Override
    public void subirCanal() {
     System.out.println("Remoto: Presionando subir Canal");
     dispositivo.setCanal(dispositivo.getCanal()+1);

    }

    @Override
    public void bajarCanal() {
          System.out.println("Remoto: Presionando bajar Canal");
     dispositivo.setCanal(dispositivo.getCanal()-1);
    }

}
