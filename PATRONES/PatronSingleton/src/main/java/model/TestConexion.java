/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Estudiante
 */
public class TestConexion {

    public static void main(String[] args) {
        //Conexion c = new Conexion();
        Conexion cn = Conexion.getInstancia();
        cn.conectar();
        cn.desconectar();

        boolean rpta = cn instanceof Conexion;
        System.out.println(rpta);

//        Conexion c = Conexion.getInstancia();
//        c.conectar();
//        c.desconectar();
    }

}
