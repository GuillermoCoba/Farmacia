/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

import Funciones.utils.Utils;
import farmacia.Login;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Guillermo
 */
public class InicioE extends javax.swing.JFrame {

    AgregarPE ag;
    ConsultarPE co;
    VentasE ve;
    ModificarE mo;
    EliminarPE el;
    Login lo;

    /**
     * Creates new form Inicio
     */
    public InicioE() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jLabel1 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonVenta = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelAgregar = new javax.swing.JLabel();
        jLabelModificar = new javax.swing.JLabel();
        jLabelConsultar = new javax.swing.JLabel();
        jLabelVenta = new javax.swing.JLabel();
        jLabelEliminar = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Farmacia \"Econofarm\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jButtonAgregar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar Producto");
        jButtonAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 250, 30));

        jButtonConsultar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButtonConsultar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConsultar.setText("Consultar Producto");
        jButtonConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonConsultar.setBorderPainted(false);
        jButtonConsultar.setContentAreaFilled(false);
        jButtonConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 250, 30));

        jButtonModificar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar Producto");
        jButtonModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 250, 30));

        jButtonEliminar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar Producto");
        jButtonEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 530, 250, 30));

        jButtonVenta.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jButtonVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVenta.setText("Venta");
        jButtonVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVenta.setBorderPainted(false);
        jButtonVenta.setContentAreaFilled(false);
        jButtonVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 230, 120, 30));

        jButtonSalir.setFont(new java.awt.Font("Century Schoolbook", 3, 24)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 630, 100, 40));

        jLabelAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        jLabelAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, 140));

        jLabelModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        getContentPane().add(jLabelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 130, 140));

        jLabelConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa (1).png"))); // NOI18N
        getContentPane().add(jLabelConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 130, 140));

        jLabelVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro-de-la-compra.png"))); // NOI18N
        getContentPane().add(jLabelVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 130, 140));

        jLabelEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bote-de-basura.png"))); // NOI18N
        getContentPane().add(jLabelEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 130, 140));

        jButtonClose.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close3.png"))); // NOI18N
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 5, 25, 25));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient-blue-green-linear-1152x2048-c2-00008b-00ff7f-a-45-f-14.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificar();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        salir();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentaActionPerformed
        venta();
    }//GEN-LAST:event_jButtonVentaActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        salir();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jLabelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAgregarMouseClicked
        agregar();
    }//GEN-LAST:event_jLabelAgregarMouseClicked

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
            java.util.logging.Logger.getLogger(InicioE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InicioE().setVisible(true);
            }
        });
    }

    public void agregar() {
        if (ag == null) {
            ag = new AgregarPE();
            ag.setVisible(true);
            this.setVisible(false);
        }
    }

    public void consultar() {
        if (co == null) {
            co = new ConsultarPE();
            co.setVisible(true);
            this.setVisible(false);
        }
    }

    public void venta() {
        if (ve == null) {
            ve = new VentasE(Utils.EMPLO);
            ve.setVisible(true);
            this.setVisible(false);
        }
    }

    public void modificar() {
        if (mo == null) {
            mo = new ModificarE();
            mo.setVisible(true);
            this.setVisible(false);
        }
    }

    public void eliminar() {
        if (el == null) {
            el = new EliminarPE();
            el.setVisible(true);
            this.setVisible(false);
        }
    }

    public void salir() {
        if (lo == null) {
            lo = new Login();
            lo.setVisible(true);
            this.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAgregar;
    private javax.swing.JLabel jLabelConsultar;
    private javax.swing.JLabel jLabelEliminar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelModificar;
    private javax.swing.JLabel jLabelVenta;
    // End of variables declaration//GEN-END:variables
}
