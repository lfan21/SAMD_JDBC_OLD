package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OlvidoContrasenia {

    private int cedula;
    private String correo;
    private Fachada fachada;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public OlvidoContrasenia() {

        fachada = Fachada.getInstancia();
    }

    public void actualizarContraseniaCorreo() throws PersistenciaExcepcion {

        Usuario usuarioAux;
        usuarioAux = fachada.obtenerUsuario(cedula);

        if (usuarioAux != null) {
            if (correo.equals(usuarioAux.getCorreoElectronico())) {
                fachada.olvidoContrasenia(usuarioAux);
            }
        }

    }

}
