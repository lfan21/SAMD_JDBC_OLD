
package com.samd.dao;

import com.samd.vo.PreguntaVo;
import java.util.List;


public interface PreguntaDao {
    
    public List listarPreguntas();
    
    public void ingresarPregunta(PreguntaVo preguntaVo) throws Exception;
    
    public void modificarPregunta(PreguntaVo preguntaVo);
    
    public void eliminarPregunta (PreguntaVo preguntaVo);
    
    
    
    
}
