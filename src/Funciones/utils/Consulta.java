/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.utils;

import Funciones.conexion;
import administrador.Dproducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Consulta {

    private static Connection conn;
    private static Statement sent;
    private static ResultSet rs;

    public ArrayList<Dproducto> cargarlistaproductos(String dato) {

        ArrayList<Dproducto> arrayList = null;

        try {
            conn = conexion.conectar();

            arrayList = new ArrayList<Dproducto>();

            Dproducto Registro;
            String mostrar = "SELECT * FROM productos WHERE CONCAT (Pr_Id,'',Pr_Nombre) LIKE '%" + dato + "%'";
            sent = conn.createStatement();
            rs = sent.executeQuery(mostrar);
            while (rs.next()) {
                Registro = new Dproducto();
                Registro.setPr_Id(rs.getLong("Pr_Id"));
                Registro.setPr_Nombre(rs.getString("Pr_Nombre"));
                Registro.setPr_Presentacion(rs.getString("Pr_Presentacion"));
                Registro.setPr_Precio(rs.getFloat("Pr_Precio"));
                Registro.setPr_Cantidad(rs.getInt("Pr_Cantidad"));
                arrayList.add(Registro);
            }
            return arrayList;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
            return arrayList = null;
        }
    }

    public static String comparar(String cod) {
        String cant = "";
        try {
            conn = conexion.conectar();
            sent = conn.createStatement();
            rs = sent.executeQuery("SELECT * FROM productos WHERE Pr_Id='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(7);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
        }
        return cant;

    }

}
