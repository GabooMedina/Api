
package ec.acaiza.bridge.implementacion;

/**
 *
 * @author USUARIO
 */
public class Radio  implements IDispositivo{
    private boolean encendido = false;
    private int volumen =30;
    private int canal=1;

    @Override
    public boolean estHabilitado() {
        return encendido;
        
    }

    @Override
    public void habilitar() {
        encendido =true;
        
    }

    @Override
    public void inhabilitado() {
        encendido =false;
    }

    @Override
    public int getVolumen() {
           return volumen;

    }
 
    @Override
    public void setVolumen(int porcentaje) {
        if(porcentaje>200){
            this.volumen=200;
        }else if(porcentaje<0){
            this.volumen=0;
    }else {
    this.volumen=porcentaje;
}
    
}

    @Override
    public int getCanal() {
        return this.canal;
    }

    @Override
    public void setCanal(int canal) {
        this.canal=canal;
    }

    @Override
    public void imprimirEstado() {
        System.out.println("-----------------------");
        System.out.println("Ya soy un radio");
        System.out.println("yo estoy "+(encendido ? "habilitado" :"inhabilitado"));
        System.out.println("el canal actual es :"+this.canal + ",");
        System.out.println("el volumen ectual es :" +this.volumen);
    }
    
}
