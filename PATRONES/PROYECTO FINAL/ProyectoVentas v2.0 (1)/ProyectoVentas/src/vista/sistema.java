/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteDAO;
import modelo.Clientes;
import modelo.Conexion;
import modelo.Productos;
import modelo.ProductosDAO;

/**
 *
 * @author USUARIO
 */
public class sistema extends javax.swing.JFrame {

    /**
     * Creates new form sistema
     */
    DefaultTableModel modelo;
    DefaultTableModel modeloC;
    DefaultTableModel modeloP;
    DefaultTableModel modeloH;
    Clientes cl = new Clientes();

    ClienteDAO client = new ClienteDAO();
    DefaultTableModel modeloLista;
    DefaultTableModel mProducto;
    Productos pro = new Productos();
    ProductosDAO prodao = new ProductosDAO();

    public sistema() {
        initComponents();
        cargarTablaVentas();
        cargarTablaClientes();
        cargarTablaProductos();
        cargarTablaHistorial();
        cargarClientes();
        selecionar();
       // bloquearTexto();
        cargarProductos();
        selecionarProductos();
        //bloquearTextoP();

    }

    public void limpiarTabla() {
        for (int i = 0; i < modeloLista.getRowCount(); i++) {
            modeloLista.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarTablaProductos() {
        for (int i = 0; i < mProducto.getRowCount(); i++) {
            mProducto.removeRow(i);
            i = i - 1;
        }
    }

    public void cargarTablaVentas() {
        String titulo[] = {"CODIGO", "DESCRIPCIÓN", "CANTIDAD", "PRECIO", "TOTAL"};
        modelo = new DefaultTableModel(null, titulo);
        jbtVentas.setModel(modelo);

    }

    public void cargarTablaClientes() {
        String titulo[] = {"ID", "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCIÓN"};
        modeloC = new DefaultTableModel(null, titulo);
        jtblClientes.setModel(modeloC);

    }

    public void cargarTablaProductos() {
        String titulo[] = {"ID", "CODIGO", "DESCRIPCION", "STOCK", "PRECIO"};
        modeloP = new DefaultTableModel(null, titulo);
        jtblProductos.setModel(modeloP);

    }

    public void cargarTablaHistorial() {
        String titulo[] = {"ID", "CLIENTE", "VENDEDOR", "TOTAL"};
        modeloH = new DefaultTableModel(null, titulo);
        jtblHistorial.setModel(modeloH);

    }

    public void RegistrarClientes() {
        ClienteDAO dao = new ClienteDAO();
        if (!"".equals(jtxtCedulaC.getText()) || !"".equals(jtxtNombreC.getText()) || !"".equals(jtxtApellidoC.getText()) || !"".equals(jtxtTelefonoC.getText()) || !"".equals(jtxtDireccionC.getText())) {

            cl.setCedula(jtxtCedulaC.getText());
            cl.setNombre(jtxtNombreC.getText());
            cl.setApellido(jtxtApellidoC.getText());
            cl.setTelefono(jtxtTelefonoC.getText());
            cl.setDireccion(jtxtDireccionC.getText());
            client.RegistrarCliente(cl);
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
            limpiarTabla();
            cargarClientes();

//            LimpiarTable();
            LimpiarCliente();

            JOptionPane.showMessageDialog(null, "Cedula ya existe");

        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }

    }

    public void registrarProductos() {
        if (!"".equals(jtxtCodigoProduc.getText()) || !"".equals(jxtxDescrpProduct.getText()) || !"".equals(jxtxCantProduct.getText()) || !"".equals(jtxtPriceProduct.getText())) {
            pro.setCodigo(jtxtCodigoProduc.getText());
            pro.setNombre(jxtxDescrpProduct.getText());
            pro.setStock(Integer.valueOf(jxtxCantProduct.getText()));
            pro.setPrecio(Double.valueOf(jtxtPriceProduct.getText()));
            prodao.RegistrarProductos(pro);
            JOptionPane.showMessageDialog(null, "Producto Registrado con Exito");
            limpiarTablaProductos();
            cargarProductos();

        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }

    }

    public void cargarClientes() {
        List<Clientes> ListarCl = client.ListarCliente();
        modeloLista = new DefaultTableModel();
        modeloLista = (DefaultTableModel) jtblClientes.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getCedula();
            ob[2] = ListarCl.get(i).getNombre();
            ob[3] = ListarCl.get(i).getApellido();
            ob[4] = ListarCl.get(i).getTelefono();
            ob[5] = ListarCl.get(i).getDireccion();
            modeloLista.addRow(ob);

        }
        jtblClientes.setModel(modeloLista);

    }

    public void cargarProductos() {
        List<Productos> ListarPro = prodao.ListarProductos();
        mProducto = new DefaultTableModel();
        mProducto = (DefaultTableModel) jtblProductos.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCodigo();
            ob[2] = ListarPro.get(i).getNombre();
            ob[3] = ListarPro.get(i).getStock();
            ob[4] = ListarPro.get(i).getPrecio();
            mProducto.addRow(ob);

        }
        jtblProductos.setModel(mProducto);

    }

