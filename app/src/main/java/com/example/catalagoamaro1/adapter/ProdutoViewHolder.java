package com.example.catalagoamaro1.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalagoamaro1.R;
import com.example.catalagoamaro1.views.DescricaoProdutoActivity;

public class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name;
    ImageView img;
    TextView size;
    OnProdutoListener onProdutoListener;


    public ProdutoViewHolder(@NonNull View itemView, OnProdutoListener onProdutoListener) {
        super(itemView);



        name = itemView.findViewById(R.id.titulo);
        img = itemView.findViewById(R.id.imageView);
        size = itemView.findViewById(R.id.tamanho);

        this.onProdutoListener = onProdutoListener;


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        onProdutoListener.onProdutoClick(getAdapterPosition());

    }
}
