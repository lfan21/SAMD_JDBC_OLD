
package com.samd.dao;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.util.List;


public interface TeoricoDao {
    
    
    public List<Teorico> listarTeoricos () throws PersistenciaExcepcion;
    
    public void ingresarTeorico (Teorico teorico) throws PersistenciaExcepcion;
    
    public void modificarTeorico (Teorico teorico) throws PersistenciaExcepcion;
    
    public void eliminarTeorico (Teorico teorico) throws PersistenciaExcepcion;  
    
    public List<Teorico> retornarTeoricosTema (Tema tema) throws PersistenciaExcepcion;
    
    public Teorico retornarTeoricoPorId (int numero) throws PersistenciaExcepcion;
    
}
