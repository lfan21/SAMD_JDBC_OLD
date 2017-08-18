/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author fernando
 */
@ManagedBean
@RequestScoped
public class teoricoControlador {

    /**
     * Creates a new instance of teoricoControlador
     */
    private Fachada fachada;
    private String result;
    private int teoricoNum;

    public int getTeoricoNum() {
        return teoricoNum;
    }

    public void setTeoricoNum(int teoricoNum) {
        this.teoricoNum = teoricoNum;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public teoricoControlador() throws PersistenciaExcepcion {
        
        fachada = Fachada.getInstancia();
        result = "";
        teoricoNum = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("teo"));
       
        Teorico teorico = fachada.retornarTeoricoPorId(teoricoNum);
        
        /*
        if(!fachada.temaDisponible(teorico)){
            //redirect to inicioAlumno.xhtml
        }
        */
        
        this.result += "<div class='titulo'>";
        /*
        if(fachada.anterior(teoricoNum)=!null){
            this.result += "<a href='./?teo='"+fachada.anterior(teoricoNum)+"' > anterior</a>";
        }
        */
        this.result += teorico.getTitulo();
        /*
        if(fachada.siguiente(teoricoNum)=!null){
            this.result += "<a href='./?teo='"+fachada.siguente(teoricoNum)+"' > anterior</a>";
        }
        */
        this.result += "</div>";
        this.result += "<div class='contenido'>"+teorico.getContenido()+"</div>";
    }
    
}
