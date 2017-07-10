package com.samd.fachada;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.modelo.TipoUsuario;
import com.samd.modelo.Usuario;
import java.io.Serializable;
import java.util.List;

public class Fachada implements Serializable {

    private static Fachada instancia = null;

    public Fachada() {
    }

    public static Fachada getInstancia() {

        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

//    *****************************Metodos de Administracion de Usuarios**********************************
    
    public List<Usuario> getListaUsuarios() throws Exception {

        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.listarUsuarios();

    }

    public void ingresarUsuario(Usuario usuario) throws Exception {

        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.ingresarUsuario(usuario);

    }

    public void eliminarUsuario(Usuario usuario) throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.eliminarUsuario(usuario);
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.modificarUsuario(usuario);
    }
    
    public List<TipoUsuario> cargarCompoTipoUsuario() throws Exception{
        
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return usuarioDao.cargarComboTipoUsuario();
    }
    
//    *******************************Fin de Administracion de Usuarios**************************************

}
