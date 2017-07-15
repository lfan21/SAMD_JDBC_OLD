
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Tema;
import java.util.List;


public interface TemaDao {
    
    public void ingresarTema (Tema tema) throws PersistenciaExcepcion;
    public List<Tema> cargarComboTema() throws PersistenciaExcepcion;
    
    
}
