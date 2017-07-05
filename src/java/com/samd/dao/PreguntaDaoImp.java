package com.samd.dao;

import com.samd.modelo.Pregunta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreguntaDaoImp extends Conexion implements PreguntaDao {

    @Override
    public List listarPreguntas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarPregunta(Pregunta pregunta) {

        String consulta;
        PreparedStatement ps;

        try {
            consulta = "INSERT INTO PREGUNTAS (respuestaCorrecta, pregunta, opcionRespuesta1, OpcionRespuesta2, OpcionRespuesta3, OpcionRespuesta4) VALUES (?,?,?,?,?,?)";

            this.conectar();
            ps = this.getConn().prepareStatement(consulta);

            ps.setInt(1, pregunta.getRespuestaCorrecta());
            ps.setString(2, pregunta.getPregunta());
            ps.setString(4, pregunta.getRespuesta1());
            ps.setString(5, pregunta.getRespuesta2());
            ps.setString(6, pregunta.getRespuesta3());
            ps.setString(7, pregunta.getRespuesta4());

            ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PreguntaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }

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
