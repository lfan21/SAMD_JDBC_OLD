package com.samd.beans;

import com.samd.dao.PreguntaDao;
import com.samd.dao.PreguntaDaoImp;
import com.samd.modelo.Pregunta;
import com.samd.vo.PreguntaVo;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PreguntaBean implements Serializable{
   
     private Pregunta pregunta = new Pregunta();
     private int idTema; 

    public PreguntaBean() {
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
    
    public void ingresarPregunta() throws Exception {
        
        PreguntaDao preguntaDao = new PreguntaDaoImp();
        PreguntaVo preguntaVo = new PreguntaVo();
        
        preguntaVo.setIdTema(this.idTema);
        preguntaVo.setPregunta(this.pregunta);
        
        
        preguntaDao.ingresarPregunta(preguntaVo);
        
    }
    
}
