/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import Funciones.conexion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Guillermo
 */
public class Modificar extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;
    TableRowSorter trs;

    /**
     * Creates new form Modificar
     */
    public Modificar() {
        initComponents();
        LlenarTabla();
        LlenarTipo();
        LlenarPresentacion();
        LlenarLaboratorio();
        conn = conexion.conectar();
        anuncio.setText("<html>Debes dar clic en un registro de la tabla para poder editar la información.</html>");
        anuncioB.setText("<html>NOTA: Puedes ingresar el nombre del producto<br>en el cuadro de texto para poder realizar un filtrado.</html>");
        this.setLocationRelativeTo(null);
    }

    void LlenarTabla() {
        try {
            conn = conexion.conectar();
            String[] titulos = {"IdProducto", "Nombre", "Precio", "Tipo", "Presentacion", "Laboratorio", "Cantidad"};
            String sql = "Select * from productos";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String[] fila = new String[7];
            while (rs.next()) {
                fila[0] = rs.getString("Pr_Id");
                fila[1] = rs.getString("Pr_Nombre");
                fila[2] = rs.getString("Pr_Precio");
                fila[3] = rs.getString("Pr_Tipo");
                fila[4] = rs.getString("Pr_Presentacion");
                fila[5] = rs.getString("Pr_Laboratorio");
                fila[6] = rs.getString("Pr_Cantidad");
                model.addRow(fila);
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
    }

    void LlenarTipo() {
        try {
            conn = conexion.conectar();
            sent = conn.createStatement();
            String sql = "Select TipoProducto from tipoproducto";
            ResultSet rs = sent.executeQuery(sql);
            jComboTipo.addItem("Seleccionar");
            while (rs.next()) {
                jComboTipo.addItem(rs.getString(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
    }

    void LlenarPresentacion() {
        try {
            conn = conexion.conectar();
            sent = conn.createStatement();
            String sql = "Select Presentacion from presentacionproducto";
            ResultSet rs = sent.executeQuery(sql);
            jComboPresentacion.addItem("Seleccionar");
            while (rs.next()) {
                jComboPresentacion.addItem(rs.getString(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
    }

    void LlenarLaboratorio() {
        try {
            conn = conexion.conectar();
            sent = conn.createStatement();
            String sql = "Select La_Nombre from laboratorio";
            ResultSet rs = sent.executeQuery(sql);
            jComboLaboratorio.addItem("Seleccionar");
            while (rs.next()) {
                jComboLaboratorio.addItem(rs.getString(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
    }
    void Habilitar(){
        jTextNombre.enable();
        jTextPrecio.enable();
        jComboTipo.enable();
        jComboPresentacion.enable();
        jComboLaboratorio.enable();
        jTextCantidad.enable();
    }
    void Deshabilitar(){
        jTextNombre.disable();
        jTextPrecio.disable();
        jComboTipo.disable();
        jComboPresentacion.disable();
        jComboLaboratorio.disable();
        jTextCantidad.disable();
    }
    void Limpiar() {
        jTextNombre.setText("");
        jTextPrecio.setText("");
        jComboTipo.setSelectedItem("Seleccionar");
        jComboPresentacion.setSelectedItem("Seleccionar");
        jComboLaboratorio.setSelectedItem("Seleccionar");
        jTextCantidad.setText("");
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/drogas.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTexto = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabelPrecio = new javax.swing.JLabel();
        jTextPrecio = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        jLabelPresentacion = new javax.swing.JLabel();
        jLabelProveedor = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jTextCantidad = new javax.swing.JTextField();
        jButtonCancelar1 = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboTipo = new javax.swing.JComboBox<>();
        jComboPresentacion = new javax.swing.JComboBox<>();
        jComboLaboratorio = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        anuncio = new javax.swing.JLabel();
        anuncioB = new javax.swing.JLabel();
        jTextBuscar = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTexto.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabelTexto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTexto.setText("Modificar Producto");
        getContentPane().add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(240, 240, 240));
        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jTextNombre.setEnabled(false);
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 270, -1));

        jLabelPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(240, 240, 240));
        jLabelPrecio.setText("Precio:");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jTextPrecio.setEnabled(false);
        jTextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 270, -1));

        jLabelTipo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(240, 240, 240));
        jLabelTipo.setText("Tipo:");
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabelPresentacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPresentacion.setForeground(new java.awt.Color(240, 240, 240));
        jLabelPresentacion.setText("Presentacion:");
        getContentPane().add(jLabelPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabelProveedor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelProveedor.setForeground(new java.awt.Color(240, 240, 240));
        jLabelProveedor.setText("Laboratorio:");
        getContentPane().add(jLabelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabelCantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(240, 240, 240));
        jLabelCantidad.setText("Cantidad:");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 90, -1));

        jTextCantidad.setEnabled(false);
        jTextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 270, -1));

        jButtonCancelar1.setText("Cancelar");
        jButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 90, 40));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 90, 40));

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 730, 170));

        jComboTipo.setEnabled(false);
        jComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 270, 20));

        jComboPresentacion.setEnabled(false);
        getContentPane().add(jComboPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 270, -1));

        jComboLaboratorio.setEnabled(false);
        getContentPane().add(jComboLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 270, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 95, -1, -1));

        anuncio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        anuncio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(anuncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, -1, -1));

        anuncioB.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        anuncioB.setForeground(new java.awt.Color(255, 255, 255));
        anuncioB.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(anuncioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 95, -1, -1));

        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarActionPerformed(evt);
            }
        });
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 95, 280, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient-blue-green-linear-1152x2048-c2-00008b-00ff7f-a-45-f-14.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
         int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para que sea modificado.");
        } else {
            try {
                String sql = "update productos set Pr_Nombre=?,Pr_Precio=?,Pr_Tipo=?,Pr_Presentacion=?,Pr_Laboratorio=?,Pr_Cantidad=? where Pr_Id=?";
               
                if (jTextNombre.getText().equals("") || jTextPrecio.getText().equals("")
                || jComboTipo.getSelectedItem().toString().equals("Seleccionar") || jComboPresentacion.getSelectedItem().toString().equals("Seleccionar")
                || jComboLaboratorio.getSelectedItem().toString().equals("Seleccionar") || jTextCantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Faltan Campos.");
                } else {
                    String dao = (String) jTable1.getValueAt(fila, 0);
                    PreparedStatement ps = conn.prepareCall(sql);
                    ps.setString(1, jTextNombre.getText());
                    ps.setString(2, jTextPrecio.getText());
                    ps.setString(3, jComboTipo.getSelectedItem().toString());
                    ps.setString(4, jComboPresentacion.getSelectedItem().toString());
                    ps.setString(5, jComboLaboratorio.getSelectedItem().toString());
                    ps.setString(6, jTextCantidad.getText());
                    ps.setString(7, dao);
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        Limpiar();
                        LlenarTabla();
                        JOptionPane.showMessageDialog(null, "Datos Modificados");
                        Deshabilitar();
                    }
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error ->" + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoActionPerformed

    }//GEN-LAST:event_jComboTipoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getButton() == 1) {
            int fila = jTable1.getSelectedRow();
            Habilitar();
            try {
                String sql = "select * from productos where Pr_Id=" + jTable1.getValueAt(fila, 0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                jTextNombre.setText(rs.getString("Pr_Nombre"));
                jTextPrecio.setText(rs.getString("Pr_Precio"));
                jComboTipo.setSelectedItem(rs.getString("Pr_Tipo"));
                jComboPresentacion.setSelectedItem(rs.getString("Pr_Presentacion"));
                jComboLaboratorio.setSelectedItem(rs.getString("Pr_Laboratorio"));
                jTextCantidad.setText(rs.getString("Pr_Cantidad"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error ->" + e.getMessage());
            }
        }
     
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarActionPerformed

    private void jTextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyReleased
        jTextBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + jTextBuscar.getText(), 1));
            }
        });
        trs = new TableRowSorter(model);
        jTable1.setRowSorter(trs);
    }//GEN-LAST:event_jTextBuscarKeyReleased

    private void jTextPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioKeyTyped
        int caracteres = 8;
        char c = evt.getKeyChar();
        if (jTextPrecio.getText().length() >= caracteres) {
            evt.consume();
        }
        if ((c < '0' || c > '9') && (c != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextPrecioKeyTyped

    private void jTextCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadKeyTyped
        int caracteres = 4;
        char c = evt.getKeyChar();
        if (jTextCantidad.getText().length() >= caracteres) {
            evt.consume();
        }
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextCantidadKeyTyped

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anuncio;
    private javax.swing.JLabel anuncioB;
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboLaboratorio;
    private javax.swing.JComboBox<String> jComboPresentacion;
    private javax.swing.JComboBox<String> jComboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPresentacion;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables
}
