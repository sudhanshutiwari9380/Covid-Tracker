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

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {


    public StateAdapter(ArrayList<Statemodel> arrayList) {
        this.arrayList = arrayList;
    }
    private ArrayList<Statemodel>arrayList;

    @NonNull

    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.state_case,parent,false);
        return new ViewHolder(view);
    }
    public void filterliststate(ArrayList<Statemodel> filterListstate){
        arrayList=filterListstate;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull  StateAdapter.ViewHolder holder, int position) {

        Statemodel statemodel=arrayList.get(position);
        holder.stateName.setText(statemodel.getStateName());
        holder.state_case.setText(statemodel.getStateCase());
        holder.state_Death.setText(statemodel.getStateDeath());
        holder.state_Recovered.setText(statemodel.getStateRecovered());



    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView stateName,state_case,state_Death,state_Recovered;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            state_case=itemView.findViewById(R.id.state_case);
            stateName=itemView.findViewById(R.id.stateName);
            state_Death=itemView.findViewById(R.id.state_Death);
            state_Recovered=itemView.findViewById(R.id.state_Recovered);

        }
    }
}
