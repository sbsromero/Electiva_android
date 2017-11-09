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

public class DetalleCitasAsignadas extends AppCompatActivity {
    public ClassDB classDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_citas_asignadas);

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
        onClickBtnCancelar(position);

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

    public void onClickBtnCancelar(final Integer position){
        Button btnCancelarCita = (Button) findViewById(R.id.btnCancelarCita);

        btnCancelarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classDB = ClassDB.getInstance();
                classDB.removeCitaAsignada(position);
                Toast.makeText(DetalleCitasAsignadas.this,"Cita cancelada correctamente",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
