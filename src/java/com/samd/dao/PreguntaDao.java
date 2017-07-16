
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Pregunta;
import java.util.List;


public interface PreguntaDao {
    
    public List<Pregunta> listarPreguntas() throws PersistenciaExcepcion;
   
    public void ingresarPregunta(Pregunta pregunta) throws PersistenciaExcepcion;
    
    public void modificarPregunta(Pregunta pregunta) throws PersistenciaExcepcion;
    
    public void eliminarPregunta (Pregunta pregunta)throws PersistenciaExcepcion;
    
    
    
    
}
