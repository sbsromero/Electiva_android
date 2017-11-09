package com.sbsromero.proyectosaraadministradores.Util;

import com.sbsromero.proyectosaraadministradores.models.Monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumset on 27/10/17.
 */

public class ClassDB {

    public static List<Monitor> getMonitores(){
        return new ArrayList<Monitor>(){{
            add(new Monitor("Sebastian Romero","9 semestre","backtracking"));
            add(new Monitor("Pepito Martinez","9 semestre","algoritmos"));
            add(new Monitor("Jaunito Perez","4 semestre","estructuras"));
            add(new Monitor("Daniela Mera","2 semestre","paradigma"));
            add(new Monitor("Carlos Fernandez","3 semestre","paradigma"));
            add(new Monitor("Viviana lopez","3 semestre","analisis"));
            add(new Monitor("tatiana hurtado","3 semestre","poo"));
            add(new Monitor("Carlos Fernandez","3 semestre","analisis 2"));
            add(new Monitor("Sebastian Romero","9 semestre","backtracking"));
            add(new Monitor("Pepito Martinez","9 semestre","algoritmos"));
            add(new Monitor("Jaunito Perez","4 semestre","estructuras"));
            add(new Monitor("Daniela Mera","2 semestre","paradigma"));
            add(new Monitor("Carlos Fernandez","3 semestre","paradigma"));
            add(new Monitor("Viviana lopez","3 semestre","analisis"));
            add(new Monitor("tatiana hurtado","3 semestre","poo"));
            add(new Monitor("Carlos Fernandez","3 semestre","analisis 2"));
        }};
    }
}
