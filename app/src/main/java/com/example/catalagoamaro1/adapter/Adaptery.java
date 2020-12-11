package com.example.catalagoamaro1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catalagoamaro1.R;
import com.example.catalagoamaro1.dominio.Produto;
import com.example.catalagoamaro1.dominio.Sizes;
import com.example.catalagoamaro1.views.DescricaoProdutoActivity;

import java.util.ArrayList;
import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {


    private List<Produto> produtosList;
    private static Context mContext;
    private ArrayList<Sizes> sizeList;
    private OnProdutoListener onProdutoListener;



    public Adaptery(List<Produto> produtosList, ArrayList<Sizes> sizeList, OnProdutoListener onProdutoListener) {
        this.produtosList = produtosList;
        this.sizeList = sizeList;
        this.onProdutoListener = onProdutoListener;
    }

    public Adaptery(Context mContext, List<Produto> produtosList) {
        this.mContext = mContext;
        this.produtosList = produtosList;


    }

    public Context getmContext() {
        return mContext;
    }

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.produto_item,parent,false);
        return new MyViewHolder(v,onProdutoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Produto produto = produtosList.get(position);
        //Sizes[] sizes = produto.getSizes();

        holder.name.setText(produto.getName());
        //holder.size.setText((CharSequence) sizes[0].getSize());


        if (!produto.getImage().isEmpty()) {

            Glide.with(mContext).load(produto.getImage()).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        if (produtosList != null){
            return produtosList.size();
        }
        return 0;

    }

    public Produto getSelectedProduto(int position){
        if(produtosList != null){
            if (produtosList.size()>0){
                return produtosList.get(position);
            }
        }
        return null;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView img;
        TextView size;
        OnProdutoListener onProdutoListener;


        public MyViewHolder(@NonNull View itemView, OnProdutoListener onProdutoListener) {
            super(itemView);

            this.onProdutoListener = onProdutoListener;

            name = itemView.findViewById(R.id.titulo);
            img = itemView.findViewById(R.id.imageView);
            size = itemView.findViewById(R.id.tamanho);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onProdutoListener.onProdutoClick(getAdapterPosition());




          //  Toast.makeText(mContext,"Clicou na pos"+getAdapterPosition(), Toast.LENGTH_LONG).show();

        }
    }

}
