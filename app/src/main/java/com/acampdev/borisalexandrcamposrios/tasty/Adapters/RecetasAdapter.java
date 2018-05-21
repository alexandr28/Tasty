package com.acampdev.borisalexandrcamposrios.tasty.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acampdev.borisalexandrcamposrios.tasty.POJOS.Receta;
import com.acampdev.borisalexandrcamposrios.tasty.R;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder>{

    Context context;
    public List<Receta> recetas;

    public RecetasAdapter(Context context, List<Receta> recetas){
        this.context=context;
        this.recetas=recetas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recetaitem,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(recetas.get(position).getNombre());
        holder.personas.setText("Personas: " + String.valueOf(recetas.get(position).getPersonas()));
        holder.descripcion.setText(recetas.get(position).getDescripcion());
        holder.prepraracion.setText(recetas.get(position).getPreparacion());
        // agregamos la condicion para favoritos
        if(recetas.get(position).getFav()==1){
            holder.star.setImageResource(R.drawable.star_yelow);
            holder.imageView.setImageResource(R.drawable.pizza);
        }else {
            holder.star.setImageResource(R.drawable.black_star);
        }
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView,star;
        TextView nombre,personas,descripcion,prepraracion;

        public ViewHolder(View itemView){
            super(itemView);

            cardView= (CardView) itemView.findViewById(R.id.cardview);
            imageView= (ImageView) itemView.findViewById(R.id.image);
            nombre= (TextView) itemView.findViewById(R.id.nombre);
            personas= (TextView) itemView.findViewById(R.id.personas);
            descripcion= (TextView) itemView.findViewById(R.id.descripcion);
            prepraracion=(TextView) itemView.findViewById(R.id.prepraracion);
            star=(ImageView) itemView.findViewById(R.id.star);
        }
    }
}
