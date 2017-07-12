package com.samd.dao;

import com.samd.modelo.Pregunta;
import com.samd.vo.PreguntaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreguntaDaoImp extends Conexion implements PreguntaDao {

    @Override
    public List listarPreguntas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarPregunta(PreguntaVo preguntaVo) throws Exception {

        String consulta;
        PreparedStatement ps;
        Statement st;
        ResultSet rs;
        int maxId = 0;

        try {
            consulta = "INSERT INTO PREGUNTAS (respuestaCorrecta, pregunta, opcionRespuesta1, OpcionRespuesta2, OpcionRespuesta3, OpcionRespuesta4) VALUES (?,?,?,?,?,?)";

            this.conectar();
            ps = this.getConn().prepareStatement(consulta);

            ps.setInt(1, preguntaVo.getPregunta().getRespuestaCorrecta());
            ps.setString(2, preguntaVo.getPregunta().getPregunta());
            ps.setString(3, preguntaVo.getPregunta().getRespuesta1());
            ps.setString(4, preguntaVo.getPregunta().getRespuesta2());
            ps.setString(5, preguntaVo.getPregunta().getRespuesta3());
            ps.setString(6, preguntaVo.getPregunta().getRespuesta4());

            ps.executeUpdate();
            ps.close();

            consulta = "SELECT idPregunta FROM PREGUNTAS WHERE idPregunta=(select MAX(idPregunta) FROM PREGUNTAS)";
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {

                maxId = rs.getInt("idPregunta");
            }

            rs.close();

            consulta = "INSERT INTO TIENEN (TEMAS_idTema, PREGUNTAS_idPregunta) VALUES (?,?)";
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, preguntaVo.getIdTema());
            ps.setInt(2, maxId);

            ps.execute();
            ps.close();

        } catch (SQLException e) {

            throw e;

        } finally {
            this.cerrarConexion();

        }

    }

    @Override
    public void modificarPregunta(PreguntaVo preguntaVo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPregunta(PreguntaVo preguntaVo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
