package com.samd.utiles;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("estadoConversor")
public class EstadoUsuarioConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String estado = "";

        if (o != null) {

            estado = (String) String.valueOf(o);

            switch (estado) {

                case "0":
                    estado = "Inactivo";
                    break;

                case "1":
                    estado = "Activo";
                    break;

            }

        }

        return estado;

    }

}