    public void elimiarCliente() {

        if ("".equals(jtxtIdC.getText())) {

            JOptionPane.showMessageDialog(null, "seleccione una fila");

        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(jtxtIdC.getText());
                client.EliminarCliente(id);
                limpiarTabla();
                cargarClientes();

            }

        }

    }

    public void elimiarProducto() {

        if ("".equals(jtxtIdProducto.getText())) {

            JOptionPane.showMessageDialog(null, "seleccione una fila");

        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(jtxtIdProducto.getText());
                prodao.EliminarProducto(id);
                limpiarTabla();
                cargarClientes();

            }

        }

    }

    public void modificar() {

        int fila = jtblClientes.getSelectedRow();
        if ("".equals(jtxtIdC.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {
            bloquearTexto();
            if (!"".equals(jtxtCedulaC.getText()) || !"".equals(jtxtNombreC.getText()) || !"".equals(jtxtApellidoC.getText()) || !"".equals(jtxtTelefonoC.getText()) || !"".equals(jtxtDireccionC.getText())) {
                cl.setCedula(jtxtCedulaC.getText());
                cl.setNombre(jtxtNombreC.getText());
                cl.setApellido(jtxtApellidoC.getText());
                cl.setTelefono(jtxtTelefonoC.getText());
                cl.setDireccion(jtxtDireccionC.getText());
                cl.setId(Integer.parseInt(jtxtIdC.getText()));
                client.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                //  limpiarTabla();

                limpiarTabla();
                cargarClientes();
                LimpiarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }

    public void modificarProducto() {

        int fila = jtblProductos.getSelectedRow();
        if ("".equals(jtxtIdProducto.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(jtxtCodigoProduc.getText())
                    || !"".equals(jxtxDescrpProduct.getText())
                    || !"".equals(jxtxCantProduct.getText()) ||
                    !"".equals(jtxtPriceProduct.getText())) {
                
                pro.setCodigo(jtxtCodigoProduc.getText());
                pro.setNombre(jxtxDescrpProduct.getText());
                pro.setStock(Integer.valueOf(jxtxCantProduct.getText()));
                pro.setPrecio(Double.valueOf(jtxtPriceProduct.getText()));
                pro.setId(Integer.parseInt(jtxtIdProducto.getText()));
                

                prodao.ModificarProducto(pro);
                limpiarTablaProductos();
                cargarProductos();
                LimpiarProductos();
                JOptionPane.showMessageDialog(null, "Producto modifcado");
                
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }

    public void nuevo() {
        LimpiarCliente();
        HabilitarTexto();

    }
      public void nuevoP() {
        LimpiarProductos();
        HabilitarTextoP();

    }

    public void HabilitarTexto() {
        jtxtCedulaC.setEnabled(true);

    }
     public void HabilitarTextoP() {
        jtxtCodigoProduc.setEnabled(true);

    }

    private void LimpiarCliente() {
        jtxtIdC.setText("");
        jtxtCedulaC.setText("");
        jtxtNombreC.setText("");
        jtxtApellidoC.setText("");
        jtxtTelefonoC.setText("");
        jtxtDireccionC.setText("");
    }

    private void LimpiarProductos() {
        jtxtCodigoProduc.setText("");
        jxtxDescrpProduct.setText("");
        jxtxCantProduct.setText("");
        jtxtPriceProduct.setText("");
        jtxtIdProducto.setText("");

    }

    public void selecionar() {
//           btnEditarCliente.setEnabled(true);
//        btnEliminarCliente.setEnabled(true);
//        btnGuardarCliente.setEnabled(false);
        jtblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (jtblClientes.getSelectedRow() != -1) {
                    bloquearTexto();
                    Integer fila = jtblClientes.getSelectedRow();
                    jtxtIdC.setText(jtblClientes.getValueAt(fila, 0).toString());
                    jtxtCedulaC.setText(jtblClientes.getValueAt(fila, 1).toString());
                    jtxtNombreC.setText(jtblClientes.getValueAt(fila, 2).toString());
                    jtxtApellidoC.setText(jtblClientes.getValueAt(fila, 3).toString());
                    jtxtTelefonoC.setText(jtblClientes.getValueAt(fila, 4).toString());
                    jtxtDireccionC.setText(jtblClientes.getValueAt(fila, 5).toString());

                }
            }
        });
    }

    public void selecionarProductos() {

        jtblProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (jtblProductos.getSelectedRow() != -1) {
bloquearTextoP();
                    Integer fila = jtblProductos.getSelectedRow();
                    jtxtIdProducto.setText(jtblProductos.getValueAt(fila, 0).toString());
                    jtxtCodigoProduc.setText(jtblProductos.getValueAt(fila, 1).toString());
                    jxtxDescrpProduct.setText(jtblProductos.getValueAt(fila, 2).toString());
                    jxtxCantProduct.setText(jtblProductos.getValueAt(fila, 3).toString());
                    jtxtPriceProduct.setText(jtblProductos.getValueAt(fila, 4).toString());

                }
            }
        });
    }

    private void agregarProducto() {
        String barcode = jtxtBARCodigo.getText();

        // Simular obtención de información del producto a partir del código de barras
        String descripcion = obtenerDescripcion(barcode);
        double precio = obtenerPrecio(barcode);
        Integer stock = stock(barcode);

        // Calcular el total del producto
        int cantidad = Integer.valueOf(jtxtCantidad.getText());
        double total = precio * cantidad;
        int nStock = stock - cantidad;

//Update Stock
        try {
            Conexion c = new Conexion();
            Connection cn = c.conectar();
            //--------------------------------------------------------------------------
            String sql = "UPDATE productos SET "
                    + "stock='" + nStock + "'"
                    + "WHERE codigo='" + jtxtBARCodigo.getText() + "'";
            //--------------------------------------------------------------------------
            PreparedStatement spd = cn.prepareStatement(sql);
            spd.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        // Agregar el producto a la tabla de factura
        modelo.addRow(new Object[]{barcode, descripcion, cantidad, precio, total});

        jtxtBARCodigo.setText("");
        jtxtDescripcion.setText("");
        jtxtPrecio.setText("");
        jtxtCantidad.setText("");
        jtxtStock.setText("");

        double i = calcularTotalFactura();
        jlblTotal.setText(String.valueOf(i));

    }

    private double calcularTotalFactura() {
        double total = 0.0;
        for (int row = 0; row < modelo.getRowCount(); row++) {
            double precio = (double) modelo.getValueAt(row, 3);
            int cantidad = (int) modelo.getValueAt(row, 2);
            double subtotal = precio * cantidad;
            total += subtotal;
        }

        return total;
    }

    private double obtenerPrecio(String barcode) {
        // Simulación: obtención del precio del producto a partir del código de barras

        Conexion cc = new Conexion();
        Connection conec = cc.conectar();
        double precio = 0.0;

        try {

            PreparedStatement stmt = conec.prepareStatement("SELECT precio FROM productos WHERE codigo = ?");
            stmt.setString(1, barcode);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble("precio");
                jtxtPrecio.setText(String.valueOf(precio));
            }

            rs.close();
            stmt.close();
            conec.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return precio;

    }

    private String obtenerDescripcion(String barcode) {
        // Simulación: obtención de la descripción del producto a partir del código de barras
        String descripcion = "Descripción desconocida";
        Conexion cc = new Conexion();
        Connection conec = cc.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT nombre FROM productos WHERE codigo = ? ";
            stmt = conec.prepareStatement(query);
            stmt.setString(1, barcode);

            // Ejecutar la consulta
            rs = stmt.executeQuery();

            // Procesar el resultado
            if (rs.next()) {
                descripcion = rs.getString("nombre");
                jtxtDescripcion.setText(descripcion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conec != null) {
                    conec.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return descripcion;
    }

    private Integer stock(String barcode) {
        Conexion cc = new Conexion();
        Connection conec = cc.conectar();
        Integer stock = 0;
        try {

            PreparedStatement stmt = conec.prepareStatement("SELECT stock FROM productos WHERE codigo = ?");
            stmt.setString(1, barcode);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("stock");
                jtxtStock.setText(String.valueOf(stock));
            }

            rs.close();
            stmt.close();
            conec.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stock;
    }

    public String bCliente(String cedula) {
        Conexion cc = new Conexion();
        Connection conec = cc.conectar();
        String nombre;
        String apellido;

        try {
            PreparedStatement stmt = conec.prepareStatement("SELECT * FROM  clientes where cedula=?");
            stmt.setString(1, cedula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cedula = rs.getString("cedula");
                jtxtCedula.setText(cedula);
                nombre = rs.getString("nombre");
                apellido = rs.getString("Apellido");

                jtxtNombre.setText(nombre + " " + apellido);

            }

            rs.close();
            stmt.close();
            conec.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cedula;
    }

    private void cli(String cedula) {
        if (!"".equals(jtxtCedula.getText())) {
            int dni = Integer.parseInt(jtxtCedula.getText());

            if (cl.getNombre() != null) {
                jtxtNombre.setText("" + cl.getNombre());
                jtxtCedula.setText("" + cl.getId());
            } else {
                jtxtCedula.setText("");
                JOptionPane.showMessageDialog(null, "El cliente no existe");
            }
        }
    }

    public void bloquearTexto() {
        jtxtCedulaC.setEnabled(false);
    }
     public void bloquearTextoP() {
        jtxtCodigoProduc.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jbtnNventas = new javax.swing.JButton();
        jbtnClientes = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tabla6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtBARCodigo = new javax.swing.JTextField();
        jtxtDescripcion = new javax.swing.JTextField();
        jtxtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbtVentas = new javax.swing.JTable();
        jtxtPrecio = new javax.swing.JTextField();
        jtxtStock = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jbtnGenerarVenta = new javax.swing.JButton();
        jlblTootal = new javax.swing.JLabel();
        jlblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtxtCedulaC = new javax.swing.JTextField();
        jtxtNombreC = new javax.swing.JTextField();
        jtxtTelefonoC = new javax.swing.JTextField();
        jtxtDireccionC = new javax.swing.JTextField();
        jbtnGuardarV = new javax.swing.JButton();
        jbtnActualizarV = new javax.swing.JButton();
        jbtnEliminarV = new javax.swing.JButton();
        jtbnNuevoV = new javax.swing.JButton();
        jtxtIdC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtApellidoC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jtxtCodigoProduc = new javax.swing.JTextField();
        jxtxDescrpProduct = new javax.swing.JTextField();
        jxtxCantProduct = new javax.swing.JTextField();
        jtxtPriceProduct = new javax.swing.JTextField();
        jbtnGuardarP = new javax.swing.JButton();
        jbtnActualizarP = new javax.swing.JButton();
        jbtnElimarP = new javax.swing.JButton();
        jbtnNuevoP = new javax.swing.JButton();
        jtxtIdProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblHistorial = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jbtnNventas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnNventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Nventa.png"))); // NOI18N
        jbtnNventas.setText("Nueva Venta");
        jbtnNventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNventasActionPerformed(evt);
            }
        });

        jbtnClientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Clientes.png"))); // NOI18N
        jbtnClientes.setText("Clientes");
        jbtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClientesActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        jButton3.setText("Productos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compras.png"))); // NOI18N
        jButton4.setText("Ventas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png"))); // NOI18N
        jButton1.setText("Config");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        jButton5.setText("Reportes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnNventas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jbtnNventas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnClientes)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/encabezado.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 740, 120));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Descripción");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cantidad");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Precio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Stock Disponible");

        jtxtBARCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBARCodigoActionPerformed(evt);
            }
        });
        jtxtBARCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtBARCodigoKeyPressed(evt);
            }
        });

        jtxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripcionActionPerformed(evt);
            }
        });

        jtxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyPressed(evt);
            }
        });

        jbtVentas.setBackground(new java.awt.Color(102, 255, 51));
        jbtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jbtVentas);

        jtxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPrecioActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jButton2.setText("Eliminar");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cedula");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombre");

        jtxtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCedulaKeyTyped(evt);
            }
        });

        jtxtNombre.setEditable(false);

        jbtnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print.png"))); // NOI18N

        jlblTootal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblTootal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/money.png"))); // NOI18N
        jlblTootal.setText("Total a Pagar");

        jlblTotal.setText("-----");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtxtBARCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jbtnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblTootal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtBARCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblTootal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabla6.addTab("tab1", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jPanel7.setBackground(new java.awt.Color(51, 255, 153));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Cedula");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombre");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Telefono");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Direccion");

        jbtnGuardarV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnGuardarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        jbtnGuardarV.setText("Guardar");
        jbtnGuardarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarVActionPerformed(evt);
            }
        });

        jbtnActualizarV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnActualizarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        jbtnActualizarV.setText("Actualizar");
        jbtnActualizarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActualizarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarVActionPerformed(evt);
            }
        });

        jbtnEliminarV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEliminarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jbtnEliminarV.setText("Eliminar");
        jbtnEliminarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEliminarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarVActionPerformed(evt);
            }
        });

        jtbnNuevoV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbnNuevoV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jtbnNuevoV.setText("Nuevo");
        jtbnNuevoV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbnNuevoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnNuevoVActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellido");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtApellidoC)
                            .addComponent(jtxtNombreC)
                            .addComponent(jtxtCedulaC)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbtnEliminarV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtbnNuevoV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbtnGuardarV)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnActualizarV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(jtxtTelefonoC))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(28, 28, 28)
                        .addComponent(jtxtDireccionC))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jtxtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtApellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtxtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jtxtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardarV)
                    .addComponent(jbtnActualizarV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnEliminarV)
                    .addComponent(jtbnNuevoV))
                .addGap(19, 19, 19))
        );

        jtblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblClientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tabla6.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Codigo");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Descripcion");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Cantidad");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Precio");

        jbtnGuardarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnGuardarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        jbtnGuardarP.setText("Guardar");
        jbtnGuardarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarPActionPerformed(evt);
            }
        });

        jbtnActualizarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnActualizarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        jbtnActualizarP.setText("Actualizar");
        jbtnActualizarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarPActionPerformed(evt);
            }
        });

        jbtnElimarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnElimarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jbtnElimarP.setText("Eliminar");
        jbtnElimarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnElimarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnElimarPActionPerformed(evt);
            }
        });

        jbtnNuevoP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnNuevoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbtnNuevoP.setText("Nuevo");
        jbtnNuevoP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jbtnElimarP)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnNuevoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jbtnGuardarP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnActualizarP)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtIdProducto, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(25, 25, 25)
                                .addComponent(jtxtPriceProduct))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jxtxCantProduct)
                                    .addComponent(jxtxDescrpProduct)
                                    .addComponent(jtxtCodigoProduc))))
                        .addGap(23, 23, 23))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCodigoProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxtxDescrpProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jxtxCantProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jtxtPriceProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jtxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardarP)
                    .addComponent(jbtnActualizarP))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnElimarP)
                    .addComponent(jbtnNuevoP))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jtblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblProductosMouseClicked(evt);
            }
        });
        jtblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblProductosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtblProductos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla6.addTab("tab3", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        jtblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jtblHistorial);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        tabla6.addTab("tab4", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        tabla6.addTab("tab5", jPanel6);

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));

        jLabel21.setBackground(new java.awt.Color(0, 153, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setText("Contactese con el Administrador !!!");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        tabla6.addTab("tab6", jPanel9);

        getContentPane().add(tabla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 740, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPrecioActionPerformed

    private void jtxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDescripcionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tabla6.setSelectedIndex(5);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnGuardarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarVActionPerformed
        // TODO add your handling code here:
        RegistrarClientes();

    }//GEN-LAST:event_jbtnGuardarVActionPerformed

    private void jbtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClientesActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        cargarClientes();
        tabla6.setSelectedIndex(1);
    }//GEN-LAST:event_jbtnClientesActionPerformed

    private void jtblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblClientesMouseClicked
        // TODO add your handling code here:
        // limpiarTabla();
        selecionar();

    }//GEN-LAST:event_jtblClientesMouseClicked

    private void jbtnEliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarVActionPerformed
        // TODO add your handling code here:

        elimiarCliente();
        limpiarTabla();
        LimpiarCliente();
        cargarClientes();


    }//GEN-LAST:event_jbtnEliminarVActionPerformed

    private void jbtnActualizarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarVActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_jbtnActualizarVActionPerformed

    private void jtbnNuevoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnNuevoVActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_jtbnNuevoVActionPerformed

    private void jbtnNventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNventasActionPerformed
        // TODO add your handling code here:
        tabla6.setSelectedIndex(0);
    }//GEN-LAST:event_jbtnNventasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tabla6.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tabla6.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tabla6.setSelectedIndex(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jtxtBARCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBARCodigoKeyPressed
        // TODO add your handling code here:
        String barcode = jtxtBARCodigo.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JOptionPane.showMessageDialog(this, "Su codigo de barra es " + barcode);
            agregarProducto();

        }


    }//GEN-LAST:event_jtxtBARCodigoKeyPressed

    private void jtxtBARCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBARCodigoActionPerformed
        // TODO add your handling code here:
        //agregarProducto();
    }//GEN-LAST:event_jtxtBARCodigoActionPerformed

    private void jtxtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyPressed
        // TODO add your handling code here:
        
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
agregarProducto();
        }

    }//GEN-LAST:event_jtxtCantidadKeyPressed

    private void jtxtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCedulaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

        }

    }//GEN-LAST:event_jtxtCedulaKeyPressed

    private void jtxtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCedulaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jtxtCedulaKeyTyped

    private void jbtnGuardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarPActionPerformed
        // TODO add your handling code here:
        registrarProductos();
    }//GEN-LAST:event_jbtnGuardarPActionPerformed

    private void jtblProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblProductosKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtblProductosKeyPressed

    private void jtblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductosMouseClicked
        // TODO add your handling code here:
        selecionarProductos();
    }//GEN-LAST:event_jtblProductosMouseClicked

    private void jbtnElimarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnElimarPActionPerformed
        // TODO add your handling code here:
        elimiarProducto();
        limpiarTablaProductos();
        LimpiarProductos();
        cargarProductos();

    }//GEN-LAST:event_jbtnElimarPActionPerformed

    private void jbtnActualizarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarPActionPerformed
        // TODO add your handling code here:
        modificarProducto();
    }//GEN-LAST:event_jbtnActualizarPActionPerformed

    private void jbtnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoPActionPerformed
        // TODO add your handling code here:
        nuevoP();
    }//GEN-LAST:event_jbtnNuevoPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jbtVentas;
    private javax.swing.JButton jbtnActualizarP;
    private javax.swing.JButton jbtnActualizarV;
    private javax.swing.JButton jbtnClientes;
    private javax.swing.JButton jbtnElimarP;
    private javax.swing.JButton jbtnEliminarV;
    private javax.swing.JButton jbtnGenerarVenta;
    private javax.swing.JButton jbtnGuardarP;
    private javax.swing.JButton jbtnGuardarV;
    private javax.swing.JButton jbtnNuevoP;
    private javax.swing.JButton jbtnNventas;
    private javax.swing.JLabel jlblTootal;
    private javax.swing.JLabel jlblTotal;
    private javax.swing.JTable jtblClientes;
    private javax.swing.JTable jtblHistorial;
    private javax.swing.JTable jtblProductos;
    private javax.swing.JButton jtbnNuevoV;
    private javax.swing.JTextField jtxtApellidoC;
    private javax.swing.JTextField jtxtBARCodigo;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCedulaC;
    private javax.swing.JTextField jtxtCodigoProduc;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtDireccionC;
    private javax.swing.JTextField jtxtIdC;
    private javax.swing.JTextField jtxtIdProducto;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNombreC;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtPriceProduct;
    private javax.swing.JTextField jtxtStock;
    private javax.swing.JTextField jtxtTelefonoC;
    private javax.swing.JTextField jxtxCantProduct;
    private javax.swing.JTextField jxtxDescrpProduct;
    private javax.swing.JTabbedPane tabla6;
    // End of variables declaration//GEN-END:variables
}
