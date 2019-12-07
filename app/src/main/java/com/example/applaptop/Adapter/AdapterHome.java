package com.example.applaptop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applaptop.Model.LapTop;
import com.example.applaptop.R;
import com.example.applaptop.activity.HomeActivity;
import com.example.applaptop.activity.ItemClickListener;
import com.example.applaptop.activity.ProfileActivity;

import java.util.ArrayList;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private ArrayList<LapTop> list;
    private Context context;
//    private ItemClickListener itemClickListener;

    public AdapterHome(ArrayList<LapTop> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View item = li.inflate(R.layout.item_new_product, parent, false);
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
        holder.screen.setText(list.get(position).getScreen());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Intent i = new Intent("com.example.applaptop.activity.ProfileActivity");
                    context.startActivity(i);
                } else {
                    Toast.makeText(context, " " + list.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView name;
        TextView price;
        TextView cpu;
        TextView ram;
        TextView disk;
        ImageView preview;
        TextView screen;
        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            cpu = itemView.findViewById(R.id.cpu);
            ram = itemView.findViewById(R.id.ram);
            disk = itemView.findViewById(R.id.disk);
            screen = itemView.findViewById(R.id.screen);
            preview = itemView.findViewById(R.id.preview);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
