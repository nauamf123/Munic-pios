package com.example.cidadelista.response;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Array;

@Entity
public class MunicipiosResponse {


    @PrimaryKey(autoGenerate = true)
    private long id;


    @ColumnInfo(name = "first_name")
    private  String name;
    @ColumnInfo(name = "mylist_array")
    private Array microrregiao;


    public long getId() {
        return id;
    }


    public Array getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Array microrregiao) {
        this.microrregiao = microrregiao;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }




}