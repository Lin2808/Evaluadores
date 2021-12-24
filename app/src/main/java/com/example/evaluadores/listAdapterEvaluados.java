package com.example.evaluadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class listAdapterEvaluados extends RecyclerView.Adapter<listAdapterEvaluados.ViewHolder>
{
    LayoutInflater inflater;
    List<Evaluados> evaluados;
    Context context;

    public listAdapterEvaluados(Context context, List<Evaluados> evaluados)
    {
        this.inflater = LayoutInflater.from(context);
        this.evaluados = evaluados;
        this.context = context;
    }

    @NonNull
    @Override
    public listAdapterEvaluados.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.ly_evaluados, parent, false);
        return new listAdapterEvaluados.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapterEvaluados.ViewHolder holder, int position)
    {
        holder.id.setText(evaluados.get(position).getId());
        holder.idevaluado.setText(evaluados.get(position).getIdevaluado());
        holder.nombres.setText(evaluados.get(position).getNombres());
        holder.genero.setText(evaluados.get(position).getGenero());
        holder.situacion.setText(evaluados.get(position).getSituacion());
        holder.cargo.setText(evaluados.get(position).getCargo());
        holder.fechaInicio.setText(evaluados.get(position).getFechaInicio());
        holder.fechaFin.setText(evaluados.get(position).getFechaFin());

        Glide.with(context)
                .load(evaluados.get(position).getImgJPG())
                .error(
                        Glide.with(context)
                                .load(evaluados.get(position).getImgjpg())
                                .error(R.drawable.unknown)
                )
                .into(holder.evaImgFoto);





    }

    @Override
    public int getItemCount()
    {
        return evaluados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView id, idevaluado, nombres, genero, situacion, cargo, fechaInicio, fechaFin;
        ImageView evaImgFoto;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            idevaluado = itemView.findViewById(R.id.idevaluado);
            nombres = itemView.findViewById(R.id.evaNombres);
            genero = itemView.findViewById(R.id.genero);
            situacion = itemView.findViewById(R.id.situacion);
            cargo = itemView.findViewById(R.id.cargo);
            fechaInicio = itemView.findViewById(R.id.fechaInicio);
            fechaFin = itemView.findViewById(R.id.fechaFin);
            evaImgFoto = itemView.findViewById(R.id.evaImgFoto);
        }
    }
}
