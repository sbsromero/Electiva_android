package com.sbsromero.proyectosaraadministradores.models;

import java.io.Serializable;

public class Monitor implements Serializable {

    private String cedula;
    private String nombre;
    private String urlFoto;
    private String username;
    private String numTelefono;
    private String semestre;
    private String lineaMonitoria;
    private String lugar;


    public Monitor(String nombre, String semestre, String lineaMonitoria) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.lineaMonitoria = lineaMonitoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLineaMonitoria() {
        return lineaMonitoria;
    }

    public void setLineaMonitoria(String lineaMonitoria) {
        this.lineaMonitoria = lineaMonitoria;
    }
}
