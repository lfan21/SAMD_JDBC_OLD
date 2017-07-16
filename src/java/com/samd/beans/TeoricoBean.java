package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Teorico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TeoricoBean {

    private Fachada fachada;
    private List<Teorico> listaTeoricos;
    private Teorico teorico;

    public List<Teorico> getListaTeoricos() throws PersistenciaExcepcion {
        return fachada.listarTeorico();
    }

    public void setListaTeoricos(List<Teorico> listaTeoricos) {
        this.listaTeoricos = listaTeoricos;
    }
    
    

    public Teorico getTeorico() {
        return teorico;
    }

    public void setTeorico(Teorico teorico) {
        this.teorico = teorico;
    }

    public TeoricoBean() {

        fachada = Fachada.getInstancia();
        teorico = new Teorico();
        listaTeoricos = new ArrayList<>();

    }

    public void ingresarTeorico() throws PersistenciaExcepcion {
        fachada.ingresarTeorico(this.teorico);

    }

}
