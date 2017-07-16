package com.samd.modelo;

public class Tema {

    private int idTema;
    private String nombre;
    private String descripcion;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Tema() {
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tema(int idTema, String nombre, String descripcion, int estado) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }






    

}
