
package com.samd.dao;

import com.samd.modelo.Usuarios;
import java.util.List;

public interface UsuarioDao {
    
    public List listarUsuarios();
    
    public void ingresarUsuario(Usuarios usuario);
    
    public void eliminarUsuario(Usuarios usuario);
    
    public void modificarUsuario (Usuarios usuario);
    
    public Usuarios validarUsuario (Usuarios usuario);
    
    
    
    
}
