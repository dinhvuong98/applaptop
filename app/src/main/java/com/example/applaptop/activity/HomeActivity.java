package com.example.applaptop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applaptop.Adapter.AdapterHome;
import com.example.applaptop.Model.LapTop;
import com.example.applaptop.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ImageButton popupmenu;
    private EditText txtSearch;
    private Button btnsearch;
    private String email;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        popupmenu = findViewById(R.id.popupmenu);
        popupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });
        btnsearch = findViewById(R.id.search);
        txtSearch = findViewById(R.id.keyword);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtSearch.getText().equals("")){
                    createDialog2("Vui lòng nhập dữ liệu tìm kiếm");
                }else if(txtSearch.getText().toString().equalsIgnoreCase("dell")){
                    Intent intent = new Intent(HomeActivity.this, DellActivity.class);
                    startActivity(intent);
                }else if(txtSearch.getText().toString().equalsIgnoreCase("asus")){
                    Intent intent = new Intent(HomeActivity.this, AsusActivity.class);
                    startActivity(intent);

                }else{
                    createDialog2("Không tìm thấy sản phẩm\nVui lòng tìm kiếm lại");
                }
            }
        });

        showProductNew();
        showProductLaptopStudent();
        showProductLaptopGaming();
    }


    public void showProductNew() {
        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager lnm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(lnm);
        ArrayList<LapTop> list = new ArrayList<>();

        list.add(new LapTop(1,"DELL vivobook X507UF","core i5","8GB DDR4","HDD 1TB", 16900000.0,R.drawable.new1,"15.6 inch","DELL"));
        list.add(new LapTop(2,"DELL vivobook S530","Core i7 9900K","8GB DDR4","SSD 250GB",25900000.0,R.drawable.new4, "14 inch","DELL"));
        list.add(new LapTop(3,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","DELL"));
        list.add(new LapTop(4,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new3,"15.5 inch","ASUS"));
        list.add(new LapTop(5,"DELL Inspiron N4522","Core i3 9900K","8GB DDR4","SSD 1TB",18900000.0,R.drawable.new4,"> 15.6 inch","ASUS"));
        list.add(new LapTop(6,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","ASUS"));
        list.add(new LapTop(7,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new5,"15.5 inch","ASUS"));

        AdapterHome ap = new AdapterHome(list, getApplicationContext());
        rv.setAdapter(ap);
    }

    public void showProductLaptopStudent() {
        RecyclerView rv = findViewById(R.id.recycler_view_student);
        rv.setHasFixedSize(true);
        LinearLayoutManager lnm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lnm);
        ArrayList<LapTop> list = new ArrayList();
        list.add(new LapTop(1,"DELL vivobook X507UF","core i5","8GB DDR4","HDD 1TB", 16900000.0,R.drawable.new1,"15.6 inch","DELL"));
        list.add(new LapTop(2,"DELL vivobook S530","Core i7 9900K","8GB DDR4","SSD 250GB",25900000.0,R.drawable.new4, "14 inch","DELL"));
        list.add(new LapTop(3,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","DELL"));
        list.add(new LapTop(4,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new3,"15.5 inch","ASUS"));
        list.add(new LapTop(5,"DELL Inspiron N4522","Core i3 9900K","8GB DDR4","SSD 1TB",18900000.0,R.drawable.new4,"> 15.6 inch","ASUS"));
        list.add(new LapTop(6,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","ASUS"));
        list.add(new LapTop(7,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new5,"15.5 inch","ASUS"));
        AdapterHome ap = new AdapterHome(list, getApplicationContext());
        rv.setAdapter(ap);

    }

    public void showProductLaptopGaming() {
        RecyclerView rv = findViewById(R.id.recycler_view_gaming_graphic);
        rv.setHasFixedSize(true);
        LinearLayoutManager lnm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lnm);
        ArrayList<LapTop> list = new ArrayList();
        list.add(new LapTop(1,"DELL vivobook X507UF","core i5","8GB DDR4","HDD 1TB", 16900000.0,R.drawable.new1,"15.6 inch","DELL"));
        list.add(new LapTop(2,"DELL vivobook S530","Core i7 9900K","8GB DDR4","SSD 250GB",25900000.0,R.drawable.new4, "14 inch","DELL"));
        list.add(new LapTop(3,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","DELL"));
        list.add(new LapTop(4,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new3,"15.5 inch","ASUS"));
        list.add(new LapTop(5,"DELL Inspiron N4522","Core i3 9900K","8GB DDR4","SSD 1TB",18900000.0,R.drawable.new4,"> 15.6 inch","ASUS"));
        list.add(new LapTop(6,"DELL vivobook X213","Core i5 9900K","4GB DDR4","SSD 128GB",30900000.0,R.drawable.new2,"15.6 inch","ASUS"));
        list.add(new LapTop(7,"DELL Inspiron N3480","Core i3 9900K","8GB DDR4","SSD 1TB",12900000.0,R.drawable.new5,"15.5 inch","ASUS"));
        AdapterHome ap = new AdapterHome(list, getApplicationContext());
        rv.setAdapter(ap);
    }

    public void showPopupMenu() {
        PopupMenu mn = new PopupMenu(this, popupmenu);
        mn.getMenuInflater().inflate(R.menu.menu_popup, mn.getMenu());
        email = getIntent().getExtras().getString("email");
        mn.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnaccount: {
                        Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
                        i.putExtra("email1", email);
                        startActivity(i);
                        break;
                    }
                    case R.id.mndell: {
                        Intent i = new Intent(HomeActivity.this, DellActivity.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.mnasus:{
                        Intent i = new Intent(HomeActivity.this, AsusActivity.class);
                        startActivity(i);
                        break;
                    }

                    case R.id.mncpass: {
                        Intent i = new Intent(HomeActivity.this, ChangePass2Activity.class);
                        i.putExtra("email2", email);
                        startActivity(i);
                        break;
                    }

                    case R.id.mnlogout: {
                        createDialog();
                        break;
                    }

                }

                return false;
            }
        });
        mn.show();
    }

    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn đăng xuất hay không ?")
                .setCancelable(false)
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void createDialog2(String mess){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.drawable.notice);
        alertDialog.setMessage(mess);
        alertDialog.show();
    }
}
