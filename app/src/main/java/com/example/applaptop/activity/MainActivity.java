package com.example.applaptop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applaptop.Model.Database;
import com.example.applaptop.R;


public class MainActivity extends AppCompatActivity  {
    private Button btnLogin;
    private Button btnRegister;
    private EditText username;
    private EditText password;
    private TextView forgotPass;
    private Database db;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.buttonLogin);

        db = new Database(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(email.equals("") || pass.equals("")){
                    createDialog("Xin mời nhập dữ liệu");
                }else{
                    if(db.login(email,pass) == true) {
                        createDialog("Đăng nhâp thành công");
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        i.putExtra("email",email);
                        startActivity(i);
                    }else{
                        createDialog("Sai tên đăng nhập hoặc mật khẩu \nVui lòng đăng nhập lại");
                    }
                }
            }
        });


        btnRegister = findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        forgotPass = findViewById(R.id.forgotpass);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPassActivity.class);
                startActivity(intent);
            }
        });

    }


    public void createDialog(String mess){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.drawable.notice);
        alertDialog.setMessage(mess);
        alertDialog.show();
    }
}
