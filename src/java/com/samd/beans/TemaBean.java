package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class TemaBean {

    private final Fachada fachada;
    private Tema tema;
    private List<SelectItem> listaComboTipoTema;

    public List<SelectItem> getListaComboTipoTema() throws PersistenciaExcepcion {

        List<Tema> listaAuxTipoTema = new ArrayList<>();
        this.listaComboTipoTema.clear();

        listaAuxTipoTema = fachada.cargarComboTema();
        

        for (Tema tema : listaAuxTipoTema) {

            SelectItem tipoTemaItem = new SelectItem(tema.getIdTema(), tema.getNombre());
            this.listaComboTipoTema.add(tipoTemaItem);
        }

        return listaComboTipoTema;
    }

    public void setListaComboTipoTema(List<SelectItem> listaComboTipoTema) {
        this.listaComboTipoTema = listaComboTipoTema;
    }
    

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public TemaBean() {
        fachada = Fachada.getInstancia();
        tema = new Tema();
        listaComboTipoTema = new ArrayList<>();
    }

    public void ingresartTema() throws Exception {

        fachada.ingresarTema(this.tema);

    }

}
