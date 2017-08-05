
package com.samd.utiles;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter ("tipoUsuarioConversor")
public class TipoUsuarioConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String tipoUsuario = "";
        
        switch (String.valueOf(o)){
            case "1":
                tipoUsuario = "Administrador";
                break;
            
            case "2":
                
                tipoUsuario="Docente";
                break;
            case "3":
                tipoUsuario="Alumno";
                break;            
        }
        
        return tipoUsuario;
        
    }
    
}
