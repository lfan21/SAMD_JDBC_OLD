
package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class CambiarContraseniaBean {

    private Usuario usuario;
    private Fachada fachada;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public CambiarContraseniaBean() {
        
        fachada = Fachada.getInstancia();
    }
    
    public void cambiarContrasenia() throws PersistenciaExcepcion{
        
        fachada.cambiarContrasenia(usuario);
        
        
    }
    
    
}
