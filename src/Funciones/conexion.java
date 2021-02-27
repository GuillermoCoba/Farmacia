package Funciones;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class conexion {

    Connection conn = null;

    public static Connection conectar() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9342904","sql9342904","9U5kBNXQWd");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/farmacia", "root", "");
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio una falla contacte a su proveedor.", "Falla", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error ->" + e.getMessage());
            return null;

        }
    }

}
