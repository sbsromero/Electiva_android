package com.sbsromero.proyectosara.activities.monitor;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sbsromero.proyectosara.R;
import com.sbsromero.proyectosara.adapters.AdapterCitas;
import com.sbsromero.proyectosara.models.Cita;
import com.sbsromero.proyectosara.models.ClassDB;

import java.util.ArrayList;
import java.util.List;

public class CitasPendientes extends AppCompatActivity {

    public List<Cita> citasPendientes;
    public RecyclerView recyclerViewCitasPendientes;
    public AdapterCitas adapterCitasPendientes;
    public RecyclerView.LayoutManager layoutManager;
    public ClassDB classDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_pendientes);

        //citasPendientes = getAllCitasPendientes();
        recyclerViewCitasPendientes = (RecyclerView) findViewById(R.id.recyclerViewCitasPendientes);
        layoutManager = new LinearLayoutManager(this);

        adapterCitasPendientes = new AdapterCitas(R.layout.cardview_items_citaspendientes, new AdapterCitas.OnItemClickListener() {

            @Override
            public void onItemClick(Cita cita, int position) {
                Intent intent = new Intent(CitasPendientes.this, DetalleCitasPendientes.class);
                intent.putExtra("cita",cita);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Optiene el ActionBar correspondiente a este toolbar
        ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle("Citas pendientes");
        // Habilita el up buttom (flecah ir atras)
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerViewCitasPendientes.setLayoutManager(layoutManager);
        recyclerViewCitasPendientes.setAdapter(adapterCitasPendientes);

      /*  getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        citasPendientes = getAllCitasPendientes();
        adapterCitasPendientes.setData(citasPendientes);
        adapterCitasPendientes.notifyDataSetChanged();

    }

    private ArrayList<Cita> getAllCitasPendientes(){

        classDB = ClassDB.getInstance();
        if(classDB.getCitasPendientes().size()==0){
            ArrayList<Cita> citasPendientes = new ArrayList<Cita>(){{
                add(new Cita("Estudiante 1","12345","Programación","Semestre 5"));
                add(new Cita("Estudiante 2","6789","Algoritmos","Semestre 3"));
                add(new Cita("Estudiante 3","10928","Backtracking","Semestre 3"));
            }};
            classDB.setCitasPendientes(citasPendientes);
        }
        return (ArrayList<Cita>) classDB.getCitasPendientes();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }*/
}
