
package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImplementacion;
import com.samd.modelo.Usuarios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped
public class LoginBean {

    Usuarios usuario;

    public LoginBean() {
        
       this.usuario = new Usuarios();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String validarDatosUsuario() {

        String url = null;
        String encriptar = DigestUtils.sha1Hex(this.usuario.getContrasenia());
        UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
        Usuarios us;

        this.usuario.setContrasenia(encriptar);
        
        us = usuarioDao.validarUsuario(usuario);

        if (us != null) {
            //Si el usuario exite, lo guardo en sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);

            switch (us.getIdTipo()) {
                case 1:
                    url = "/Views/admin.xhtml";
                    break;

                case 2:
                    url = "/Views/docente.xhtml";
                    break;

                case 3:
                    url = "/Views/alumno.xhtml";
                    break;

            }
        } else {
            url = "/Views/login.xhtml";

        }

        return url;
    }

}
