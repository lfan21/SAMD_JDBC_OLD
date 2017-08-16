package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeoricoDaoImp extends Conexion implements TeoricoDao {

    @Override
    public void ingresarTeorico(Teorico teorico) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            consulta = "INSERT INTO TEORICO (titulo, contenido,TEMAS_idTema) values(?,?,?)";

            this.conectar();
            ps = this.getConn().prepareStatement(consulta);
            ps.setString(1, teorico.getTitulo());
            ps.setString(2, teorico.getContenido());
            ps.setInt(3, teorico.getIdTema());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("No se ha podido ingresar el teórico intente nuevamente");
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void modificarTeorico(Teorico teorico) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "UPDATE TEORICO SET titulo = ?, contenido = ?, TEMAS_idTema = ? WHERE idTeorico = ?";
            ps = this.getConn().prepareStatement(consulta);

            ps.setString(1, teorico.getTitulo());
            ps.setString(2, teorico.getContenido());
            ps.setInt(3, teorico.getIdTema());
            ps.setInt(4, teorico.getIdTeorico());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al modificar el teórico");
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void eliminarTeorico(Teorico teorico) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "UPDATE TEORICO SET estado = ? WHERE idTeorico = ?";
            ps = this.getConn().prepareStatement(consulta);

            ps.setInt(1, 0);
            ps.setInt(2, teorico.getIdTeorico());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al eliminar el teórico");
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public List<Teorico> listarTeoricos() throws PersistenciaExcepcion {

        List<Teorico> retorno = null;
        ResultSet rs;
        Statement st;

        try {
            String consulta = "SELECT * FROM Teorico WHERE estado = 1";
            this.conectar();
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);
            retorno = new ArrayList<>();
            while (rs.next()) {
                Teorico teorico = new Teorico();
                teorico.setIdTeorico(rs.getInt("idTeorico"));
                teorico.setTitulo(rs.getString("titulo"));
                teorico.setContenido(rs.getString("contenido"));
                teorico.setIdTema(rs.getInt("TEMAS_idTema"));
                teorico.setEstado(rs.getInt("estado"));
                retorno.add(teorico);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("No se ha podido listar el teórico");

        } finally {
            this.cerrarConexion();
        }

        return retorno;

    }

    @Override
    public List<Teorico> retornarTeoricosTema(Tema tema) throws PersistenciaExcepcion {

        List<Teorico> retorno = null;
        ResultSet rs;
        PreparedStatement ps = null;

        try {
            String consulta = "SELECT * FROM Teorico WHERE TEMAS_idTema = ? AND estado=1 ";
            this.conectar();
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, tema.getIdTema());

            rs = ps.executeQuery();

            retorno = new ArrayList<>();
            while (rs.next()) {
                Teorico teorico = new Teorico();
                teorico.setIdTeorico(rs.getInt("idTeorico"));
                teorico.setTitulo(rs.getString("titulo"));
                teorico.setContenido(rs.getString("contenido"));
                teorico.setIdTema(rs.getInt("TEMAS_idTema"));
                teorico.setEstado(rs.getInt("estado"));
                retorno.add(teorico);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("No se ha podido listar el teórico");

        } finally {
            this.cerrarConexion();
        }

        return retorno;

    }

    @Override
    public Teorico retornarTeoricoPorId(int numero) throws PersistenciaExcepcion {

        Teorico teorico = null;
        ResultSet rs;
        PreparedStatement ps = null;

        try {
            String consulta = "SELECT * FROM Teorico WHERE idTeorico = ? AND estado=1 ";
            this.conectar();
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, numero);

            rs = ps.executeQuery();

            while (rs.next()) {
                teorico = new Teorico();
                teorico.setIdTeorico(rs.getInt("idTeorico"));
                teorico.setTitulo(rs.getString("titulo"));
                teorico.setContenido(rs.getString("contenido"));
                teorico.setIdTema(rs.getInt("TEMAS_idTema"));
                teorico.setEstado(rs.getInt("estado"));
         
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("No se ha podido listar el teórico");

        } finally {
            this.cerrarConexion();
        }

        return teorico;

    }

}
