package administrador;

import Funciones.conexion;
import Funciones.utils.Utils;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agregar extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;

    public Agregar() {

        initComponents();
        anuncio.setText("<html>Llena todos los datos del producto para realizar un registro exitoso</html>");
        ValNom.setText("<html>Debes ingresar un nombre.</html>");
        ValPrec.setText("<html>Debes ingresar un precio.</html>");
        ValTipo.setText("<html>Debes seleccionar un tipo.</html>");
         ValPres.setText("<html>Debes seleccionar una presentación.</html>");
         ValLab.setText("<html>Debes seleccionar un laboratorio.</html>");
         ValCan.setText("<html>Debes ingresar una cantidad.</html>");
        LlenarTipo();
        LlenarPresentacion();
        LlenarLaboratorio();
        LlenarTabla();
        conn = conexion.conectar();
        this.setLocationRelativeTo(null);

    }
void Validar() {
 
        if (jTextNombre.getText().isEmpty()) {
              this.ValNom.setForeground(Color.red);
        } else {
            ValNom.setText("");
        }
        if (jTextPrecio.getText().isEmpty()) {
            this.ValPrec.setForeground(Color.red);
        } else {
            ValPrec.setText("");
        }
        if (jComboTipo.getSelectedItem().toString().equals("Seleccionar")) {
            this.ValTipo.setForeground(Color.red);
        } else {
            ValTipo.setText("");
        }
        if (jComboPresentacion.getSelectedItem().toString().equals("Seleccionar")) {
            this.ValPres.setForeground(Color.red);
        } else {
            ValPres.setText("");
        }
        if (jComboLaboratorio.getSelectedItem().toString().equals("Seleccionar")) {
            this.ValLab.setForeground(Color.red);
            
        } else {
            ValLab.setText("");
        }
        if (jTextCantidad.getText().isEmpty()) {
            this.ValCan.setForeground(Color.red);
            
        } else {
            ValCan.setText("");
        }

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
        jLabelPrecio = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelPresentacion = new javax.swing.JLabel();
        jLabelProveedor = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jComboTipo = new javax.swing.JComboBox<>();
        jComboPresentacion = new javax.swing.JComboBox<>();
        jComboLaboratorio = new javax.swing.JComboBox<>();
        jTextPrecio = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        anuncio = new javax.swing.JLabel();
        ValNom = new javax.swing.JLabel();
        ValPrec = new javax.swing.JLabel();
        ValTipo = new javax.swing.JLabel();
        ValPres = new javax.swing.JLabel();
        ValLab = new javax.swing.JLabel();
        ValCan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTexto.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabelTexto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTexto.setText("Agregar Producto");
        getContentPane().add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(240, 240, 240));
        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabelPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(240, 240, 240));
        jLabelPrecio.setText("Precio:");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabelTipo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(240, 240, 240));
        jLabelTipo.setText("Tipo:");
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jLabelPresentacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPresentacion.setForeground(new java.awt.Color(240, 240, 240));
        jLabelPresentacion.setText("Presentacion:");
        getContentPane().add(jLabelPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabelProveedor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelProveedor.setForeground(new java.awt.Color(240, 240, 240));
        jLabelProveedor.setText("Laboratorio:");
        getContentPane().add(jLabelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabelCantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(240, 240, 240));
        jLabelCantidad.setText("Cantidad:");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 90, -1));

        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 270, -1));

        jComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 270, 20));

        getContentPane().add(jComboPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 270, -1));

        getContentPane().add(jComboLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 270, -1));

        jTextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 270, -1));

        jTextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 270, -1));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 90, 40));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButtonCancelarStateChanged(evt);
            }
        });
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 90, 40));

        anuncio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        anuncio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(anuncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        ValNom.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValNom.setForeground(new java.awt.Color(255, 255, 255));
        ValNom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        ValPrec.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValPrec.setForeground(new java.awt.Color(255, 255, 255));
        ValPrec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValPrec, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        ValTipo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValTipo.setForeground(new java.awt.Color(255, 255, 255));
        ValTipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        ValPres.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValPres.setForeground(new java.awt.Color(255, 255, 255));
        ValPres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValPres, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, -1));

        ValLab.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValLab.setForeground(new java.awt.Color(255, 255, 255));
        ValLab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        ValCan.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ValCan.setForeground(new java.awt.Color(255, 255, 255));
        ValCan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(ValCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 720, 160));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient-blue-green-linear-1152x2048-c2-00008b-00ff7f-a-45-f-14.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        String Nom = jTextNombre.getText();
        String Tipo = jComboTipo.getSelectedItem().toString();
        String Pres = jComboPresentacion.getSelectedItem().toString();
        String Lab = jComboLaboratorio.getSelectedItem().toString();
    
        if (jTextNombre.getText().equals("") || jTextPrecio.getText().equals("")
                || jComboTipo.getSelectedItem().toString().equals("Seleccionar") || jComboPresentacion.getSelectedItem().toString().equals("Seleccionar")
                || jComboLaboratorio.getSelectedItem().toString().equals("Seleccionar") || jTextCantidad.getText().equals("")) {
            Validar();
            JOptionPane.showMessageDialog(null, "Faltan campos");
            
        } else {
            if((Nom.equals(Utils.user("productos", "Pr_Nombre", Nom)) && Tipo.equals(Utils.user("productos", "Pr_Tipo", Tipo)))&&
                 (Pres.equals(Utils.user("productos", "Pr_Presentacion", Pres)) && Lab.equals(Utils.user("productos", "Pr_Laboratorio", Lab)))){
                Validar();
                JOptionPane.showMessageDialog(null, "Este producto ya existe.");
            }
            else{
            try {
                String sql = "insert into productos (Pr_Nombre,Pr_Precio,Pr_Tipo,Pr_Presentacion,Pr_Laboratorio,Pr_Cantidad) values (?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, jTextNombre.getText());
                ps.setString(2, jTextPrecio.getText());
                ps.setString(3, jComboTipo.getSelectedItem().toString());
                ps.setString(4, jComboPresentacion.getSelectedItem().toString());
                ps.setString(5, jComboLaboratorio.getSelectedItem().toString());
                ps.setString(6, jTextCantidad.getText());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
            }
            Limpiar();
            LlenarTabla();
        }
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoActionPerformed

    }//GEN-LAST:event_jComboTipoActionPerformed

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

    private void jButtonCancelarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jButtonCancelarStateChanged

    }//GEN-LAST:event_jButtonCancelarStateChanged

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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ValCan;
    private javax.swing.JLabel ValLab;
    private javax.swing.JLabel ValNom;
    private javax.swing.JLabel ValPrec;
    private javax.swing.JLabel ValPres;
    private javax.swing.JLabel ValTipo;
    private javax.swing.JLabel anuncio;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboLaboratorio;
    private javax.swing.JComboBox<String> jComboPresentacion;
    private javax.swing.JComboBox<String> jComboTipo;
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
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables
}
