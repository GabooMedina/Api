
package edu.acaiza.builder.domain;

/**
 *
 * @author USUARIO
 */
public interface IMotor  {

    void setPotencia(int potencia);
    void setCilindraje(int cilindraje);
    String getDefinicionMotor();
    String consumirCombutible();
    String inyectarCombustible(int cantidad);

}
