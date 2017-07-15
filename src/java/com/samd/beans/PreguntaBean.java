package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Pregunta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PreguntaBean {
    
    private Pregunta pregunta;
    private Fachada fachada;
    
    public PreguntaBean() {
        pregunta = new Pregunta();
        fachada = Fachada.getInstancia();
    }
    
    public Pregunta getPregunta() {
        return pregunta;
    }
    
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    public void ingresarPregunta() throws PersistenciaExcepcion {
        
        fachada.ingresarPregunta(this.pregunta);
        
    }
    
}
