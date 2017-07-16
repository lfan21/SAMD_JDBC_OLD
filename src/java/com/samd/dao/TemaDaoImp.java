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
            consulta = "SELECT idTema, nombre FROM TEMAS WHERE estado = 1";
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

            throw new PersistenciaExcepcion("Error al cargar combo de temas");

        } finally {

            this.cerrarConexion();
        }

        return listaTemas;

    }

    @Override
    public List<Tema> listarTemas() throws PersistenciaExcepcion {

        List<Tema> retorno = null;
        Statement st;
        ResultSet rs;
        String consulta;

        try {
            consulta = "SELECT * FROM Temas where estado = 1";
            this.conectar();
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);
            retorno = new ArrayList<>();
            while (rs.next()) {
                Tema tema = new Tema();
                tema.setIdTema(rs.getInt("idTema"));
                tema.setNombre(rs.getString("nombre"));
                tema.setDescripcion(rs.getString("descripcion"));
                tema.setEstado(rs.getInt("estado"));
                
                retorno.add(tema);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Ha ocurrido un error al intentar cargar los temas");
        } finally {
            this.cerrarConexion();
        }

        return retorno;

    }

    @Override
    public void eliminarTema(Tema tema) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "UPDATE TEMAS SET estado = ? WHERE idTema = ?";
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, 0);
            ps.setInt(2, tema.getIdTema());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarTema(Tema tema) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "UPDATE TEMAS SET nombre = ?, descripcion = ? WHERE idTema = ?";
            ps = this.getConn().prepareStatement(consulta);

            ps.setString(1, tema.getNombre());
            ps.setString(2, tema.getDescripcion());
            ps.setInt(3, tema.getIdTema());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al modificar la pregunta" + e);
        } finally {
            this.cerrarConexion();;
        }

    }

}
