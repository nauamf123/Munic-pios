package com.example.cidadelista.network;

import com.example.cidadelista.response.MunicipiosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MunicipiosService {

    @GET("localidades/estados/{UF}/municipios")
    Call<List<MunicipiosResponse>> findAll();
}
