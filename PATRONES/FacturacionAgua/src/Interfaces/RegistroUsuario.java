/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import PersonaDao.User;
import PersonaDao.UserDAO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PERSONAL
 */
public class RegistroUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistroUsuario
     */
    DefaultTableModel modelo;

    public RegistroUsuario() {
        initComponents();
        cargarTablaUsuarios();
        cargarDatos();
        bloquearBotones();
        bloquearText();
        //jbtnSalir.setEnabled(true);

    }

    public void borrarText() {
        jtxtCedula.setText("");
        jtxtNombre.setText("");
        jtxtApellidos.setText("");

        jtxtTelefono.setText("");

    }

    public void bloquearText() {
        jtxtCedula.setEnabled(false);
        jtxtNombre.setEnabled(false);
        jtxtApellidos.setEnabled(false);

        jtxtTelefono.setEnabled(false);

    }

    public void desblobloquearText() {
        jtxtCedula.setEnabled(true);
        jtxtNombre.setEnabled(true);
        jtxtApellidos.setEnabled(true);

        jtxtTelefono.setEnabled(true);

    }

    public void desblobloquearTextEditar() {
        jtxtCedula.setEnabled(false);
        jtxtNombre.setEnabled(true);
        jtxtApellidos.setEnabled(true);

        jtxtTelefono.setEnabled(true);

    }

    public void bloquearBotones() {
        jbtnNuevo.setEnabled(true);
        jbtnEditar.setEnabled(false);
        jbtnGuardar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jbtnSalir.setEnabled(false);
    }

    public void desbloquearBotones() {
        jbtnNuevo.setEnabled(true);
        jbtnEditar.setEnabled(true);
        jbtnGuardar.setEnabled(true);
        jbtnEliminar.setEnabled(true);
        jbtnSalir.setEnabled(true);
    }

    public boolean validar(String cedula) {
        boolean validar = false;
        //0504686411 = 054686411
        int aux, dece_superior, acum = 0, primeros_dos, tercer_numero;
        try {
            primeros_dos = Integer.parseInt(cedula.substring(0, 2));
            tercer_numero = Integer.parseInt(cedula.substring(2, 3));
            if (primeros_dos > 0 && primeros_dos <= 24 && cedula.length() == 10) {
                if (tercer_numero < 6 && tercer_numero >= 0) {
                    for (int i = 0; i < cedula.length() - 1; i++) {
                        aux = Integer.parseInt(cedula.charAt(i) + "");
                        // que sea par
                        if (i % 2 == 0) {
                            aux *= 2;
                        }
                        if (aux >= 10) {
                            aux -= 9;
                        }
                        acum += aux;
                    }
                    dece_superior = ((acum / 10) + 1) * 10;
                    acum = dece_superior - acum;
                    if (acum == Integer.parseInt(cedula.charAt(9) + "")) {
                        validar = true;
                    }
                }
            }
        } catch (NumberFormatException e) {
        }
        return validar;
    }

    public void cargarDatos() {
        jtblUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblUsuarios.getSelectedRow() != -1) {

                    int fila = jtblUsuarios.getSelectedRow();
                    jtxtCedula.setText(jtblUsuarios.getValueAt(fila, 0).toString());
                    jtxtNombre.setText(jtblUsuarios.getValueAt(fila, 1).toString());
                    jtxtApellidos.setText(jtblUsuarios.getValueAt(fila, 2).toString());

                    jtxtTelefono.setText(jtblUsuarios.getValueAt(fila, 3).toString());

                    desblobloquearTextEditar();
                    jbtnEditar.setEnabled(true);
                    jbtnEliminar.setEnabled(true);
                    jbtnGuardar.setEnabled(false);

                    jtxtCedula.setBorder(new LineBorder(Color.black, 1));
                    jtxtNombre.setBorder(new LineBorder(Color.black, 1));
                    jtxtApellidos.setBorder(new LineBorder(Color.black, 1));

                    jtxtTelefono.setBorder(new LineBorder(Color.black, 1));
                }
            }
        });
    }

