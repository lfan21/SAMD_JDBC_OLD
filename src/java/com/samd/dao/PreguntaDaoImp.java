package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Pregunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PreguntaDaoImp extends Conexion implements PreguntaDao {

    @Override
    public List listarPreguntas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void modificarPregunta(Pregunta pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPregunta(Pregunta pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
