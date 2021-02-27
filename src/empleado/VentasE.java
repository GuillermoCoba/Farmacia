/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

import Funciones.conexion;
import Funciones.utils.Consulta;
import Funciones.utils.TableCellListener;
import Funciones.utils.Utils;
import administrador.Inicio;
import empleado.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo
 */
public class VentasE extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;
    ProductosBE pro;
    boolean bandera = false;
    private boolean userType;

    private VentasE() {
        initComponents();
        Desabilitar();
        this.setLocationRelativeTo(null);
        anuncio.setText("<html>Debes dar clic en el botón<br>encender para poder comenzar.</html>");
        Utils.tablaListener(jTable1);
    }

    public VentasE(boolean userType) {
        this();
        this.userType = userType;
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/drogas.png"));
        return retValue;
    }

    private void Desabilitar() {
//        jTextCodigo.setEnabled(false);
//        jTextPrecio.setEnabled(false);
//        jTextCantidad.setEnabled(false);
//        jTextProducto.setEnabled(false);
        jTextCambio.setEnabled(false);
        jTextTotal.setEnabled(false);
        jTextEfectivo.setEnabled(false);
        jButtonQuitar.setEnabled(false);
        jButtonBuscar.setEnabled(false);
        jButtonCambio.setEnabled(false);
        jButtonFinalizar.setEnabled(false);
    }

    private void Habilitar() {
//        jTextCantidad.setEnabled(true);
        jTextEfectivo.setEnabled(true);
        jButtonQuitar.setEnabled(true);
        jButtonBuscar.setEnabled(true);
        jButtonCambio.setEnabled(true);
        jButtonFinalizar.setEnabled(true);
        anuncio.setText("<html>Gracias, puedes agregar<br>productos dando clic en el botón<br>buscar.</html>");
    }

    private Float obtenerCambio() {
        float n1, n2, res;
        String total = jTextTotal.getText(), efec = jTextEfectivo.getText();
        n1 = Float.parseFloat((total.isEmpty()) ? "0" : total);
        n2 = Float.parseFloat((efec.isEmpty()) ? "0" : efec);
        res = n2 - n1;
        return ((res < 0) ? 0 : res);
    }

    private void clear() {
//        jTextCodigo.setText("");
//        jTextProducto.setText("");
//        jTextCantidad.setText("");
//        jTextPrecio.setText("");
        jTextTotal.setText("0");
        jTextCambio.setText("0");
        jTextEfectivo.setText("0");
    }

    void descontarstock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        try {
            String consul = "SELECT * FROM productos WHERE  Pr_Id='" + codi + "'";
            conn = conexion.conectar();
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(7);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
        int fin = Integer.parseInt(cap);
        desfinal = fin - des;

        String modi = "UPDATE productos SET Pr_Cantidad='" + desfinal + "' WHERE Pr_Id = '" + codi + "'";
        try {
            PreparedStatement pst = conn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
    }

    public static void calcular() {
        String pre;
        String can;
        //double igv = 0;
        //double total = 0;
        double subtotal = 0;
        double precio;
        int cantidad;
        double imp;

        /*can=Integer.parseInt(cant);
            imp=pre*can;
            dato[4]=Float.toString(imp);*/
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            pre = jTable1.getValueAt(i, 3).toString();
            can = jTable1.getValueAt(i, 4).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            subtotal = subtotal + imp;

            jTable1.setValueAt(Math.rint(imp * 100) / 100, i, 5);

        }

        jTextTotal.setText("" + (Math.rint(subtotal * 100) / 100));
    }

    void detalleboleta() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO venta(Pr_Id,Pr_Nombre,Pr_Presentacion,Pr_Precio,Pr_Cantidad,Pr_Total) VALUES (?,?,?,?,?,?)";
            String codigo = jTable1.getValueAt(i, 0).toString();
            String nombre = jTable1.getValueAt(i, 1).toString();
            String presentacion = jTable1.getValueAt(i, 2).toString();
            String precio = jTable1.getValueAt(i, 3).toString();
            String cantidad = jTable1.getValueAt(i, 4).toString();
            String total = jTable1.getValueAt(i, 5).toString();

            try {
                PreparedStatement pst = conn.prepareStatement(InsertarSQL);
                pst.setString(1, codigo);
                pst.setString(2, nombre);
                pst.setString(3, presentacion);
                pst.setString(4, precio);
                pst.setString(5, cantidad);
                pst.setString(6, total);
                pst.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error ->" + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTexto = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonQuitar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextTotal = new javax.swing.JTextField();
        jLabeltotal = new javax.swing.JLabel();
        jTextEfectivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jTextCambio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        anuncio = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jButtonCambio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(910, 600));
        setMinimumSize(new java.awt.Dimension(910, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(910, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTexto.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabelTexto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTexto.setText("Venta");
        getContentPane().add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, -1));

        jButtonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/potencia.png"))); // NOI18N
        jButtonIniciar.setToolTipText("Encender");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 70, -1));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jButtonSalir.setToolTipText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 550, 70, -1));

        jButtonQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/quitar-del-carrito.png"))); // NOI18N
        jButtonQuitar.setToolTipText("Eliminar de lista");
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 70, -1));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-para-buscar.png"))); // NOI18N
        jButtonBuscar.setToolTipText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 70, -1));

        jTextTotal.setText("0");
        jTextTotal.setToolTipText("Costo Total");
        jTextTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTotalKeyTyped(evt);
            }
        });
        getContentPane().add(jTextTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 88, -1));

        jLabeltotal.setBackground(new java.awt.Color(0, 0, 0));
        jLabeltotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabeltotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabeltotal.setText("TOTAL : $");
        getContentPane().add(jLabeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 400, -1, 20));

        jTextEfectivo.setText("0");
        jTextEfectivo.setToolTipText("Monto de cobro");
        jTextEfectivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextEfectivoFocusGained(evt);
            }
        });
        jTextEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextEfectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextEfectivoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 87, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EFECTIVO : $");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 430, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CAMBIO : $");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 460, -1, 20));

        jButtonFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comprobar (1).png"))); // NOI18N
        jButtonFinalizar.setToolTipText("Venta");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 70, 30));

        jTextCambio.setText("0");
        jTextCambio.setToolTipText("Cambio");
        getContentPane().add(jTextCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 86, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUCTO", "PRODUCTO", "PRESENTACIÓN", "PRECIO", "CANTIDAD", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 680, 320));

        anuncio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        anuncio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(anuncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 100, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient-blue-green-linear-1152x2048-c2-00008b-00ff7f-a-45-f-14.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 680));

        jButtonCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinero.png"))); // NOI18N
        jButtonCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        clear();
        Habilitar();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambioActionPerformed
        if (jTable1.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Debe ingresar mínimo un producto.");
        } else {
            calcular();
        }

    }//GEN-LAST:event_jButtonCambioActionPerformed

    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            model.removeRow(fila);
            calcular();
        } else {
            JOptionPane.showMessageDialog(null, "La tabla está vacía o no seleccionó ningún producto.");
        }

    }//GEN-LAST:event_jButtonQuitarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if (pro == null) {
            pro = new ProductosBE();
            pro.setVisible(true);
            JOptionPane.showMessageDialog(null, "<html><b>El stock mantiene el número real del los productos,</b><br><b>solo cambia después de realizar la venta.</b>", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else if (!pro.isVisible()) {
            pro.cargarlistaproductos();
            pro.setVisible(true);
        } else {
            pro.toFront();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        if (pro != null && pro.isVisible()) {
            pro.dispose();
        }
        if (userType) {
            Inicio in = new Inicio();
            in.setVisible(true);
            this.setVisible(false);
        } else {
            InicioE in = new InicioE();
            in.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        if (jTextTotal.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Debe agregar un producto mínimo a la lista para realizar una venta.");
            bandera = true;
        } else if (jTextTotal.getText().equals("0") && bandera) {
            JOptionPane.showMessageDialog(this, "Debe agregar un producto mínimo a la lista para realizar una venta.\nPara agregar un producto debe dar clic en el botón de búsqueda.");
            bandera = false;
        } else {
            if (jTextEfectivo.getText().equals("") || jTextEfectivo.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto de efectivo para realizar el cobro.");
            } else {
                float imp = Float.parseFloat(jTextEfectivo.getText());
                float tot = Float.parseFloat(jTextTotal.getText());
                if (imp < tot) {
                    JOptionPane.showMessageDialog(null, "La cantidad de efectivo debe ser mayor que el costo total de los productos.");
                } else {
                    JOptionPane.showMessageDialog(null, "<html>Venta Finalizada. El cambio es de <b>$" + jTextCambio.getText() + "</b><br>Para realizar otra compra seleccione el botón encender.</html>");
                    String capcod, capcan;
                    for (int i = 0; i < VentasE.jTable1.getRowCount(); i++) {
                        capcod = VentasE.jTable1.getValueAt(i, 0).toString();
                        capcan = VentasE.jTable1.getValueAt(i, 4).toString();
                        descontarstock(capcod, capcan);

                    }
                    detalleboleta();

                    jButtonQuitar.setEnabled(false);
                    jButtonBuscar.setEnabled(false);
                    jButtonCambio.setEnabled(false);
                    jButtonFinalizar.setEnabled(false);
                    jTextEfectivo.setEnabled(false);
                    DefaultTableModel jTableVent = (DefaultTableModel) jTable1.getModel();
                    jTableVent.setRowCount(0);
                    anuncio.setText("<html>Debes dar clic en el botón<br>encender para poder comenzar.</html>");
                    clear();

                }
            }
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        jTextCodigo.setEditable(false);
//        jTextPrecio.setEditable(false);
//        jTextProducto.setEditable(false);
//        int rec = this.jTable1.getSelectedRow();
//        this.jTextCodigo.setText(jTable1.getValueAt(rec, 0).toString());
//        this.jTextProducto.setText(jTable1.getValueAt(rec, 1).toString());
//        this.jTextPrecio.setText(jTable1.getValueAt(rec, 3).toString());
//        this.jTextCantidad.setText(jTable1.getValueAt(rec, 4).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTotalKeyTyped
//        int caracteres = 8;
//        char c = evt.getKeyChar();
//        if (jTextPrecio.getText().length() >= caracteres) {
//            evt.consume();
//        }
//        if ((c < '0' || c > '9') && (c != '.')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jTextTotalKeyTyped

    private void jTextEfectivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextEfectivoFocusGained
        jTextEfectivo.selectAll();
    }//GEN-LAST:event_jTextEfectivoFocusGained

    private void jTextEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEfectivoKeyReleased
        if (!jTextEfectivo.getText().equals(".")) {
            jTextCambio.setText(obtenerCambio().toString());
        }
    }//GEN-LAST:event_jTextEfectivoKeyReleased

    private void jTextEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEfectivoKeyTyped
        int maxCar = 8;
        char c = evt.getKeyChar();
        if (jTextEfectivo.getText().length() >= maxCar) {
            evt.consume();
        }
        if ((c < '0' || c > '9') && (c != '.') && (c != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextEfectivoKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anuncio;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCambio;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonQuitar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JLabel jLabeltotal;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCambio;
    private javax.swing.JTextField jTextEfectivo;
    private static javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}
