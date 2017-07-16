
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Teorico;
import java.util.List;


public interface TeoricoDao {
    
    
    public List<Teorico> listarTeorico () throws PersistenciaExcepcion;
    
    public void ingresarTeorico (Teorico teorico) throws PersistenciaExcepcion;
    
    public void modificarTeorico (Teorico teorico) throws PersistenciaExcepcion;
    
    public void eliminarTeorico (Teorico teorico) throws PersistenciaExcepcion;  
    
}
