package com.sbsromero.proyectosara.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbsromero.proyectosara.R;
import com.sbsromero.proyectosara.models.Cita;

import java.util.List;

/**
 * Created by USERPC on 21/10/2017.
 */

public class AdapterCitas extends RecyclerView.Adapter<AdapterCitas.ViewHolder> {

    private List<Cita> citasPendientes;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;


    public AdapterCitas(int layout, OnItemClickListener itemClickListener) {
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Cita> citasPendientes){
        this.citasPendientes = citasPendientes;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(citasPendientes.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return citasPendientes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombreEstudiante;
        TextView textViewLineaAsesoria;
        TextView textViewSemestre;

        ViewHolder(View itemView) {
            super(itemView);
            textViewNombreEstudiante = itemView.findViewById(R.id.textViewNombreEstudiante);
            textViewLineaAsesoria = itemView.findViewById(R.id.textViewLineaAsesoria);
            textViewSemestre = itemView.findViewById(R.id.textViewSemestre);
        }

        void bind(final Cita cita, final OnItemClickListener listener) {

            textViewNombreEstudiante.setText(cita.getNombreEstudiante());
            textViewLineaAsesoria.setText(cita.getLineaAsesoria());
            textViewSemestre.setText(cita.getSemestre());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(cita, getAdapterPosition());
                }
            });

        }
    }

    //interfaz que tenemos que crear (propio)
    public interface OnItemClickListener {
        void onItemClick(Cita cita, int position);
    }
}
