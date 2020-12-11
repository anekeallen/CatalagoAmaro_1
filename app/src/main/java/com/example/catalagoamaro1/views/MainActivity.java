package com.example.catalagoamaro1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalagoamaro1.adapter.Adaptery;
import com.example.catalagoamaro1.JSONResponse;
import com.example.catalagoamaro1.adapter.OnProdutoListener;
import com.example.catalagoamaro1.adapter.ProdutoRecycleView;
import com.example.catalagoamaro1.dominio.Produto;
import com.example.catalagoamaro1.ProdutoApi;
import com.example.catalagoamaro1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnProdutoListener {

    private RecyclerView recyclerView;
    List<Produto> produtoList;
    private static ProdutoRecycleView produtoRecyclerAdapter;
    Adaptery adaptery;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        produtoList = new ArrayList<>();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProdutoApi produtoApi = retrofit.create(ProdutoApi.class);

        Call<JSONResponse> call = produtoApi.getProdutos();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                produtoList = new ArrayList<>(Arrays.asList(jsonResponse.getProducts()));

                PutDataIntoRecyclerView(produtoList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {


            }
        });


    }
    private void PutDataIntoRecyclerView(List<Produto> produtoList) {
        produtoRecyclerAdapter = new ProdutoRecycleView(this,produtoList,onProdutoListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(produtoRecyclerAdapter);


    }


    OnProdutoListener onProdutoListener = new OnProdutoListener() {

        @Override
        public void onProdutoClick(int position) {

            Intent intent = new Intent(getApplicationContext(), DescricaoProdutoActivity.class);
            intent.putExtra("produto",produtoRecyclerAdapter.getSelectedProduto(position));
            intent.putExtra("dados",produtoRecyclerAdapter.getSelectedProduto(position).getSizes());

            startActivity(intent);

        }
    };


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        return super.onContextItemSelected(item);
    }


    @Override
    public void onProdutoClick(int position) {

    }
}