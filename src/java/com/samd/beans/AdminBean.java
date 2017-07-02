package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImplementacion;
import com.samd.modelo.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped

public class AdminBean implements Serializable {

    private Usuarios usuario = new Usuarios();
    private List listaUsuarios = new ArrayList();

    public List getListaUsuarios() {
        UsuarioDao us = new UsuarioDaoImplementacion();
        return listaUsuarios = us.listarUsuarios();
    }
 
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public AdminBean() {
    }


    public void ingresarUsuario() {
        String encriptar = DigestUtils.sha1Hex(this.getUsuario().getContrasenia());
        this.getUsuario().setContrasenia(encriptar);
        UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
        usuarioDao.ingresarUsuario(getUsuario());

    }

    public void modificarUsuario() {
        UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
        usuarioDao.modificarUsuario(getUsuario());

    }

    public void eliminarUsuario() {
        UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
        usuarioDao.eliminarUsuario(getUsuario());

    }

    public Usuarios usuarioEnSesion() {

        return (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    }

}
