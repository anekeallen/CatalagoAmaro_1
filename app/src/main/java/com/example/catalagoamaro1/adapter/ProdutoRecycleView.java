package com.example.catalagoamaro1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catalagoamaro1.R;
import com.example.catalagoamaro1.dominio.Produto;
import com.example.catalagoamaro1.dominio.Sizes;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Produto> produtosList;
    private static Context mContext;
    private ArrayList<Sizes> sizeList;
    private OnProdutoListener onProdutoListener;

    public ProdutoRecycleView(Context mContext, List<Produto> produtosList, OnProdutoListener onProdutoListener) {
        this.onProdutoListener = onProdutoListener;
        this.mContext = mContext;
        this.produtosList = produtosList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item,parent,false);

        return new ProdutoViewHolder(v,onProdutoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Produto produto = produtosList.get(position);
        Sizes[] sizes = produto.getSizes();

        ((ProdutoViewHolder) holder).name.setText(produto.getName());
        ((ProdutoViewHolder) holder).size.setText(sizes[0].getSize());


        if (!produto.getImage().isEmpty()) {

            Glide.with(mContext).load(produto.getImage()).into(((ProdutoViewHolder) holder).img);
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
}
