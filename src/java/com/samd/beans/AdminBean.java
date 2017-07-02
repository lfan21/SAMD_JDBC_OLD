package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.modelo.Usuario;

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

    private Usuario usuario = new Usuario();
    private List<Usuario> listaUsuarios = new ArrayList();

    public List getListaUsuarios() throws Exception {
        UsuarioDao us = new UsuarioDaoImp();
        return listaUsuarios = us.listarUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AdminBean() {
    }

    public void ingresarUsuario() throws Exception {
        String encriptar = DigestUtils.sha1Hex(this.getUsuario().getContrasenia());
        this.getUsuario().setContrasenia(encriptar);
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.ingresarUsuario(usuario);

    }

    public void modificarUsuario() throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.modificarUsuario(usuario);

    }

    public void eliminarUsuario() throws Exception {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.eliminarUsuario(usuario);

    }

    public Usuario usuarioEnSesion() {

        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    }


}
