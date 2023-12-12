/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

/**
 *
 * @author Vichicela Kevin
 * @author Caiza Angel
 * @author Pincha Diego
 *
 */
public class CompositeMain {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("Angel Caiza");

        ProductoPeso pollo = new ProductoPeso("Pollo", "Carne", 3, 3.25);
        ProductoPeso agua = new ProductoPeso("Agua Manantial", "Bebida", 1, 2);

        ProductoUnitario pan = new ProductoUnitario("Pan con Relleno", "Comida", 10, 0.25);
        ProductoUnitario cepillo = new ProductoUnitario("Cepillos Colgate", "Limpieza", 3, 1);

        ProductoCompuesto cesta = new ProductoCompuesto();

        cesta.addProducto(pan);
        cesta.addProducto(cepillo);

        pedido.addProducto(pollo);
        pedido.addProducto(agua);

        System.out.println(pedido.getCliente());
        System.out.println(cesta.getProductos().toString());
        System.out.println("Total: " + pedido.getImporteTotal());
        pedido.addProducto(cesta);
        System.out.println("Total: " + pedido.getImporteTotal());

    }
}
