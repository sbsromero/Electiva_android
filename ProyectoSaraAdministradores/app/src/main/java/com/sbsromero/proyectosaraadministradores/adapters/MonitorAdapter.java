package com.sbsromero.proyectosaraadministradores.adapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sbsromero.proyectosaraadministradores.R;
import com.sbsromero.proyectosaraadministradores.models.Monitor;

import java.util.List;

public class MonitorAdapter extends RecyclerView.Adapter<MonitorAdapter.ViewHolder>  {

    private List<Monitor> monitores;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MonitorAdapter(List<Monitor> monitores, int layout, OnItemClickListener itemClickListener) {
        this.monitores = monitores;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(monitores.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return monitores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLineaAsesoria;
        public TextView textViewNombreMonitor;
        public TextView textViewSemestre;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewLineaAsesoria = itemView.findViewById(R.id.textViewLineaAsesoria);
            textViewNombreMonitor = itemView.findViewById(R.id.textViewNombreMonitor);
            textViewSemestre = itemView.findViewById(R.id.textViewSemestre);
        }

        public void bind(final Monitor monitor, final OnItemClickListener itemClickListener){

            textViewLineaAsesoria.setText(monitor.getLineaMonitoria());
            textViewNombreMonitor.setText(monitor.getNombre());
            textViewSemestre.setText(monitor.getSemestre());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(monitor,getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Monitor monitor,int position);
    }
}