//    public void modificar() {
//        if (jtxtNombre.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el nombre", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtNombre.requestFocus();
//            jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtNombre.getText().length() <= 2) {
//            JOptionPane.showMessageDialog(this, "Ingrese un nombre válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtNombre.requestFocus();
//            jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtApellidos.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el apellido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtApellidos.requestFocus();
//            jtxtApellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtApellidos.getText().length() <= 2) {
//            JOptionPane.showMessageDialog(this, "Ingrese un apellido válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtApellidos.requestFocus();
//            jtxtApellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//
//        } else if (jtxtTelefono.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el teléfono", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtTelefono.requestFocus();
//            jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtTelefono.getText().length() <= 9) {
//            JOptionPane.showMessageDialog(this, "Ingrese un teléfono válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtTelefono.requestFocus();
//            jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else {
//            try {
//                conexion cc = new conexion();
//                Connection cn = cc.conectar();
//                String sql = "update estudiantes set est_nombre='" + jtxtNombre.getText() + "',est_apellido='" + jtxtApellidos.getText() + "',est_telefono='" + jtxtTelefono.getText() + "' where est_cedula='" + jtxtCedula.getText() + "'";
//                PreparedStatement psd = cn.prepareStatement(sql);
//
//                int a = psd.executeUpdate();
//                if (a > 0) {
//                    JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
//                    cargarTablaUsuarios();
//                    borrarText();
//                    bloquearText();
//                    jbtnEditar.setEnabled(false);
//                    jbtnEliminar.setEnabled(false);
//                    jbtnGuardar.setEnabled(false);
//                    jbtnNuevo.setEnabled(true);
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public void cargarTablaUsuarios() {
        String[] registros = new String[5];
        try {
            String titulos[] = {"CEDULA", "NOMBRES", "APELLIDOS", "TELEFONO"};
            modelo = new DefaultTableModel(null, titulos);
            UserDAO claseConMetodo = new UserDAO();
            List<User> users = claseConMetodo.getAllUsers();

            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Teléfono");
            for (User user : users) {
                Object[] row = new Object[4];
                row[0] = user.getCedula();
                row[1] = user.getNombre();
                row[2] = user.getApellido();
                row[3] = user.getTelefono();
                modelo.addRow(row);
            }

            jtblUsuarios.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

//    public void eliminar() {
//        try {
//            conexion cc = new conexion();
//            Connection cn = cc.conectar();
//
//            int resp = JOptionPane.showConfirmDialog(this, "Estás seguro de eliminar?", "AVISO",
//                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (resp == JOptionPane.YES_OPTION) {
//                String sql = "update estudiantes set est_estado='I' where est_cedula='" + jtxtCedula.getText() + "'";
//                PreparedStatement psd = cn.prepareStatement(sql);
//
//                int a = psd.executeUpdate();
//                if (a > 0) {
//
//                    cargarTablaUsuarios();
//                    borrarText();
//                    bloquearText();
//                    bloquearBotones();
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void guardar() {
//        if (jtxtCedula.getText().isEmpty()) {
//
//            JOptionPane.showMessageDialog(this, "Ingrese la cédula", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtCedula.requestFocus();
//            jtxtCedula.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (validar(jtxtCedula.getText()) == false) {
//            JOptionPane.showMessageDialog(this, "Ingrese una cédula válida", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtCedula.requestFocus();
//            jtxtCedula.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//            jtxtCedula.setText("");
//        } else if (jtxtNombre.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el nombre", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtNombre.requestFocus();
//            jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtNombre.getText().length() <= 2) {
//            JOptionPane.showMessageDialog(this, "Ingrese un nombre válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtNombre.requestFocus();
//            jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtApellidos.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el apellido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtApellidos.requestFocus();
//            jtxtApellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtApellidos.getText().length() <= 2) {
//            JOptionPane.showMessageDialog(this, "Ingrese un apellido válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtApellidos.requestFocus();
//            jtxtApellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtTelefono.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Ingrese el teléfono", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtTelefono.requestFocus();
//            jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else if (jtxtTelefono.getText().length() <= 9) {
//            JOptionPane.showMessageDialog(this, "Ingrese un teléfono válido", "MENSAJE", JOptionPane.ERROR_MESSAGE);
//            jtxtTelefono.requestFocus();
//            jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
//        } else {
//
//            try {
//                // TODO add your handling code here:
//                conexion cc = new conexion();
//                Connection cn = cc.conectar();
//                String sql = "INSERT INTO USUARIOS(CED_USU,NOM_USU,APE_USU,TEL_USU,ESTADO) values(?,?,?,?,?)";
//                PreparedStatement psd = cn.prepareStatement(sql);
//                psd.setString(1, jtxtCedula.getText());
//                psd.setString(2, jtxtNombre.getText());
//                psd.setString(3, jtxtApellidos.getText());
//                psd.setString(4, jtxtTelefono.getText());
//                psd.setString(5, "A");
//                int n = psd.executeUpdate();
//                if (n > 0) {
//                    JOptionPane.showMessageDialog(null, "Ingreso exitoso");
//                    cargarTablaUsuarios();
//                    borrarText();
//                    bloquearText();
//                    bloquearBotones();
//                }
//
//            } catch (MySQLIntegrityConstraintViolationException e) {
//                JOptionPane.showMessageDialog(null, "Cédula Existente");
//                jtxtCedula.requestFocus();
//                jtxtCedula.setText("");
//
//            } catch (SQLException e) {
//                System.err.println(e.toString());
//
//            }
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jpnlTextos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellidos = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblUsuarios = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jpnlTextos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Telefono:");

        javax.swing.GroupLayout jpnlTextosLayout = new javax.swing.GroupLayout(jpnlTextos);
        jpnlTextos.setLayout(jpnlTextosLayout);
        jpnlTextosLayout.setHorizontalGroup(
            jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTextosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlTextosLayout.createSequentialGroup()
                        .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlTextosLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtTelefono))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlTextosLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jpnlTextosLayout.setVerticalGroup(
            jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTextosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnEditar.setText("Modificar");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnEliminar.setText("Eliminar");

        jbtnSalir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jbtnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jbtnSalir)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSalir)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jtblUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtblUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jtblUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnlPrincipalLayout = new javax.swing.GroupLayout(jpnlPrincipal);
        jpnlPrincipal.setLayout(jpnlPrincipalLayout);
        jpnlPrincipalLayout.setHorizontalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addComponent(jpnlTextos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnlPrincipalLayout.setVerticalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlPrincipalLayout.createSequentialGroup()
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnlTextos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
//        guardar();
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        // TODO add your handling code here:
//        desblobloquearText();
//        borrarText();
//        jbtnGuardar.setEnabled(true);
//        jbtnEditar.setEnabled(false);
//        jbtnEliminar.setEnabled(false);
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlTextos;
    private javax.swing.JTable jtblUsuarios;
    private javax.swing.JTextField jtxtApellidos;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables
}
