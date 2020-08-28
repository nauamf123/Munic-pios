package com.example.cidadelista;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cidadelista.network.ApiService;
import com.example.cidadelista.network.AppDataBase;
import com.example.cidadelista.network.MunicipiosService;
import com.example.cidadelista.response.MunicipiosResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText el = (EditText) findViewById(R.id.el);
        ListView lista = (ListView) findViewById(R.id.ls);

        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "production")
                .allowMainThreadQueries()
                .build();

        MunicipiosService municipiosService = ApiService.getInstance().create(MunicipiosService.class);

        final WeakReference<Context> weakReference;
        weakReference = new WeakReference<>(getBaseContext());


       municipiosService.findAll()
               .enqueue(new Callback<List<MunicipiosResponse>>() {
                   @Override
                   public void onResponse(Call<List<MunicipiosResponse>> call, Response<List<MunicipiosResponse>> response) {
                       db.municipioDao().getAllMunicipios();

                       ListViewAdapeter listViewAdapeter = new ListViewAdapeter(response.body(), weakReference);

                       lista.setAdapter(listViewAdapeter);
                   }

                   @Override
                   public void onFailure(Call<List<MunicipiosResponse>> call, Throwable t) {
                       Toast.makeText(MainActivity.this, "Não foi possível carregar os dados! ", Toast.LENGTH_LONG).show();
                   }
               });


    }

    }

