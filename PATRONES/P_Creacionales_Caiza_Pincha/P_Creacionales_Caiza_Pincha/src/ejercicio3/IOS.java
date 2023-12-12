/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class IOS implements ISistema{
     private String version;
    private List<String> aplicaciones;

    public IOS() {
        
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<String> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }
      public void addApplication(final String aplicacion) {
        if(this.aplicaciones == null) {
            this.aplicaciones = new ArrayList<>();
        }
        this.aplicaciones.add(aplicacion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IOS{");
        sb.append("version=").append(version);
        sb.append(", aplicaciones=").append(aplicaciones);
        sb.append('}');
        return sb.toString();
    }
     @Override
    public ISistema clonar(){
        IOS ios = null;

        try {
            ios = (IOS)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.out);
        }

        return ios;
    }
    
}
