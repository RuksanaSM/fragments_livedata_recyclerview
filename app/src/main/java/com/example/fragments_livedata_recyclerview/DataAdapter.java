package com.example.fragments_livedata_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.UserHolder> {
    private Context context;
    private List<String> stringList;


    public DataAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public DataAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);
       return new UserHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.UserHolder holder, int position) {

        holder.empname.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
        this.stringList.clear();

        notifyDataSetChanged();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView empname;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            empname=itemView.findViewById(R.id.recycler_empname);
        }
    }
}
