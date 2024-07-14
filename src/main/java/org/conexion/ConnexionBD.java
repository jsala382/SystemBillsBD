package org.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/db_factura?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connexionBAD;

    public static Connection getConnection() {
        if (connexionBAD == null) {
            try {
                connexionBAD = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("ERROR AL CONECTARSE A LA BASE DE DATOS " + e);
            }
        }
        return connexionBAD;
    }
}
