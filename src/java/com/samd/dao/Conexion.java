package com.samd.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private  final String SERVIDOR = "jdbc:mysql://localhost/samdbd";
    private  final String USUARIO = "root";
    private  final String CONTRASENIA = "root";
    private  final String DRIVER = "com.mysql.jdbc.Driver";
    private  Connection conn = null;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }


    public void conectar ()throws ClassNotFoundException, SQLException {

        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(SERVIDOR, USUARIO, CONTRASENIA);
        } catch (SQLException e) {
            throw new SQLException(e);
        }

 
    }

    public  void cerrarConexion() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
