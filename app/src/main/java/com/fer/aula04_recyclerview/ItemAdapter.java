package com.fer.aula04_recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

   Context contexto;
   ArrayList<ItemData> itemDataAL;
   boolean escuro;

   public ItemAdapter(Context contexto, ArrayList<ItemData> itemDataAL, boolean escuro) {
      this.contexto = contexto;
      this.itemDataAL = itemDataAL;
      this.escuro = escuro;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(contexto).inflate(R.layout.item_view, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.data.setText(itemDataAL.get(position).getData());
      holder.nome.setText(itemDataAL.get(position).getNome());
      holder.imageView.setImageResource(itemDataAL.get(position).getImgId());
   }

   @Override
   public int getItemCount() {
      return itemDataAL.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder{
      TextView nome, data;
      ImageView imageView;

      public ViewHolder (View itemView){
         super(itemView);
         nome = itemView.findViewById(R.id.nome);
         data = itemView.findViewById(R.id.data);
         imageView = itemView.findViewById(R.id.img00);
         if (escuro){
            nome.setTextColor(Color.WHITE);
            data.setTextColor(Color.WHITE);
         }

      }
   }
}
