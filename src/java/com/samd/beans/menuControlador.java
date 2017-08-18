package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class menuControlador {

    Fachada fachada;

    public menuControlador() {

        fachada = Fachada.getInstancia();
    }
    
    //Ver como solucionar la generación del menu dinamicamente.

    public String menuTeoricoAlumno() throws PersistenciaExcepcion {

        String menu = "";

        for (Tema t : fachada.listarTemas()) {

            menu += "<p: menuitem value = ";
            menu += t.getNombre();
            menu += "icon = 'ui-icon-document'";
            menu += "url=";
            menu += "teorico.xhtml?teo=";
            menu += "/>";

        }

        return menu;
    }

}
