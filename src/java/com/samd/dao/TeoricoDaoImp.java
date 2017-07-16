package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTeorico(Teorico teorico) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teorico> listarTeorico() throws PersistenciaExcepcion {

        List<Teorico> retorno = null;
        ResultSet rs;
        Statement st;

        try {
            String consulta = "SELECT * FROM Teorico";
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

        } finally{
            this.cerrarConexion();
        }

        return retorno;

    }

}
