package com.example.applaptop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applaptop.Model.Database;
import com.example.applaptop.Model.User;
import com.example.applaptop.R;

public class ProfileActivity extends AppCompatActivity {
    private TextView txtemail;
    private EditText edname, edphone;
    private Database database;
    ImageView edit;
    private String  email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = getIntent().getExtras().getString("email1");
        txtemail = findViewById(R.id.email);
        edname = findViewById(R.id.name);
        edphone = findViewById(R.id.phone);
        txtemail.setText(email);
        database = new Database(this);
        User s = database.getUser(email);
        edname.setText(s.getName());
        edphone.setText(s.getPhone());
        edit = findViewById(R.id.imageView);
        final String pw = s.getPassword();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Bạn có chắc chắn muốn cập nhật thông tin của mình ?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                User s2 = new User(email, pw, edphone.getText().toString(), edname.getText().toString());
                                if (database.updateInfo(s2)) {
                                    createDialog("Cập nhật thông tin thành công");
                                } else {
                                    createDialog("ERROR: Vui lòng thử lại");
                                }
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
                {

                }
            }
        });
    }

    public void createDialog(String h) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo !!!");
        alertDialog.setMessage(h);
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.show();
    }


}
