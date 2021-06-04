package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Country> {

    private Context context;
    private List<Country> countryList;

    public MyCustomAdapter(Context context, List<Country> countryList) {
        super(context, R.layout.list_custom_item, countryList);
        this.context=context;
        this.countryList=countryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountry=view.findViewById(R.id.tvCountry);
        ImageView imageView=view.findViewById(R.id.flag);
        tvCountry.setText(countryList.get(position).getCountry());
        Glide.with(context).load(countryList.get(position).getFlag()).into(imageView);

        return view;
    }
}