
package com.samd.dao;

import com.samd.modelo.Usuario;
import java.util.List;

public interface UsuarioDao {
    
    public List<Usuario> listarUsuarios() throws Exception;
    
    public void ingresarUsuario(Usuario usuario) throws Exception;
    
    public void eliminarUsuario(Usuario usuario) throws Exception;
    
    public void modificarUsuario (Usuario usuario) throws Exception;
    
    public Usuario validarUsuario (Usuario usuario) throws Exception;
    

   
    
    
    
    
}
