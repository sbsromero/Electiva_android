package com.sbsromero.proyectosaraadministradores.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sbsromero.proyectosaraadministradores.R;
import com.sbsromero.proyectosaraadministradores.fragments.ListMonitorFragment;
import com.sbsromero.proyectosaraadministradores.fragments.VisualizarMonitorFragment;
import com.sbsromero.proyectosaraadministradores.models.Monitor;

public class ListaMonitoresActivity extends AppCompatActivity implements ListMonitorFragment.MonitorListener{

    private boolean isMultipanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_monitores);
        setMultipanel();

        getSupportActionBar().setTitle("Monitores");

    }

    @Override
    public void enviarDatosMonitor(Monitor monitor) {

        if(isMultipanel){
            VisualizarMonitorFragment visualizarMonitorFragment = (VisualizarMonitorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailsMonitor);
            visualizarMonitorFragment.renderMonitor(monitor);
        }else{
            Intent intent = new Intent(ListaMonitoresActivity.this,VisualizarMonitorActivity.class);
            intent.putExtra("monitor",monitor);
            startActivity(intent);
        }
    }

    public void setMultipanel() {
        isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetailsMonitor) != null);
    }
}
