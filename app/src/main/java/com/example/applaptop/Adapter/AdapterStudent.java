package com.example.applaptop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applaptop.Model.LapTop;
import com.example.applaptop.R;

import java.util.ArrayList;


public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolder>{
    private ArrayList<LapTop> list;
    private Context context;

    public AdapterStudent(ArrayList<LapTop> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View item = li.inflate(R.layout.item_laptop_student,parent,false);
        ViewHolder vh = new ViewHolder(item);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.cpu.setText(list.get(position).getCpu());
        holder.ram.setText(list.get(position).getRam());
        holder.disk.setText(list.get(position).getDisk());
        holder.preview.setImageResource(list.get(position).getPreview());
        holder.price.setText(String.format("%.2f",list.get(position).getPrice()));
        holder.price.setText(String.format("%.2f",list.get(position).getPrice()));
        holder.screen.setText(list.get(position).getScreen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView cpu;
        TextView ram;
        TextView disk;
        ImageView preview;
        TextView screen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            cpu = itemView.findViewById(R.id.cpu);
            ram = itemView.findViewById(R.id.ram);
            disk = itemView.findViewById(R.id.disk);
            preview = itemView.findViewById(R.id.preview);
            screen = itemView.findViewById(R.id.screen);
        }
    }
}
