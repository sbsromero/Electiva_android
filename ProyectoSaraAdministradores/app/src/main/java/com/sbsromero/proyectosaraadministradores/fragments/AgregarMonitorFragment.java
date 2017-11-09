package com.sbsromero.proyectosaraadministradores.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sbsromero.proyectosaraadministradores.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarMonitorFragment extends Fragment {

    private final int FOTO_CAMARA = 14;

    public AgregarMonitorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agregar_monitor, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerSemestre);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semestres_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinnerLineaMonitoria = (Spinner) view.findViewById(R.id.spinnerLineaMonitoria);
        ArrayAdapter<CharSequence> adapterLineaMonitoria = ArrayAdapter.createFromResource(getContext(),
                R.array.lineasAsesoria_array, android.R.layout.simple_spinner_item);
        adapterLineaMonitoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLineaMonitoria.setAdapter(adapterLineaMonitoria);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ImageButton imgButtonFoto = (ImageButton) getActivity().findViewById(R.id.imgButtonFoto);
        imgButtonFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenCamara = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intenCamara, FOTO_CAMARA);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case FOTO_CAMARA:
                if (resultCode == Activity.RESULT_OK) {
                    String result = data.toUri(0);
                    ImageView imageViewFotoPerfil = (ImageView) getView().findViewById(R.id.imageViewFotoPerfil);
                    Picasso.with(getContext()).load(result).fit().into(imageViewFotoPerfil);
                } else {
                    Toast.makeText(getContext(), "hubo un error en la captura de imagen", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
