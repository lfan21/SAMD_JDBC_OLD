package com.samd.dao;

import com.mysql.jdbc.Connection;
import com.samd.excepciones.PersistenciaExcepcion;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String SERVIDOR = "jdbc:mysql://localhost/samdbd";
    private final String USUARIO = "root";
    private final String CONTRASENIA = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection conn = null;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void conectar() throws PersistenciaExcepcion {

        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(SERVIDOR, USUARIO, CONTRASENIA);
        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Ha ocurrido un error al conectarse a la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarConexion() throws PersistenciaExcepcion {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new PersistenciaExcepcion("Ha ocurrido un error al cerrar la conexión");
            }
        }
    }

}
