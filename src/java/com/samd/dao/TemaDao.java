
package com.samd.dao;

import com.samd.modelo.Tema;
import java.util.List;


public interface TemaDao {
    
    public void ingresarTema (Tema tema) throws Exception;
    public List<Tema> cargarComboTema() throws Exception;
    
    
}
