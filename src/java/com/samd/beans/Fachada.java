
package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Fachada {
      
    private static Fachada instancia = null;
    private List <Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> getListaUsuarios() throws Exception {
        
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        return listaUsuarios = usuarioDao.listarUsuarios();
        
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public Fachada() {
    }

    public static Fachada getInstancia() {
        
        if (instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
}
