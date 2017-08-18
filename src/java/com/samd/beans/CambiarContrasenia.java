package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CambiarContrasenia {

    private String contraseniaActual;
    private String nuevaContrasenia;
    private String confirmarNuevaContrasenia;
    private Fachada fachada;

    public CambiarContrasenia() {

        fachada = Fachada.getInstancia();
    }

    public String getContraseniaActual() {
        return contraseniaActual;
    }

    public void setContraseniaActual(String contraseniaActual) {
        this.contraseniaActual = contraseniaActual;
    }

    public String getNuevaContrasenia() {
        return nuevaContrasenia;
    }

    public void setNuevaContrasenia(String nuevaContrasenia) {
        this.nuevaContrasenia = nuevaContrasenia;
    }

    public String getConfirmarNuevaContrasenia() {
        return confirmarNuevaContrasenia;
    }

    public void setConfirmarNuevaContrasenia(String confirmarNuevaContrasenia) {
        this.confirmarNuevaContrasenia = confirmarNuevaContrasenia;
    }

    public void cambiarContrasenia() throws PersistenciaExcepcion {

        Usuario usuario = new Usuario();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        if (usuario != null) {
            usuario.setContrasenia(nuevaContrasenia);
            fachada.cambiarContrasenia(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña Actualizada Correctamente",null));           
        }
    }

}
