
package com.samd.excepciones;

public class PersistenciaExcepcion extends Exception{
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PersistenciaExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
