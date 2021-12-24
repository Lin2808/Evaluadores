package com.example.evaluadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder>
{
    LayoutInflater inflater;
    List<Evaluadores> evaluadores;
    Context context;

    public listAdapter(Context context, List<Evaluadores> evaluadores)
    {
        this.inflater = LayoutInflater.from(context);
        this.evaluadores = evaluadores;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.ly_evaluadores, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.idevaluador.setText(evaluadores.get(position).getIdevaluador());
        holder.nombres.setText(evaluadores.get(position).getNombres());
        holder.area.setText(evaluadores.get(position).getArea());
        Glide.with(context)
                .load(evaluadores.get(position).getImgJPG())
                .error(
                        Glide.with(context)
                                .load(evaluadores.get(position).getImgjpg())
                                .error(R.drawable.unknown)
                )
                .into(holder.imgFoto);
        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainEvaluados.class);
                intent.putExtra("idevaluador", holder.idevaluador.getText());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return evaluadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView idevaluador, nombres, area;
        ImageView imgFoto;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            idevaluador = itemView.findViewById(R.id.idevaluador);
            nombres = itemView.findViewById(R.id.nombres);
            area = itemView.findViewById(R.id.area);
            imgFoto = itemView.findViewById(R.id.imgFoto);
        }
    }
}
