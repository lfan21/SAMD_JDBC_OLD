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
    private List<Teorico> teoricoFiltrado;

    public List<Teorico> getTeoricoFiltrado() {
        return teoricoFiltrado;
    }

    public void setTeoricoFiltrado(List<Teorico> teoricoFiltrado) {
        this.teoricoFiltrado = teoricoFiltrado;
    }

    public List<Teorico> getListaTeoricos() throws PersistenciaExcepcion {
        return fachada.listarTeoricos();
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
    }

    public void ingresarTeorico() throws PersistenciaExcepcion {
        fachada.ingresarTeorico(this.teorico);

    }

    public void modificarTeorico() throws PersistenciaExcepcion {
        fachada.modificarTeorico(this.teorico);

    }

    public void eliminarTeorico() throws PersistenciaExcepcion {
        fachada.eliminarTeorico(this.teorico);

    }

}
