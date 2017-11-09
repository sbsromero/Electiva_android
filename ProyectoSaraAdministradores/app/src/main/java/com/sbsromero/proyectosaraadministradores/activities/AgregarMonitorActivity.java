package com.sbsromero.proyectosaraadministradores.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.sbsromero.proyectosaraadministradores.R;

public class AgregarMonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_monitor);

        getSupportActionBar().setTitle("Agregar monitor");
        //imgButtonFoto

        Intent intenCamara = new Intent("android.media.action.IMAGE_CAPTURE");

        ImageButton imgButtonFoto = (ImageButton) findViewById(R.id.imgButtonFoto);


    }
}
