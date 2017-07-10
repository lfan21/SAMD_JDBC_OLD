
package com.samd.beans;

import com.samd.dao.UsuarioDao;
import com.samd.dao.UsuarioDaoImp;
import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped
public class LoginBean {

    Usuario usuario;
    private Fachada fachada = Fachada.getInstancia();

    public LoginBean() {
        
       this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String validarDatosUsuario() throws Exception {

//        String encriptar;
        String url = null;
       // encriptar = DigestUtils.md5Hex(this.usuario.getContrasenia());
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        Usuario us;

        //this.usuario.setContrasenia(encriptar);
        
        us = usuarioDao.validarUsuario(usuario);

        if (us != null) {
            //Si el usuario exite, lo guardo en sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);

            switch (us.getIdTipo()) {
                case 1:
                    url = "/Views/admoin/adminusuarios.xhtml";
                    break;

                case 2:
                    url = "/Views/docente/docente.xhtml";
                    break;

                case 3:
                    url = "/Views/alumno/alumno.xhtml";
                    break;

            }
        } else {
            url = "/Views/login.xhtml";

        }

        return url;
    }

}
