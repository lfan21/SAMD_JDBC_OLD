
package com.samd.excepciones;


public class UsuarioExcepcion extends Exception {
    
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public UsuarioExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
