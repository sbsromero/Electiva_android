package com.sbsromero.proyectosaraadministradores.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.sbsromero.proyectosaraadministradores.R;
import com.sbsromero.proyectosaraadministradores.Util.ClassDB;
import com.sbsromero.proyectosaraadministradores.activities.AgregarMonitorActivity;
import com.sbsromero.proyectosaraadministradores.adapters.MonitorAdapter;
import com.sbsromero.proyectosaraadministradores.models.Monitor;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMonitorFragment extends Fragment {

    public List<Monitor> monitores;
    public RecyclerView recyclerListViewMonitor;
    public MonitorAdapter monitorAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public FloatingActionButton btnAgregarMentor;
    public MonitorListener monitorListener;

    public ListMonitorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            monitorListener = (MonitorListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement MonitorListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        monitorListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_monitor,container,false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerFilter);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.lineasAsesoria_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        recyclerListViewMonitor = view.findViewById(R.id.recyclerListViewMonitor);
        btnAgregarMentor = view.findViewById(R.id.floatAgregarMonitor);
        layoutManager = new LinearLayoutManager(getActivity());
        monitores = ClassDB.getMonitores();

        monitorAdapter = new MonitorAdapter(monitores, R.layout.recycler_view_item, new MonitorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Monitor monitor, int position) {
                enviarMonitor(monitores.get(position));
                //Toast.makeText(getContext(),monitor.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerListViewMonitor.setAdapter(monitorAdapter);
        recyclerListViewMonitor.setLayoutManager(layoutManager);
        recyclerListViewMonitor.addItemDecoration(new DividerItemDecoration(
                getActivity(),
                ((LinearLayoutManager) layoutManager).getOrientation())
        );
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btnAgregarMentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgregarMonitorActivity.class);
                startActivity(intent);
                // Toast.makeText(view.getContext(),"Presiono",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void enviarMonitor(Monitor monitor){
        monitorListener.enviarDatosMonitor(monitor);

    }

    public interface MonitorListener{
        void enviarDatosMonitor(Monitor monitor);
    }
}
