package com.germangascon.toolbar.paises;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.germangascon.toolbar.R;


public class CountryAdapter extends ArrayAdapter {
    private Country[] paises;
    static class ViewHolder {
        TextView tvPais;
        TextView tvCapital;
        TextView tvPoblacion;
        ImageView ivBandera;
    }

    public CountryAdapter(@NonNull Context context, Country[] paises) {
        super(context, R.layout.listitem_country, paises);
        this.paises = paises;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;


        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_country, null);

            holder = new ViewHolder();
            holder.tvPais = (TextView)item.findViewById(R.id.tvPais);
            holder.tvCapital = (TextView)item.findViewById(R.id.tvCapital);
            holder.tvPoblacion = (TextView)item.findViewById(R.id.tvPoblacion);
            holder.ivBandera = (ImageView)item.findViewById(R.id.ivBandera);

            item.setTag(holder);
        }else {
            holder = (ViewHolder)item.getTag();
        }

        int id = this.getContext().getResources().getIdentifier("_"+paises[position].getCountryCode().toLowerCase(), "drawable", this.getContext().getPackageName());
        holder.ivBandera.setImageResource(id);
        holder.tvPais.setText(paises[position].getCountryName());
        holder.tvCapital.setText(paises[position].getCapital());
        holder.tvPoblacion.setText(String.valueOf(paises[position].getPopulation()));
        return item;
    }
}
