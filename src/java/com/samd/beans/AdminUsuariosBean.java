package com.samd.beans;

import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class AdminUsuariosBean implements Serializable {

    private List listaUsuarios = new ArrayList();
    private List listaUsuariosFiltrados = new ArrayList();

    public List getListaUsuariosFiltrados() {
        return listaUsuariosFiltrados;
    }

    public void setListaUsuariosFiltrados(List listaUsuariosFiltrados) {
        this.listaUsuariosFiltrados = listaUsuariosFiltrados;
    }
    private Usuario usuario = new Usuario();
    private final Fachada fachada = Fachada.getInstancia();
    
     public AdminUsuariosBean() {
    }
     
    public List getListaUsuarios() throws Exception {
        return fachada.getListaUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void ingresarUsuario() throws Exception{
        fachada.ingresarUsuario(usuario);
    }
    
    public void eliminarUsuario() throws Exception{
        fachada.eliminarUsuario(usuario);
    }
    
    public void modificarUsuario() throws Exception{
        fachada.modificarUsuario(usuario);
    }

   

}
