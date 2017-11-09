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

public class CancelarCitas extends AppCompatActivity {

    public List<Cita> citasAsignadas;
    public RecyclerView recyclerViewCancelarCitas;
    public AdapterCitas adapterCancelarCitas;
    public RecyclerView.LayoutManager layoutManager;
    public ClassDB classDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelar_citas);

        recyclerViewCancelarCitas = (RecyclerView) findViewById(R.id.recyclerViewCancelarCitas);
        layoutManager = new LinearLayoutManager(this);

        adapterCancelarCitas = new AdapterCitas(R.layout.cardview_items_citaspendientes, new AdapterCitas.OnItemClickListener() {
            @Override
            public void onItemClick(Cita cita, int position) {
                Intent intent = new Intent(CancelarCitas.this, DetalleCitasAsignadas.class);
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
        getSupportActionBar().setTitle("Citas asignadas");

        // Habilita el up buttom (flecah ir atras)
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerViewCancelarCitas.setAdapter(adapterCancelarCitas);
        recyclerViewCancelarCitas.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        classDB = ClassDB.getInstance();
        citasAsignadas = getCitasAsignadas();
        adapterCancelarCitas.setData(citasAsignadas);
        adapterCancelarCitas.notifyDataSetChanged();
    }

    public ArrayList<Cita> getCitasAsignadas(){
        return (ArrayList<Cita>) classDB.getCitasAsignadas();
    }
}
