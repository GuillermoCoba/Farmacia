/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.utils;

import Funciones.conexion;
import empleado.VentasE;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author diego
 */
public class Utils {
//Constantes

    public static boolean ADMIN = true;
    public static boolean EMPLO = false;
    public static Connection conn;
    public static Statement sent;
   
//Constantes

    public static void tablaListener(JTable table) {
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableCellListener tcl = (TableCellListener) e.getSource();
                System.out.println("Row   : " + tcl.getRow());
                System.out.println("Column: " + tcl.getColumn());
                System.out.println("Old   : " + tcl.getOldValue());
                System.out.println("New   : " + tcl.getNewValue());
                try {
                    Integer comparar = Integer.parseInt(Consulta.comparar(table.getValueAt(tcl.getRow(), 0).toString()));
                    if (Integer.parseInt(tcl.getNewValue().toString()) <= 0) {
                        table.setValueAt(tcl.getOldValue(), tcl.getRow(), 4);
                        JOptionPane.showMessageDialog(null, "<html>Debe ingresar una cantidad mayor a 0. Intente nuevamente.<br><b>Si desea eliminar un producto utilice el botón \"Eliminar de lista\".</b></html>");
                    } else if (Integer.parseInt(tcl.getNewValue().toString()) > comparar) {
                        table.setValueAt(tcl.getOldValue(), tcl.getRow(), 4);
                        JOptionPane.showMessageDialog(null, "<html>No hay suficiente stock del producto.<br>Intente nuevamente. <b>Stock de " + comparar + "</b></html>");
                    } else {
                        VentasE.calcular();
                    }
                } catch (NumberFormatException exp) {
                    System.out.println("error Formato Numerico ->" + exp.getMessage());
                    table.setValueAt(tcl.getOldValue(), tcl.getRow(), 4);
                    JOptionPane.showMessageDialog(null, "Ingrese solo números.\nIntente nuevamente.");
                }
            }
        };

        new TableCellListener(table, action);
    }

    public static boolean verifCorreo(String correo) {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9]+(\\.[a-z0-9]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static void validNomApe(String nomApe, KeyEvent evt) {
        int maxCar = 20;
        char car = evt.getKeyChar();
        if (nomApe.length() >= maxCar) {
            evt.consume();
        }
        if (!Character.isLetter(car) && car != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }
    
    public static String user(String tabla, String campo, String con ){  
            try {
            conn = conexion.conectar();
            String sql = "SELECT * FROM "+ tabla+ " WHERE " +campo+ " = "+"'" + con + "'";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            String aux = rs.getString(campo);
           return aux;
        } catch (SQLException e) {
            
            System.out.println("Error ->" + e.getMessage());
           return null;
        }
    }
    public static int User2(String user, String email ){  
            try {
            conn = conexion.conectar();
            String sql = "SELECT COUNT(*) AS Total FROM empleados WHERE Em_Usuario = '"+user +"' && Em_Contraseña= '"+email+"'"; 
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            int aux = rs.getInt("Total");
           return aux;
        } catch (SQLException e) {
            
            System.out.println("Error ->" + e.getMessage());
           return 0;
        }
    }
}
