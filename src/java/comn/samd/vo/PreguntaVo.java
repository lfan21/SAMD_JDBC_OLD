
package comn.samd.vo;

import com.samd.modelo.Pregunta;
import java.io.Serializable;


public class PreguntaVo implements Serializable{

    public PreguntaVo() {
    }
    
    private int idTema;
    private Pregunta pregunta;
    
    

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
}
