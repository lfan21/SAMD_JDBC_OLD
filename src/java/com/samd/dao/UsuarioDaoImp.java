package com.samd.dao;

import com.samd.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImp extends Conexion implements UsuarioDao {

    @Override
    public List<Usuario> listarUsuarios() throws Exception {

        Statement st;
        ResultSet rs;
        String consulta;
        Usuario us;
        List<Usuario> lstUsuarios = null;

        try {
            this.conectar();
            consulta = "SELECT * FROM Usuarios";
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);
            lstUsuarios = new ArrayList<>();
            while (rs.next()) {
                us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCedula(rs.getInt("cedula"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setIdTipo(rs.getInt("idTipo"));
                us.setNroDocente(rs.getInt("nroDocente"));
                us.setEstado(rs.getInt("estado"));
                lstUsuarios.add(us);

            }
            rs.close();
            st.close();

        } catch (ClassNotFoundException | SQLException ex) {

            throw ex;

        } finally {
            this.cerrarConexion();
        }

        return lstUsuarios;
    }

    @Override
    public void ingresarUsuario(Usuario usuario) throws Exception {

        PreparedStatement ps;
        String consulta;

        try {
            this.conectar();
            consulta = "INSERT INTO USUARIOS (nombre, apellido, cedula, idTipo, nrodocente, estado) VALUES (?,?,?,?,?,?)";
            ps = this.getConn().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getCedula());
            ps.setInt(4, usuario.getIdTipo());
            ps.setInt(5, usuario.getNroDocente());
            ps.setInt(6, usuario.getEstado());

            ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarEstado(Usuario usuario) throws Exception {

        PreparedStatement ps;
        String consulta;
        try {
            this.conectar();
            consulta = "UPDATE Usuarios SET estado = ? WHERE cedula=?";
            ps = this.getConn().prepareStatement(consulta);

            ps.setInt(1, 0);
            ps.setInt(2, usuario.getCedula());
            ps.executeUpdate();

            ps.close();

        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex.getMessage());
            throw ex;

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarUsuario(Usuario usuario) throws Exception {

        PreparedStatement ps;
        String consulta;

        try {
            this.conectar();
            consulta = "UPDATE Usuarios SET nombre = ?, apellido = ? , cedula = ?, nrodocente = ?, estado = ? , idTipo = ? WHERE idUsuario = ?";
            ps = this.getConn().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getCedula());
            ps.setInt(4, usuario.getNroDocente());
            ps.setInt(5, usuario.getEstado());
            ps.setInt(6, usuario.getIdTipo());
            ps.setInt(7, usuario.getIdUsuario());

            ps.executeUpdate();

            ps.close();

        } catch (ClassNotFoundException | SQLException ex) {
        } finally {

            this.cerrarConexion();
        }
    }

    @Override
    public Usuario validarUsuario(Usuario usuario) throws SQLException {

        Usuario us = null;
        String consulta;
        PreparedStatement ps;
        ResultSet rs;

        try {
            this.conectar();
            consulta = "SELECT * FROM Usuarios WHERE cedula = ? AND contrasenia = ?";
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getContrasenia());

            rs = ps.executeQuery();

            while (rs.next()) {
                us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCedula(rs.getInt("cedula"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setIdTipo(rs.getInt("idTipo"));
                us.setNroDocente(rs.getInt("nroDocente"));
                us.setEstado(rs.getInt("estado"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            this.cerrarConexion();
        }

        return us;

    }

}
