/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.acaiza.Factory;

import edu.acaiza.Factory.dao.ProductDAO;
import edu.acaiza.Factory.entity.Product;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class FactoryMain {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO(DBType.SQLite);

        //-----LISTAR O SELECIONAR  PRODUCTOS------------------------------
             System.out.println("---------------LISTA DE PRODUCTOS------------------------");
        List<Product> products = productDAO.findAllProducts();
        System.out.println("Lista de Productos");
        for (Product product : products) {
            System.out.println(product);
        }
//        System.out.println("Product size = " + products.size());
//        System.out.println("LISTA DE PROCUTOS");
        System.out.println("---------------INSERTAR------------------------");
        //-------------INSERTAR  PRODUCTOS------------------------------
        //Guardar nuevos productos
//        Product productA = new Product(1, "Cuaderno", 1.20);
//        Product productB = new Product(2, "Regla", 0.80);
//        Product productC = new Product(3, "chicle", 0.80);
//        Product productD = new Product(4, "cataboom", 0.80);
//
//        productDAO.saveProduct(productA);
//        productDAO.saveProduct(productB);
//        productDAO.saveProduct(productC);
//        productDAO.saveProduct(productD);
        System.out.println("SE INSERTO");

        //Lista de Productos
        System.out.println("Lista de Productos");
        for (Product product : products) {
            System.out.println(product); 
        
               }
        

//        
//        //-------------ACTUALIZAR O MODIFICAR PRODUCTOS-------------------------
    /* System.out.println("---------------MODIFICO------------------------");
        Product productUpdate = new Product();
        productUpdate.setIdProduct(1);
        productUpdate.setProductName("Esfero");
        productUpdate.setPrice(0.75);
        productDAO.actualizar(productUpdate);
        System.out.println("productos modificados");
        products = productDAO.findAllProducts();

        System.out.println("Lista de Productos");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("SE ACTUALIZO");

        //System.out.println("Product size = " + products.size());
        
        System.out.println("----------------------------------------");
*/
//
//        //-------------ELIMINAR  PRODUCTOS-------------------------
//     System.out.println("---------------ELIMINO------------------------");
//        Product elimnarProduct = new Product(1);
//        productDAO.eliminar(elimnarProduct);
//        System.out.println("SE HA EMILINADO");
//        System.out.println("productos modificados");
//        products = productDAO.findAllProducts();
//        System.out.println("Lista de Productos");
//        
//        for (Product product : products) {
//            System.out.println(product);
//        }

         
//         System.out.println("SE elimino");
//        System.out.println("----------------------------------------");

    }
}
