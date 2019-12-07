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

public class ChangePassForgotActivity extends AppCompatActivity {
    private Button btnChangePass;
    private EditText txtpass;
    private EditText txtrepass;
    private Database database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        btnChangePass = findViewById(R.id.btnchangepass);
        txtrepass = findViewById(R.id.txtrepassc);
        txtpass = findViewById(R.id.txtpassc);
        database = new Database(this);

        final String email = getIntent().getExtras().get("email").toString();
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = txtpass.getText().toString();

                String newpass = txtrepass.getText().toString();

                if (!newpass.equalsIgnoreCase(pass)) {
                    createDialog("Mật khẩu không khớp.");
                } else {
                    if (database.changePassword(email, pass)) {
                        createDialog("Mật khẩu đã được thay đổi\nXin mời đăng nhập lại");
                        Intent i = new Intent(ChangePassForgotActivity.this, MainActivity.class);
                        startActivity(i);
                    }else{
                        createDialog("ERROR: vui lòng thử lại");
                    }
                }
            }
        });
    }

    public void createDialog(String h) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Cảnh báo !!!");
        alertDialog.setMessage(h);
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.show();
    }
}
