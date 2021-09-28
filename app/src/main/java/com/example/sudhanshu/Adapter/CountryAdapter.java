package com.example.sudhanshu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sudhanshu.Model.Countrymodel;
import com.example.sudhanshu.Model.Statemodel;
import com.example.sudhanshu.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{
    public CountryAdapter(ArrayList<Countrymodel> arrayList) {
        this.arrayList = arrayList;
    }
    private ArrayList<Countrymodel>arrayList;

    @NonNull

    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_case,parent,false);
        return new CountryAdapter.ViewHolder(view);
    }
    public void filterlist(ArrayList<Countrymodel> filterList){
        arrayList=filterList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull  CountryAdapter.ViewHolder holder, int position) {

        Countrymodel Countrymodel=arrayList.get(position);
        holder.countryName.setText(Countrymodel.getCountryName());
        holder.country_case.setText(Countrymodel.getCountryCase());
        holder.countryDeath.setText(Countrymodel.getCountryDeath());
        holder.countryRecovered.setText(Countrymodel.getCountryRecovred());


    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView countryName,country_case,countryDeath,countryRecovered;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            country_case=itemView.findViewById(R.id.country_case);
            countryName=itemView.findViewById(R.id.countryName);
            countryDeath=itemView.findViewById(R.id.country_death);
            countryRecovered=itemView.findViewById(R.id.country_Recovered);

        }
    }
}
