package com.example.applaptop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applaptop.Model.Database;
import com.example.applaptop.R;


public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText pass;
    private EditText repass;
    private Button back;
    private Database database;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = new Database(this);

        anhXa();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString().trim();
                String pw = pass.getText().toString().trim();
                String rp = repass.getText().toString().trim();
                String n = name.getText().toString().trim();
                String sdt = phone.getText().toString().trim();

                if(em.equals("") || pw.equals("") || n.equals("") || sdt.equals("")){
                    createDialog("Xin mời nhập dữ liệu");
                }else {
                    if (database.checkEmail(em)) {
                        createDialog("Email này đã được sử dụng");
                    } else if (!pw.equals(rp)) {
                        createDialog("Mật khẩu nhập lại không đúng");
                    } else if (pw.length() < 5) {
                        createDialog("Mật khẩu bao gồm 5 ký tự");
                    } else {
                        if(database.insert(em, rp, n, sdt)) {
                            createDialog("Đăng ký thành công\nEmail: " + em + "\nPassword: " + rp);
                        }
                    }
                }
            }
        });

        back = findViewById(R.id.back_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void anhXa(){
        btnRegister = findViewById(R.id.buttonRegister);
        repass = findViewById(R.id.repass);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);

    }

    public void createDialog(String mess) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo !");
        alertDialog.setMessage(mess);
        alertDialog.setIcon(R.drawable.notice);
        alertDialog.show();
    }
}
