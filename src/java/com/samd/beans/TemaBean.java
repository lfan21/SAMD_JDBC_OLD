package com.samd.beans;

import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TemaBean {
    
    private Fachada fachada;
    private Tema tema;

    
    public Tema getTema() {
        return tema;
    }
    
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public TemaBean() {
        fachada = Fachada.getInstancia();
        tema = new Tema();
    }
    
    public void ingresartTema() throws Exception {
        
        fachada.ingresarTema(this.tema);
        
    }
    
    
    
}
