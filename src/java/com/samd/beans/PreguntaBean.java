package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Pregunta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PreguntaBean {
    
    private Pregunta pregunta;
    private Fachada fachada;

    public List<Pregunta> getListaPreguntas() throws PersistenciaExcepcion{
        return fachada.listarPreguntas();
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    private List<Pregunta> listaPreguntas;
    
    public PreguntaBean() {
        pregunta = new Pregunta();
        listaPreguntas = new ArrayList<>();
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
    
    public void eliminarPregunta() throws PersistenciaExcepcion{
        
        fachada.eliminarPregunta(this.pregunta);
    }
    
}
