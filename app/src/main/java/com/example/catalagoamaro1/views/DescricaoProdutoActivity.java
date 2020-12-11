package com.example.catalagoamaro1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.catalagoamaro1.R;
import com.example.catalagoamaro1.adapter.ProdutoViewHolder;
import com.example.catalagoamaro1.dominio.Produto;
import com.example.catalagoamaro1.dominio.Sizes;

import java.util.ArrayList;
import java.util.List;

public class DescricaoProdutoActivity extends AppCompatActivity {

    List<Produto> produtoList;
    private ImageView imageViewDescricao;
    private TextView nome, preco, promo, precopromo, parcelamento, tamanho;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_produto);

        imageViewDescricao = findViewById(R.id.img_produto);
        nome = findViewById(R.id.nome);
        preco = findViewById(R.id.preco);
        promo = findViewById(R.id.promocao);
        precopromo = findViewById(R.id.precopromo);
        parcelamento = findViewById(R.id.parcelamento);
        //tamanho = findViewById(R.id.tamanho);

        produtoList=new ArrayList<>();

        GetDataFromIntent();
    }

    private void GetDataFromIntent() {
        if (getIntent().hasExtra("produto")){
            Produto produto = getIntent().getParcelableExtra("produto");
           // Sizes sizes = getIntent().getParcelableExtra("dados");

            nome.setText(produto.getName());
            preco.setText(produto.getRegular_price());

            promo.setText(produto.getDiscount_percentage());

            parcelamento.setText(produto.getInstallments());

            if (!promo.getText().toString().isEmpty()){
                preco.setPaintFlags(preco.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                precopromo.setText(produto.getActual_price());
            }

          //  tamanho.setText(sizes.getSize());

           Glide.with(this).load(produto.getImage()).into(imageViewDescricao);



        }
    }
}