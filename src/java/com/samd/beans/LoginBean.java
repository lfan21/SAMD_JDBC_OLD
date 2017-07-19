package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped
public class LoginBean {

    Usuario usuario = new Usuario();
    private final Fachada fachada = Fachada.getInstancia();

    public LoginBean() {

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String validarDatosUsuario() throws PersistenciaExcepcion {

//        String encriptar;
        String url = null;
        // encriptar = DigestUtils.md5Hex(this.usuario.getContrasenia());
        Usuario us = fachada.validarUsuario(usuario);

        if (us != null) {
            //Si el usuario exite, lo guardo en sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);

            switch (us.getIdTipo()) {
                case 1:
                    url = "/Views/admin/inicioadmin.xhtml";
                    break;
                case 2:
                    url = "/Views/docente/iniciodocente.xhtml";
                    break;
                case 3:
                    url = "/Views/alumno/inicioalumno.xhtml";
                    break;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario y/o Contraseña incorrectos", "Vuelva a intentar"));
            url = "/Views/login.xhtml";
        }

        return url;
    }

}
