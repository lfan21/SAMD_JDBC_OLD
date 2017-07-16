
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Tema;
import java.util.List;


public interface TemaDao {
    
    public void ingresarTema (Tema tema) throws PersistenciaExcepcion;
    
    public List<Tema> cargarComboTema() throws PersistenciaExcepcion;
    
    public List<Tema> listarTemas() throws PersistenciaExcepcion;
    
    public void eliminarTema (Tema tema) throws PersistenciaExcepcion;
    
    public void modificarTema (Tema tema) throws PersistenciaExcepcion;
    
    
    
}
