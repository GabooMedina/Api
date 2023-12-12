/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Estudiante
 */
public class Conexion {

    //Declaracion
    private static Conexion instancia;

    private Conexion() {

    }
    
   public static Conexion getInstancia(){
       if(instancia==null){
           instancia=new Conexion();
       }
       return instancia;
   }
   
   //Mestodo de prueba
   public void conectar(){
       System.out.println("Me conecte a la base de datos");
   }
   public void desconectar(){
       System.out.println("Me desconecte de la base de datos");
   }

    
}
