package com.example.applaptop.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applaptop.Model.LapTop;
import com.example.applaptop.R;

import java.util.ArrayList;

public class AdapterDell extends BaseAdapter {
    private Context context;
    private ArrayList<LapTop> l;

    public AdapterDell(Context context, ArrayList<LapTop> l) {
        this.context = context;
        this.l = l;
    }
    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int position) {
        return l.get(position);
    }

    @Override
    public long getItemId(int position) {
        return l.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.item_laptop_dell,null);
        TextView name = v.findViewById(R.id.tvname);
        TextView price = v.findViewById(R.id.tvprice);
        TextView cpu = v.findViewById(R.id.tvcpu);
        TextView ram = v.findViewById(R.id.tvram);
        TextView disk = v.findViewById(R.id.tvdisk);
        TextView screen = v.findViewById(R.id.tvscreen);
        ImageView preview = v.findViewById(R.id.preview);


        LapTop laptop = l.get(position);

        name.setText(laptop.getName());
        cpu.setText(laptop.getCpu());
        ram.setText(laptop.getRam());
        disk.setText(laptop.getDisk());
        preview.setImageResource(laptop.getPreview());
        price.setText(String.format("%.2f",laptop.getPrice()));
        screen.setText(laptop.getScreen());

        return v;
    }
}
