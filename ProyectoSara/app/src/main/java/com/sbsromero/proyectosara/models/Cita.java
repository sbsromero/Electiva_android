package com.sbsromero.proyectosara.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by USERPC on 21/10/2017.
 */

public class Cita implements Serializable{
    public String nombreEstudiante;
    public String lineaAsesoria;
    public String dni;
    public String semestre;
    private List<Cita> citasAsignadas;

    public Cita(String nombreEstudiante, String dni, String lineaAsesoria,  String semestre) {
        this.nombreEstudiante = nombreEstudiante;
        this.dni = dni;
        this.lineaAsesoria = lineaAsesoria;
        this.semestre = semestre;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getLineaAsesoria() {
        return lineaAsesoria;
    }

    public void setLineaAsesoria(String lineaAsesoria) {
        this.lineaAsesoria = lineaAsesoria;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
