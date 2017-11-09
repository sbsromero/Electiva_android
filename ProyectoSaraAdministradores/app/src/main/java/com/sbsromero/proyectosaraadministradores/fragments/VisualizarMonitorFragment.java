package com.sbsromero.proyectosaraadministradores.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sbsromero.proyectosaraadministradores.R;
import com.sbsromero.proyectosaraadministradores.models.Monitor;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisualizarMonitorFragment extends Fragment {

    private TextView textViewNombre;
    private TextView textViewTelefono;
    private TextView textViewUsername;
    private TextView textViewSemestre;
    private TextView textViewLineaAsesoria;
    private RelativeLayout relativeVisualizarMonitor;

    public VisualizarMonitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visualizar_monitor, container, false);
        textViewNombre = view.findViewById(R.id.textViewNombre);
        textViewTelefono = view.findViewById(R.id.textViewTelefono);
        textViewUsername = view.findViewById(R.id.textViewUsername);
        textViewSemestre = view.findViewById(R.id.textViewSemestre);
        textViewLineaAsesoria = view.findViewById(R.id.textViewLineaAsesoria);
        relativeVisualizarMonitor = view.findViewById(R.id.relativeVisualizarMonitor);
        return view;
    }

    public void renderMonitor(Monitor monitor){
        relativeVisualizarMonitor.setVisibility(View.VISIBLE);
        textViewNombre.setText(monitor.getNombre());
        textViewSemestre.setText(monitor.getSemestre());
        textViewLineaAsesoria.setText(monitor.getLineaMonitoria());
    }

}
