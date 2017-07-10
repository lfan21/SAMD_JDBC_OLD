
package com.samd.modelo;

import java.io.Serializable;

public class TipoUsuario implements Serializable {
    
    private int idTipoUsuario;
    private String descripcion;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoUsuario() {
    }
    
    
    
}
