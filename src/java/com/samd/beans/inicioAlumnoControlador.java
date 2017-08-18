package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class inicioAlumnoControlador {

 
    private Fachada fachada;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public inicioAlumnoControlador() throws PersistenciaExcepcion {
        fachada = Fachada.getInstancia();
        result = "";
        
        for(Tema t : fachada.listarTemas()){
            
            this.result += "<div class='tile'>";
            this.result += "<div class='titulo'>" + t.getNombre() + "</div>";
            this.result += "<div class='tile-contenido'>";
            this.result += "<div class='descripcion'>" + t.getDescripcion() + "</div>";
            this.result += "<ul>";
            for (Teorico teo : fachada.retornarTeoricosTema(t)) {
                //if(fachada.temaDisponible(teo)){
                if(true){
                    this.result += "<li><a href='teorico.xhtml?teo="+teo.getIdTeorico()+"' title='"+teo.getContenido()+"' >"+teo.getTitulo()+"</a></li>";
                } else {
                    this.result += "<li>"+teo.getTitulo()+"</li>";
                }
            }
            this.result += "</ul>";
            this.result += "</div>";
            this.result += "</div>";
        }
    }
    
}
