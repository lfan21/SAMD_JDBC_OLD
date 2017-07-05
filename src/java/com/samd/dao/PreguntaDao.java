
package com.samd.dao;

import com.samd.modelo.Pregunta;
import java.util.List;


public interface PreguntaDao {
    
    public List listarPreguntas();
    
    public void ingresarPregunta(Pregunta pregunta);
    
    public void modificarPregunta(Pregunta pregunta);
    
    public void eliminarPregunta (Pregunta pregunta);
    
    
    
    
}
