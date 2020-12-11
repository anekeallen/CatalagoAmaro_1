package com.example.catalagoamaro1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoApi {

    @GET("v2/59b6a65a0f0000e90471257d")
    Call<JSONResponse> getProdutos();
}
