package com.samd.dao;

import com.samd.modelo.Tema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TemaDaoImp extends Conexion implements TemaDao {

    @Override
    public void ingresarTema(Tema tema) throws Exception {

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
            this.cerrarConexion();

        } catch (SQLException ex) {

            throw ex;
        } finally {
        }
    }

    @Override
    public List<Tema> cargarComboTema() throws Exception {

        List<Tema> listaTemas;
        String consulta;
        ResultSet rs = null;
        Statement st = null;

        try {
            consulta = "SELECT idTema, nombre FROM TEMAS";
            this.conectar();

            rs = st.executeQuery(consulta);

            listaTemas = new ArrayList<>();

            while (rs.next()) {
                Tema tema = new Tema();
                tema.setIdTema(rs.getInt("idTema"));
                tema.setNombre(rs.getString("nombre"));

                listaTemas.add(tema);

            }

            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw ex;

        } finally {

            this.cerrarConexion();
        }

        return listaTemas;

    }
}
