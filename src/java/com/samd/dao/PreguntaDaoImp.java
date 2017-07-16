package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Pregunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PreguntaDaoImp extends Conexion implements PreguntaDao {

    @Override
    public List<Pregunta> listarPreguntas() throws PersistenciaExcepcion {

        List<Pregunta> retorno = null;
        ResultSet rs;
        Statement st;
        String consulta;

        try {
            this.conectar();
            consulta = "SELECT * FROM Preguntas WHERE estado = 1";
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);
            
            retorno = new ArrayList<>();
            
            while (rs.next()) {
                Pregunta pregunta= new Pregunta();
                pregunta.setIdPregunta(rs.getInt("idPregunta"));
                pregunta.setIdTema(rs.getInt("TEMAS_idTema"));
                pregunta.setPregunta(rs.getString("pregunta"));
                pregunta.setRespuesta1(rs.getString("opcionRespuesta1"));
                pregunta.setRespuesta2(rs.getString("opcionRespuesta2"));
                pregunta.setRespuesta3(rs.getString("opcionRespuesta3"));
                pregunta.setRespuesta4(rs.getString("opcionRespuesta4"));
                pregunta.setRespuestaCorrecta(rs.getInt("respuestaCorrecta"));                
                retorno.add(pregunta);
                             
            }
            
            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al listar las preguntas");
        } finally {
            this.cerrarConexion();
        }

        return retorno;

    }

    @Override
    public void ingresarPregunta(Pregunta pregunta) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            consulta = "INSERT INTO PREGUNTAS (respuestaCorrecta, pregunta, opcionRespuesta1, OpcionRespuesta2, OpcionRespuesta3, OpcionRespuesta4, TEMAS_idTema) VALUES (?,?,?,?,?,?,?)";

            this.conectar();
            ps = this.getConn().prepareStatement(consulta);

            ps.setInt(1, pregunta.getRespuestaCorrecta());
            ps.setString(2, pregunta.getPregunta());
            ps.setString(3, pregunta.getRespuesta1());
            ps.setString(4, pregunta.getRespuesta2());
            ps.setString(5, pregunta.getRespuesta3());
            ps.setString(6, pregunta.getRespuesta4());
            ps.setInt(7, pregunta.getIdTema());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al ingresar la pregunta");

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarPregunta(Pregunta pregunta) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPregunta(Pregunta pregunta) throws PersistenciaExcepcion {
        
        String consulta;
        PreparedStatement ps;
        
        try {
            consulta = "UPDATE PREGUNTAS SET estado = 0 WHERE idPregunta = ?";
            this.conectar();
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1,pregunta.getIdPregunta());
                     
            ps.executeUpdate();
            ps.close();
                              
        } catch (SQLException e) {
            
            throw new PersistenciaExcepcion("Ha ocurrido un error al eliminar la pregunta");
        } finally {
            this.cerrarConexion();
        }

    }

}
