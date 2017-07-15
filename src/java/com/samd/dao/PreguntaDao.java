
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Pregunta;
import java.util.List;


public interface PreguntaDao {
    
    public List listarPreguntas();
   
    public void ingresarPregunta(Pregunta pregunta) throws PersistenciaExcepcion;
    
    public void modificarPregunta(Pregunta pregunta);
    
    public void eliminarPregunta (Pregunta pregunta);
    
    
    
    
}
