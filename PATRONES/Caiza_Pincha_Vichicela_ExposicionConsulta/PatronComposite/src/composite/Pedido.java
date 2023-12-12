
package composite;


public class Pedido extends ProductoCompuesto{
    private String cliente;
    public Pedido(String cliente) {
        this.cliente = cliente;
    }
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public void establecerCantidad(IPrecio producto, int cantidad) {
        if (producto instanceof ProductoUnitario) {
            ((ProductoUnitario) super.getProductos().get(super.getProductos().indexOf(producto))).setCantidad(cantidad);
        }
    }
    public void establecerPeso(IPrecio producto, double peso) {
        if (producto instanceof ProductoPeso) {
            ((ProductoPeso) super.getProductos().get(super.getProductos().indexOf(producto))).setPeso(peso);
        }
    }
    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + '}';
    }
    

}
