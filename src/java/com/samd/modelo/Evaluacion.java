
package com.samd.modelo;


public class Evaluacion {
    
    private int idEvaluacionM;
    private int minimoAprobacion;
    private int puntajeObtenido;

    public int getMinimoAprobacion() {
        return minimoAprobacion;
    }

    public void setMinimoAprobacion(int minimoAprobacion) {
        this.minimoAprobacion = minimoAprobacion;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public Evaluacion() {
    }

    public int getIdEvaluacionM() {
        return idEvaluacionM;
    }

    public void setIdEvaluacionM(int idEvaluacionM) {
        this.idEvaluacionM = idEvaluacionM;
    }
    
    
    
    
}
