/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import PersonaDao.User;
import PersonaDao.UserDAO;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author PERSONAL
 */
public class IngresoLectura extends javax.swing.JInternalFrame {

    /**
     * Creates new form IngresoLectura
     */
    DefaultTableModel modelo;
    ArrayList mListaUsuarios;

    String cedula = "";
    private Connection connection;

    public IngresoLectura() {
        initComponents();
        //cargarTablaLecturas();
        connection = PatronSingleton.conexion.getInstance().getConnection();
        mListaUsuarios = new ArrayList();
        llenarCBMaterias();

        //System.out.println(jcbxTipo.getSelectedItem().toString());
        jcbxTipo.addItem("CONSUMO");
        jcbxTipo.addItem("RIEGO");

        jcbxBuscar.addItem("CONSUMO");
        jcbxBuscar.addItem("RIEGO");

        jtxtLecActual.setEnabled(false);
        jtxtLecAnterior.setEnabled(false);
        jbtnEditar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jtxtCedula.setEnabled(false);
        cargarDatos();

        JTableHeader thead = jtblLecturas.getTableHeader();
        thead.setBackground(Color.red);
        thead.setForeground(Color.WHITE);
        thead.setFont(new Font("Tahome", Font.BOLD, 19));
        ((DefaultTableCellRenderer) thead.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    public void cargarDatos() {
        jtblLecturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblLecturas.getSelectedRow() != -1) {

                    int fila = jtblLecturas.getSelectedRow();
                    jtxtCedula.setText(jtblLecturas.getValueAt(fila, 0).toString());
                    jtxtLecAnterior.setText(jtblLecturas.getValueAt(fila, 3).toString());
                    jtxtLecActual.setText(jtblLecturas.getValueAt(fila, 4).toString());

                    jtxtLecActual.setBorder(new LineBorder(Color.black, 1));
                    jtxtLecAnterior.setBorder(new LineBorder(Color.black, 1));

                    jtxtLecActual.setEnabled(true);
                    jtxtLecAnterior.setEnabled(true);
                    jbtnEditar.setEnabled(true);
                    jbtnEliminar.setEnabled(true);
                }
            }
        });
    }

    public void modificar(String anio, String tipo) {
        try {

            String estado = "";
            String sqlRiego = "SELECT F.EST_FACT\n"
                    + "FROM FACTURAS F, LECTURAS L, USUARIOS U\n"
                    + "WHERE F.ID_LEC_PER = L.ID_LEC\n"
                    + "AND L.TIPO_LEC='" + tipo + "'\n"
                    + "AND L.MES_CON='" + anio + "'\n"
                    + "AND L.CED_USU_PER = U.CED_USU\n"
                    + "AND U.CED_USU='" + jtxtCedula.getText() + "'";

            Statement psdRiego = connection.createStatement();
            ResultSet rs = psdRiego.executeQuery(sqlRiego);
            while (rs.next()) {
                estado = rs.getString("EST_FACT");

            }
            if (estado.equals("PENDIENTE")) {
                if (jtxtLecActual.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese Lec. Actual", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                    jtxtLecActual.requestFocus();
                    jtxtLecActual.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));

                } else if (jtxtLecAnterior.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese Lec. Anterior", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                    jtxtLecAnterior.requestFocus();
                    jtxtLecAnterior.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
                } else if (Integer.valueOf(jtxtLecAnterior.getText()) == 0) {
                    JOptionPane.showMessageDialog(this, "Error Lec. Anterior", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.valueOf(jtxtLecActual.getText()) < Integer.valueOf(jtxtLecAnterior.getText())) {
                    JOptionPane.showMessageDialog(this, "Lec. Actual es menor", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {

                        String sql = "update lecturas set LEC_ANT='" + jtxtLecAnterior.getText() + "', LEC_ACT='" + jtxtLecActual.getText() + "' where CED_USU_PER='" + jtxtCedula.getText() + "' AND MES_CON='" + anio + "'";
                        PreparedStatement psd = connection.prepareStatement(sql);

                        int a = psd.executeUpdate();
                        if (a > 0) {
                            JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
                            cargarTablaLecturas(jcbxTipo.getSelectedItem().toString(), anio);
                            jtxtLecActual.setText("");
                            jtxtLecAnterior.setText("");
                            jtxtCedula.setText("");
                            jbtnEditar.setEnabled(false);
                            jbtnEliminar.setEnabled(false);
                            jtxtLecActual.setEnabled(false);
                            jtxtLecAnterior.setEnabled(false);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lectura con Factura Cerrada");
                jtxtLecActual.setText("");
                jtxtLecAnterior.setText("");
                jtxtCedula.setText("");
                jbtnEditar.setEnabled(false);
                jbtnEliminar.setEnabled(false);
                jtxtLecActual.setEnabled(false);
                jtxtLecAnterior.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTablaLecturas(String lectura, String mes) {
        String[] registros = new String[7];
        try {
            String titulos[] = {"CEDULA", "NOMBRES", "APELLIDOS", "LEC. ANTERIOR", "LEC. ACTUAL", "TIPO LECTURA", "MES"};
            modelo = new DefaultTableModel(null, titulos);
            //jtblEstudiantes.setModel(modelo);

            String sql = "SELECT U.*, L.* FROM USUARIOS U, LECTURAS L WHERE U.CED_USU = L.CED_USU_PER AND TIPO_LEC='" + lectura + "' AND MES_CON='" + mes + "' ORDER BY APE_USU ASC";
            Statement psd = connection.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CED_USU");
                registros[1] = rs.getString("NOM_USU");
                registros[2] = rs.getString("APE_USU");
                registros[3] = rs.getString("LEC_ANT");
                registros[4] = rs.getString("LEC_ACT");
                registros[5] = rs.getString("TIPO_LEC");
                registros[6] = rs.getString("MES_CON");

                modelo.addRow(registros);

            }

            jtblLecturas.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbtnEditar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtLecAnterior = new javax.swing.JTextField();
        jtxtLecActual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jbtnCargar = new javax.swing.JButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcbxBuscar = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jcbxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jMes = new com.toedter.calendar.JMonthChooser();
        jAño = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        jcbxDatos = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jlblLecturaAnterior = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtLecturaActual = new javax.swing.JTextField();
        jbtnINgreso = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jAñoA = new com.toedter.calendar.JYearChooser();
        jMesA = new com.toedter.calendar.JMonthChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLecturas = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setTitle("Ventana de Lecturas");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones Ingreso de Lecturas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Lectura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jbtnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jbtnEditar.setText("EDITAR");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jbtnEliminar.setText("ELIMINAR");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 107, 135));
        jLabel7.setText("LEC. ANTERIOR :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 107, 135));
        jLabel8.setText("LEC. ACTUAL     :");

        jtxtLecAnterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtxtLecActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(23, 107, 135));
        jLabel10.setText("BUSCAR POR NOMBRE:");

        jtxtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(23, 107, 135));
        jLabel11.setText("CEDULA            :");

        jtxtCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(23, 107, 135));
        jLabel12.setText("BUSCAR POR CEDULA  :");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbtnCargar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnCargar.setText("CARGAR DATOS");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(23, 107, 135));
        jLabel13.setText("FECHA:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(23, 107, 135));
        jLabel14.setText("TIPO DE LECTURA:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(73, 73, 73))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnCargar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnEliminar)
                                    .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtxtLecActual, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtLecAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator4)
            .addComponent(jSeparator1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jcbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jbtnEditar))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtLecAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtLecActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEliminar))
                .addGap(50, 50, 50))
        );

        jcbxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxTipoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jcbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 107, 135));
        jLabel4.setText("SELECCIONAR TIPO DE LECTURA:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 107, 135));
        jLabel5.setText("SELECCIONAR EL MES ANTERIOR:");

        jMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMes, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(jAño, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 107, 135));
        jLabel1.setText("SELECCIONE USUARIO:");

        jcbxDatos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbxDatos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxDatosItemStateChanged(evt);
            }
        });
        jcbxDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxDatosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcbxDatosMousePressed(evt);
            }
        });
        jcbxDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxDatosActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton3.setText("BUSCAR LEC. ANT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(23, 107, 135));
        jLabel6.setText("LEC. ANTERIOR:");

        jlblLecturaAnterior.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jlblLecturaAnterior.setForeground(new java.awt.Color(14, 41, 84));
        jlblLecturaAnterior.setText("jLabel5");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 107, 135));
        jLabel2.setText("INGRESE LEC. ACTUAL:");

        jtxtLecturaActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbtnINgreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnINgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresar.png"))); // NOI18N
        jbtnINgreso.setText("INGRESAR LECTURA");
        jbtnINgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnINgresoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(23, 107, 135));
        jLabel9.setText("SELECCIONAR EL MES ACTUAL:");

        jAñoA.setBackground(new java.awt.Color(255, 255, 255));
        jAñoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 39, 190)));

        jMesA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 39, 190)));
        jMesA.setForeground(new java.awt.Color(255, 51, 51));
        jMesA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jcbxDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxtLecturaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jlblLecturaAnterior))
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnINgreso)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jAñoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMesA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMesA, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jAñoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbxDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlblLecturaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtLecturaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnINgreso))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jtblLecturas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtblLecturas.setRowHeight(20);
        jtblLecturas.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(jtblLecturas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        // TODO add your handling code here:
        String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        String añio = "" + jAñoA.getYear() + "/" + MES[jMesA.getMonth()];
        String[] registros = new String[7];
        try {
            String titulos[] = {"CEDULA", "NOMBRES", "APELLIDOS", "LEC. ANTERIOR", "LEC. ACTUAL", "TIPO LECTURA", "MES"};
            modelo = new DefaultTableModel(null, titulos);

            String sql = "SELECT U.*, L.* FROM USUARIOS U, LECTURAS L WHERE U.CED_USU = L.CED_USU_PER AND TIPO_LEC='" + jcbxTipo.getSelectedItem().toString() + "' AND MES_CON='" + añio + "' AND U.NOM_USU LIKE '" + jtxtNombre.getText() + "%'";
            Statement psd = connection.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CED_USU");
                registros[1] = rs.getString("NOM_USU");
                registros[2] = rs.getString("APE_USU");
                registros[3] = rs.getString("LEC_ANT");
                registros[4] = rs.getString("LEC_ACT");
                registros[5] = rs.getString("TIPO_LEC");
                registros[6] = rs.getString("MES_CON");

                modelo.addRow(registros);

            }

            jtblLecturas.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        
        if (jbtnCargar.isSelected()) {
            String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            String añio = "" + jAñoA.getYear() + "/" + MES[jMesA.getMonth()];

            eliminar(añio, jcbxTipo.getSelectedItem().toString());

        } else {
            String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            String añio = "" + jYearChooser1.getYear() + "/" + MES[jMonthChooser1.getMonth()];

            eliminar(añio, jcbxBuscar.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:

        if (jbtnCargar.isSelected()) {
            String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            String añio = "" + jAñoA.getYear() + "/" + MES[jMesA.getMonth()];

            modificar(añio, jcbxTipo.getSelectedItem().toString());

        } else {
            String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            String añio = "" + jYearChooser1.getYear() + "/" + MES[jMonthChooser1.getMonth()];

            modificar(añio, jcbxBuscar.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        String año = "" + jAño.getYear() + "/" + MES[jMes.getMonth()] + "";

        User mUsuarios = (User) jcbxDatos.getSelectedItem();
        cedula = String.valueOf(mUsuarios.getCedula());
        //JOptionPane.showMessageDialog(null, "ID: " + cedula);

        //obtenerLectura(cedula,jcbxTipo.getSelectedItem().toString(),año);
        try {
            obtenerLectura(cedula, jcbxTipo.getSelectedItem().toString(), año);
            jbtnINgreso.setEnabled(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jcbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxTipoItemStateChanged
        // TODO add your handling code here:
        jbtnINgreso.setEnabled(false);
    }//GEN-LAST:event_jcbxTipoItemStateChanged

    private void jbtnINgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnINgresoActionPerformed
        try {

            String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            String añio = "" + jAñoA.getYear() + "/" + MES[jMesA.getMonth()];

            String valorLectura = "";
            String mes = "";
            String sqlLectura = "SELECT * FROM lecturas\n"
                    + "where MES_CON='" + añio + "'\n"
                    + "AND TIPO_LEC='" + jcbxTipo.getSelectedItem().toString() + "'\n"
                    + "AND CED_USU_PER='" + cedula + "'";

            Statement psdRiego = connection.createStatement();
            ResultSet rs = psdRiego.executeQuery(sqlLectura);
            while (rs.next()) {
                valorLectura = rs.getString("LEC_ACT");
                mes = rs.getString("MES_CON");

            }
            int lec = Integer.valueOf(jlblLecturaAnterior.getText());
            System.out.println(lec);
            if (valorLectura.isEmpty()) {

                if (jtxtLecturaActual.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese Lec. Actual");
                } else if (lec == 0) {
                    JOptionPane.showMessageDialog(null, "Error en Lec. Anterior");
                } else if (Integer.valueOf(jtxtLecturaActual.getText()) < lec) {
                    JOptionPane.showMessageDialog(null, "Verifique Lec. Actual");
                } else {
                    String sql = "INSERT INTO LECTURAS(LEC_ANT,LEC_ACT,FEC_LEC,TIPO_LEC,MES_CON,CED_USU_PER) values(?,?,?,?,?,?)";
                    PreparedStatement psd = connection.prepareStatement(sql);

                    psd.setInt(1, lec);
                    psd.setInt(2, Integer.valueOf(jtxtLecturaActual.getText()));
                    psd.setDate(3, Date.valueOf(LocalDate.now()));
                    psd.setString(4, jcbxTipo.getSelectedItem().toString());
                    psd.setString(5, añio);
                    psd.setString(6, cedula);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Ingreso exitoso");

                        cargarTablaLecturas(jcbxTipo.getSelectedItem().toString(), añio);
                        jlblLecturaAnterior.setText("");
                        jtxtLecturaActual.setText("");
                        jbtnINgreso.setEnabled(false);

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario con Lectura existente ");
                jtxtLecturaActual.setText("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngresoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnINgresoActionPerformed

    private void jcbxDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxDatosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jcbxDatosActionPerformed

    private void jcbxDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxDatosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxDatosMousePressed

    private void jcbxDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxDatosMouseClicked

    }//GEN-LAST:event_jcbxDatosMouseClicked

    private void jcbxDatosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxDatosItemStateChanged
        // TODO add your handling code here:
        jbtnINgreso.setEnabled(false);
    }//GEN-LAST:event_jcbxDatosItemStateChanged

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        // TODO add your handling code here:
        String MES[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        String añio = "" + jYearChooser1.getYear() + "/" + MES[jMonthChooser1.getMonth()];
        cargarTablaLecturas(jcbxTipo.getSelectedItem().toString(), añio);

    }//GEN-LAST:event_jbtnCargarActionPerformed

    public void obtenerLectura(String ceda, String lectura, String anio) {
        try {

            String sql = "SELECT LEC_ACT FROM LECTURAS WHERE CED_USU_PER='" + ceda + "' AND TIPO_LEC='" + lectura + "' AND MES_CON='" + anio + "'";
            Statement psd = connection.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            String lecturaAnt = "";
            System.out.println(cedula);
            while (rs.next()) {
                lecturaAnt = rs.getString("LEC_ACT");
                System.out.println(lecturaAnt);
                jlblLecturaAnterior.setText(lecturaAnt);
            }
            if (lecturaAnt.isEmpty()) {
                String num = "0";
                jlblLecturaAnterior.setText(num);
            }

        } catch (SQLException ex) {
            //Logger.getLogger(IngresoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llenarCBMaterias() {

        //jcbxDatos.removeAllItems();
        //DefaultComboBoxModel<User> comboBoxModel = new DefaultComboBoxModel<>();
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getAllUsers();
        for (User user : userList) {
            jcbxDatos.addItem(user);
        }

    }

    public void eliminar(String anio, String tipo) {
       

        try {

            String estado = "";
            String sqlRiego = "SELECT F.EST_FACT\n"
                    + "FROM FACTURAS F, LECTURAS L, USUARIOS U\n"
                    + "WHERE F.ID_LEC_PER = L.ID_LEC\n"
                    + "AND L.TIPO_LEC='" + tipo + "'\n"
                    + "AND L.MES_CON='" + anio + "'\n"
                    + "AND L.CED_USU_PER = U.CED_USU\n"
                    + "AND U.CED_USU='" + jtxtCedula.getText() + "'";

            Statement psdRiego = connection.createStatement();
            ResultSet rs = psdRiego.executeQuery(sqlRiego);
            while (rs.next()) {
                estado = rs.getString("EST_FACT");

            }
            if (estado.equals("PENDIENTE")) {
                int resp = JOptionPane.showConfirmDialog(this, "Estás seguro de eliminar?", "AVISO",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM LECTURAS\n"
                            + "WHERE CED_USU_PER ='" + jtxtCedula.getText() + "' AND MES_CON='" + anio + "' AND TIPO_LEC='" + jcbxTipo.getSelectedItem().toString() + "'";
                    PreparedStatement psd = connection.prepareStatement(sql);

                    int a = psd.executeUpdate();
                    if (a > 0) {

                        cargarTablaLecturas(jcbxTipo.getSelectedItem().toString(), anio);

                        jtxtLecActual.setText("");
                        jtxtLecAnterior.setText("");
                        jtxtCedula.setText("");
                        jbtnEditar.setEnabled(false);
                        jbtnEliminar.setEnabled(false);
                        jtxtLecActual.setEnabled(false);
                        jtxtLecAnterior.setEnabled(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lectura con Factura Cerrada");
                jtxtLecActual.setText("");
                jtxtLecAnterior.setText("");
                jtxtCedula.setText("");
                jbtnEditar.setEnabled(false);
                jbtnEliminar.setEnabled(false);
                jtxtLecActual.setEnabled(false);
                jtxtLecAnterior.setEnabled(false);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser jAño;
    private com.toedter.calendar.JYearChooser jAñoA;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMes;
    private com.toedter.calendar.JMonthChooser jMesA;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnINgreso;
    private javax.swing.JComboBox<String> jcbxBuscar;
    private javax.swing.JComboBox<User> jcbxDatos;
    private javax.swing.JComboBox<String> jcbxTipo;
    private javax.swing.JLabel jlblLecturaAnterior;
    private javax.swing.JTable jtblLecturas;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtLecActual;
    private javax.swing.JTextField jtxtLecAnterior;
    private javax.swing.JTextField jtxtLecturaActual;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
