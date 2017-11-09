package com.sbsromero.proyectosara.activities.monitor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sbsromero.proyectosara.R;
import com.sbsromero.proyectosara.models.Cita;
import com.sbsromero.proyectosara.models.ClassDB;

public class DetalleCitasPendientes extends AppCompatActivity {
    public ClassDB classDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_citas_pendientes);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Optiene el ActionBar correspondiente a este toolbar
        ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle("Citas pendientes");
        // Habilita el up buttom (flecah ir atras)
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Cita cita = (Cita) getIntent().getSerializableExtra("cita");
        Integer position = getIntent().getIntExtra("position",0);
        detalleCitas(cita);
        onClickBtnAceptar(position);
    }

    public void detalleCitas(Cita cita){
        TextView textViewEstudiante = (TextView) findViewById(R.id.textViewEstudiante);
        TextView textViewDocumento = (TextView) findViewById(R.id.textViewDocumento);
        TextView textViewSemestre = (TextView) findViewById(R.id.textViewSemestre);
        TextView textViewLineaAsesoria = (TextView) findViewById(R.id.textViewLineaAsesoria);

        textViewEstudiante.setText(cita.getNombreEstudiante());
        textViewDocumento.setText(cita.getDni());
        textViewSemestre.setText(cita.getSemestre());
        textViewLineaAsesoria.setText(cita.getLineaAsesoria());
    }

    public void onClickBtnAceptar(final int position){
        Button btnAceptarCita = (Button) findViewById(R.id.btnAceptarCita);

        btnAceptarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classDB = ClassDB.getInstance();
                Cita cita = (Cita) getIntent().getSerializableExtra("cita");
                classDB.agregarCita(cita);
                classDB.removeCitaPendiente(position);
                Toast.makeText(DetalleCitasPendientes.this,"Cita asignada correctamente",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
