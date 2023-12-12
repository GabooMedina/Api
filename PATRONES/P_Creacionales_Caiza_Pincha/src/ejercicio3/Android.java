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
public class Android  implements ISistema{

    private String version;
    private String name;
    private List<String> aplicaciones;

    public Android() {

    }

    public Android(String version, String name) {
        this.version = version;
        this.name = name;

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<String> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public void addApplication(String aplicacion) {
        if (this.aplicaciones == null) {
            this.aplicaciones = new ArrayList<>();
        }
        this.aplicaciones.add(aplicacion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Andriod{");
        sb.append("version=").append(version);
        sb.append(", name=").append(name);
        sb.append(", aplicaciones=").append(aplicaciones);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public ISistema clonar() {
        Android android = null;

        try {
            android = (Android) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.out);
        }

        return  android;
    }

}
