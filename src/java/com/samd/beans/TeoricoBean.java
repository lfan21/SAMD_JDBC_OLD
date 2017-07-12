package com.samd.beans;

import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class TeoricoBean {

    private Fachada fachada;
    private List<SelectItem> listaTipoTema;
    private Teorico teorico = new Teorico();

    public Teorico getTeorico() {
        return teorico;
    }

    public void setTeorico(Teorico teorico) {
        this.teorico = teorico;
    }

    public void setListaTipoTema(List<SelectItem> listaTipoTema) {
        this.listaTipoTema = listaTipoTema;
    }

    public TeoricoBean() {

        fachada = Fachada.getInstancia();

    }

    public List<SelectItem> getListaTipoTema() throws Exception {
        this.listaTipoTema = new ArrayList<>();
        List<Tema> aux = fachada.cargarComboTema();

        listaTipoTema.clear();

        for (Tema tt : aux) {
            SelectItem tipoTemaItem = new SelectItem(tt.getIdTema(), tt.getNombre());
            this.listaTipoTema.add(tipoTemaItem);
        }
        return listaTipoTema;
    }

    public void ingresarTeorico() throws Exception {
        fachada.ingresarTeorico(this.teorico);

    }

}
