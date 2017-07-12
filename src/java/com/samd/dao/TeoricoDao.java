
package com.samd.dao;

import com.samd.modelo.Teorico;


public interface TeoricoDao {
    
    public void ingresarTeorico (Teorico teorico) throws Exception;
    
    public void modificarTeorico (Teorico teorico);
    
    public void eliminarTeorico (Teorico teorico);
    
    
    
}
