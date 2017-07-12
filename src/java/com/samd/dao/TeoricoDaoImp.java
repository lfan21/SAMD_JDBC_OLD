package com.samd.dao;

import com.samd.modelo.Teorico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeoricoDaoImp extends Conexion implements TeoricoDao {

    @Override
    public void ingresarTeorico(Teorico teorico) throws Exception {

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
            throw ex;
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarTeorico(Teorico teorico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTeorico(Teorico teorico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
