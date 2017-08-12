package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Usuario;
import java.util.List;

public interface UsuarioDao {

    public List<Usuario> listarUsuarios() throws PersistenciaExcepcion;

    public void ingresarUsuario(Usuario usuario) throws PersistenciaExcepcion;

    public void eliminarUsuario(Usuario usuario) throws PersistenciaExcepcion;

    public void modificarUsuario(Usuario usuario) throws PersistenciaExcepcion;
    
    public Usuario obtenerUsuario(int cedula) throws PersistenciaExcepcion;

    public Usuario validarUsuario(Usuario usuario) throws PersistenciaExcepcion;

    public List cargarComboTipoUsuario() throws PersistenciaExcepcion;
    
    public Usuario existeUsuario(Usuario usuario) throws PersistenciaExcepcion;
    
    public void cambiarContrasenia (Usuario usuario) throws PersistenciaExcepcion; 
    
}
