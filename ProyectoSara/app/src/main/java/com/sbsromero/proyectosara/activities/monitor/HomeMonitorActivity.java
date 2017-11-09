package com.sbsromero.proyectosara.activities.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sbsromero.proyectosara.R;
import com.sbsromero.proyectosara.adapters.AdapterHomeMonitor;

import java.util.ArrayList;
import java.util.List;

public class HomeMonitorActivity extends AppCompatActivity {

    public RecyclerView.Adapter monitorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_monitor);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

     /*   getSupportActionBar().setDisplayShowHomeEnabled(true);*/

        List<String> options = new ArrayList<>();
        options.add("Citas pendientes");
        options.add("Cancelar citas");

        RecyclerView recyclerViewMonitor = (RecyclerView) findViewById(R.id.recyclerViewHomeMonitor);
        recyclerViewMonitor.setLayoutManager(new GridLayoutManager(this, 2));

        //Creamos nuestro adaptador
        monitorAdapter = new AdapterHomeMonitor(options, R.layout.recyclerview_item, new AdapterHomeMonitor.OnItemClickListener() {
            @Override
            public void onItemClick(String option, int position) {
                if(position == 0){
                    Intent intent = new Intent(HomeMonitorActivity.this,CitasPendientes.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(HomeMonitorActivity.this,CancelarCitas.class);
                    startActivity(intent);
                }
            }
        });

        recyclerViewMonitor.setHasFixedSize(true);
        //recyclerViewMonitor.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMonitor.setAdapter(monitorAdapter);

    }

    //Metodo que nos permite crear nuestro menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    //Metodo que maneja los eventos cuando se da click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
