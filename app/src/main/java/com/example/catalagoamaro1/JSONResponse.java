package com.example.catalagoamaro1;

import com.example.catalagoamaro1.dominio.Produto;

public class JSONResponse {

    private Produto[] products;

    public Produto[] getProducts() {
        return products;
    }

    public void setProducts(Produto[] products) {
        this.products = products;
    }
}
