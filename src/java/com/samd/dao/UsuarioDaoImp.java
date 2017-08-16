package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.TipoUsuario;
import com.samd.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImp extends Conexion implements UsuarioDao {

    @Override
    public List<Usuario> listarUsuarios() throws PersistenciaExcepcion {

        Statement st;
        ResultSet rs;
        String consulta;
        Usuario us;
        List<Usuario> lstUsuarios = null;

        try {
            this.conectar();
            consulta = "SELECT * FROM Usuarios where estado=1";
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
                us.setIdTipo(rs.getInt("TIPO_USUARIO_idTipo"));
                us.setNroDocente(rs.getInt("nroDocente"));
                us.setEstado(rs.getInt("estado"));
                us.setCorreoElectronico(rs.getString("correoElectronico"));
                lstUsuarios.add(us);

            }
            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error");

        } finally {

            this.cerrarConexion();
        }

        return lstUsuarios;
    }

    @Override
    public void ingresarUsuario(Usuario usuario) throws PersistenciaExcepcion {

        PreparedStatement ps;
        String consulta;

        try {
            this.conectar();
            consulta = "INSERT INTO USUARIOS (nombre, apellido, cedula, correoElectronico, TIPO_USUARIO_idTipo, nrodocente) VALUES (?,?,?,?,?,?)";
            ps = this.getConn().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getCedula());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setInt(5, usuario.getIdTipo());
            ps.setInt(6, usuario.getNroDocente());

            //    if(ps.executeUpdate() == 0)
            //ps.getGeneratedKeys()
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Ha ocurrido un error al ingresar el Usuario");
        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws PersistenciaExcepcion {

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

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al eliminar el usuario");

        } finally {
            this.cerrarConexion();
        }

    }

    @Override
    public void modificarUsuario(Usuario usuario) throws PersistenciaExcepcion {

        PreparedStatement ps;
        String consulta;

        try {
            this.conectar();
            consulta = "UPDATE Usuarios SET nombre = ?, apellido = ? , cedula = ?, correoElectronico = ?, nrodocente = ?, estado = ? , TIPO_USUARIO_idTipo = ? WHERE idUsuario = ?";
            ps = this.getConn().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getCedula());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setInt(5, usuario.getNroDocente());
            ps.setInt(6, usuario.getEstado());
            ps.setInt(7, usuario.getIdTipo());
            ps.setInt(8, usuario.getIdUsuario());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al modificar el usuario");
        } finally {

            this.cerrarConexion();
        }
    }

    
    //Valida cedula y contraseña ingresados por el usuario, si coinicide con la BD devuelve todos los datos del usuario.
    @Override
    public Usuario validarUsuario(Usuario usuario) throws PersistenciaExcepcion {

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
                us.setIdTipo(rs.getInt("TIPO_USUARIO_idTipo"));
                us.setNroDocente(rs.getInt("nroDocente"));
                us.setEstado(rs.getInt("estado"));
                us.setCorreoElectronico(rs.getString("correoElectronico"));
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Ha ocurrido un error al intentar validar el usuario");

        } finally {
            this.cerrarConexion();
        }

        return us;

    }

    @Override
    public List<TipoUsuario> cargarComboTipoUsuario() throws PersistenciaExcepcion {

        List<TipoUsuario> listTipoUsuario = null;
        TipoUsuario tu;
        String consulta;
        Statement st;
        ResultSet rs;

        try {
            this.conectar();
            consulta = "SELECT * FROM TIPO_USUARIO";
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);
            listTipoUsuario = new ArrayList<>();
            while (rs.next()) {
                tu = new TipoUsuario();
                tu.setIdTipoUsuario(rs.getInt("idTipo"));
                tu.setDescripcion(rs.getString("descripcion"));
                listTipoUsuario.add(tu);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al cargar el combo");

        } finally {
            this.cerrarConexion();
        }

        return listTipoUsuario;
    }

    //Valida si la la cedula ingresada existe y devuelve los datos para esa cedula
    @Override
    public Usuario existeUsuario(Usuario usuario) throws PersistenciaExcepcion {
        Usuario us = null;
        String consulta;
        boolean existe = false;
        PreparedStatement ps;
        ResultSet rs;

        try {
            this.conectar();
            consulta = "SELECT cedula FROM USUARIOS WHERE CEDULA = ?";
            ps = this.getConn().prepareStatement(consulta);
            ps.setInt(1, usuario.getCedula());
            rs = ps.executeQuery();

            while (rs.next()) {

            }

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error en la conexión");

        } finally {
            this.cerrarConexion();
        }

        return us;

    }

    @Override
    public void cambiarContrasenia(Usuario usuario) throws PersistenciaExcepcion {

        String consulta;
        PreparedStatement ps;

        try {
            this.conectar();
            consulta = "UPDATE USUARIOS SET contrasenia = ? WHERE cedula = ?";

            ps = this.getConn().prepareStatement(consulta);

            ps.setString(1, usuario.getContrasenia());
            ps.setInt(2, usuario.getCedula());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new PersistenciaExcepcion("Ha ocurrido un error al modificar la contraseña");

        } finally {
            this.cerrarConexion();
        }
    }

   
    @Override
    public Usuario obtenerUsuario(int cedula) throws PersistenciaExcepcion {

        Statement st;
        ResultSet rs;
        String consulta;
        Usuario us = null;

        try {
            this.conectar();
            consulta = "SELECT * FROM Usuarios where cedula = cedula";
            st = this.getConn().createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCedula(rs.getInt("cedula"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setIdTipo(rs.getInt("TIPO_USUARIO_idTipo"));
                us.setNroDocente(rs.getInt("nroDocente"));
                us.setEstado(rs.getInt("estado"));
                us.setCorreoElectronico(rs.getString("correoElectronico"));

            }
            rs.close();
            st.close();

        } catch (SQLException ex) {

            throw new PersistenciaExcepcion("Ha ocurrido un error");

        } finally {

            this.cerrarConexion();
        }

        return us;

    }

}
