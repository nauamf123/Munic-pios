package com.example.cidadelista.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService   {


    public static Retrofit getInstance() {

        return new Retrofit.Builder()
                .baseUrl("https://servicodados.ibge.gov.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
