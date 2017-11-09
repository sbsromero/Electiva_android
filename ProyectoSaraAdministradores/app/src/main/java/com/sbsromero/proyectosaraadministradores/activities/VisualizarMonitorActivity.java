package com.sbsromero.proyectosaraadministradores.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sbsromero.proyectosaraadministradores.R;
import com.sbsromero.proyectosaraadministradores.fragments.VisualizarMonitorFragment;
import com.sbsromero.proyectosaraadministradores.models.Monitor;

public class VisualizarMonitorActivity extends AppCompatActivity {

    private Monitor monitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_monitor);

        getSupportActionBar().setTitle("Visualizar monitor");
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(getIntent().getExtras()!= null){
            monitor = (Monitor) getIntent().getSerializableExtra("monitor");
        }

        VisualizarMonitorFragment fragmentVisualizarMonitor = (VisualizarMonitorFragment) getSupportFragmentManager().findFragmentById(R.id.visualizarMonitorFragment);
        fragmentVisualizarMonitor.renderMonitor(monitor);

    }
}
