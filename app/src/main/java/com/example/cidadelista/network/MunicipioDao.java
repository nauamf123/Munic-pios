package com.example.cidadelista.network;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.cidadelista.response.MunicipiosResponse;

import java.util.List;

public abstract class MunicipioDao {
    @Query("SELECT * FROM municipiosresponse")
    public List<MunicipiosResponse> getAllMunicipios() {
        return getAllMunicipios();
    }


   @Insert
   abstract void insertAllM(MunicipiosService... municipiosServices);

}
