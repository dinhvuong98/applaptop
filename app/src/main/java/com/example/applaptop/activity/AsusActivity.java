package com.example.applaptop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applaptop.Adapter.AdapterDell;
import com.example.applaptop.Model.LapTop;
import com.example.applaptop.R;

import java.util.ArrayList;

public class AsusActivity extends AppCompatActivity {
    private ListView lvLapTop;
    private AdapterDell ap;
    private  ArrayList<LapTop>  list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asus);
        lvLapTop = findViewById(R.id.lvasus);

        list  = new ArrayList<>();

        list.add(new LapTop(1,"DELL vivobook X507UF","core i5","8GB DDR4","HDD 1TB", 16900000.0,R.drawable.new1,"15.6 inch","DELL"));
        list.add(new LapTop(2,"DELL vivobook S530","Core i7 9900K","8GB DDR4","SSD 250GB",25900000.0,R.drawable.new4, "14 inch","DELL"));
        list.add(new LapTop(3,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","DELL"));
        list.add(new LapTop(4,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new3,"15.5 inch","ASUS"));
        list.add(new LapTop(5,"DELL Inspiron N4522","Core i3 9900K","8GB DDR4","SSD 1TB",18900000.0,R.drawable.new4,"> 15.6 inch","ASUS"));
        list.add(new LapTop(6,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","ASUS"));
        list.add(new LapTop(7,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new5,"15.5 inch","ASUS"));

        ap  = new AdapterDell(this,list);

        lvLapTop.setAdapter(ap);

        lvLapTop.setClickable(true);

        lvLapTop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AsusActivity.this, DetailProductAvtivity.class);
                startActivity(intent);
            }
        });

    }
}
