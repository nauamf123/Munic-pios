package com.example.cidadelista.network;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cidadelista.response.MunicipiosResponse;

@Database(entities = {MunicipiosResponse.class}, version =  1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract  MunicipioDao municipioDao();
}
