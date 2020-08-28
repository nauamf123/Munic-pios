package com.example.cidadelista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cidadelista.response.MunicipiosResponse;

import java.lang.ref.WeakReference;
import java.util.List;

public class ListViewAdapeter extends BaseAdapter {


    private List<MunicipiosResponse> lista;

    private LayoutInflater mInflater;
    WeakReference<Context> weakReference;

    public ListViewAdapeter(List<MunicipiosResponse> lista, WeakReference<Context> weakReference) {
        this.lista = lista;
        this.weakReference = weakReference;

        this.mInflater = LayoutInflater.from(weakReference.get());
    }


    @Override
    public int getCount() {

        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    public  View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        MunicipiosResponse municipiosResponse = lista.get(position);
        if (view == null){

            view = mInflater.inflate(R.layout.support_simple_spinner_dropdown_item, null);

            holder = new ViewHolder();

            holder.textView = (TextView) view.findViewById(R.id.txtV);
            holder.textView2 = (TextView) view.findViewById(R.id.txtV2);

            view.setTag(holder);

        }else{


            holder = (ViewHolder) view.getTag();       }


        holder.textView.setText(String.valueOf(lista.get(position).getId()));
        holder.textView2.setText(String.valueOf(lista.get(position).getName()));
        return  view;
    }


    public class ViewHolder{
        TextView textView;
        TextView textView2;
    }
}
