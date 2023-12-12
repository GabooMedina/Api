/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class MainPrototype {

    public static void main(String[] args) {
        Productos p1 = new Productos("Coca Cola", 0.50);
        Productos p2 = new Productos("Chocolate", 2.0);
        Productos p3 = new Productos("Pizza", 6.50);
        Productos p4 = new Productos("Pasta", 1.50);
        //Original
        ListaProductos original = new ListaProductos();

        original.guardarPorducto(p1);
        original.guardarPorducto(p2);
        original.guardarPorducto(p3);
        original.guardarPorducto(p4);

        ArrayList<Productos> productos = original.getProducto();
        ListaProductos mayoreo = (ListaProductos) original.clonar();
        //Mayoreo
        ArrayList<Productos> productosMayoreo = mayoreo.getProducto();
        for (int i = 0; i < productosMayoreo.size(); i++) {
            Productos p = productosMayoreo.get(i);

            p.setPrecio(p.getPrecio() - (p.getPrecio() * 0.10));
        }
        //VIP
        ListaProductos vip = (ListaProductos) mayoreo.clonar();
        ArrayList<Productos> productosVIP = vip.getProducto();
        for (int i = 0; i < productosVIP.size(); i++) {
            Productos p = productosVIP.get(i);

            p.setPrecio(p.getPrecio() - (p.getPrecio() * 0.10));
        }

        System.out.println("***ESTANDATR O ORIGINAL***");

        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);

            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println("***LISTA MAYOREO***");

        for (int i = 0; i < productosMayoreo.size(); i++) {
            Productos p = productosMayoreo.get(i);

            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println("***LISTA VIP***");

        for (int i = 0; i < productosVIP.size(); i++) {
            Productos p = productosVIP.get(i);

            System.out.println(p.toString());
        }
    }

}
