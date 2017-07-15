package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Tema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

public class TemaDaoImp extends Conexion implements TemaDao {

    @Override
    public void ingresarTema(Tema tema) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "INSERT INTO TEMAS (nombre, descripcion) VALUES (?,?)";
            ps = this.getConn().prepareStatement(consulta);

            ps.setString(1, tema.getNombre());
            ps.setString(2, tema.getDescripcion());

            ps.executeUpdate();

            ps.close();
            

        } catch (SQLException ex) {

            throw new PersistenceException("Error al ingresar el Tema");
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public List<Tema> cargarComboTema() throws PersistenciaExcepcion {

        List<Tema> listaTemas = new ArrayList<>();;
        String consulta;
        ResultSet rs;
        Statement st = null;

        try {
            consulta = "SELECT idTema, nombre FROM TEMAS";
            this.conectar();

            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                Tema tema = new Tema();
                tema.setIdTema(rs.getInt("idTema"));
                tema.setNombre(rs.getString("nombre"));

                listaTemas.add(tema);

            }

            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Error al cargarla lista de temas");

        } finally {

            this.cerrarConexion();
        }

        return listaTemas;

    }
}
