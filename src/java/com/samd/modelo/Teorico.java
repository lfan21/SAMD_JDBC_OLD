package com.samd.modelo;

public class Teorico {

    private int idTeorico;
    private String titulo;
    private String contenido;
    private int idTema;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdTeorico() {
        return idTeorico;
    }

    public void setIdTeorico(int idTeorico) {
        this.idTeorico = idTeorico;
    }
    

    public Teorico() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }
    
    

}
