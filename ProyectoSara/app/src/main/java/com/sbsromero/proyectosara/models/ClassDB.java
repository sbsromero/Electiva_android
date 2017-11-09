package com.sbsromero.proyectosara.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USERPC on 23/10/2017.
 */

public class ClassDB {

    List<Cita> citasAsignadas;
    List<Cita> citasPendientes;
    public static ClassDB classDB;

    public ClassDB() {
        citasAsignadas = new ArrayList<>();
        citasPendientes = new ArrayList<>();
    }

    public static ClassDB getInstance(){
        if(classDB == null){
            classDB = new ClassDB();
        }
        return classDB;
    }
    public void agregarCita(Cita cita){
        citasAsignadas.add(cita);
    }

    public void removeCitaAsignada(int position){
        citasAsignadas.remove(position);
    }

    public void removeCitaPendiente(int position){
        citasPendientes.remove(position);
    }

    public List<Cita> getCitasPendientes() {
        return citasPendientes;
    }

    public void setCitasPendientes(List<Cita> citasPendientes) {
        this.citasPendientes = citasPendientes;
    }

    public List<Cita> getCitasAsignadas() {
        return citasAsignadas;
    }

    public void setCitasAsignadas(List<Cita> citasAsignadas) {
        this.citasAsignadas = citasAsignadas;
    }
}
