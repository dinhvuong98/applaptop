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

public class ForgotPassActivity extends AppCompatActivity {
    private Button btnChangePass;
    private EditText txtphone, txtemail;
    private Database database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btnChangePass = findViewById(R.id.btnConfirm);
        txtphone = findViewById(R.id.txtphone);
        txtemail = findViewById(R.id.txtemail);

        database = new Database(this);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString();
                String phone = txtphone.getText().toString();
                if(database.checkPhone_Email(phone,email)) {
                    Intent intent = new Intent(ForgotPassActivity.this, ChangePassForgotActivity.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }else{
                    createDialog("Dữ liệu không chính xác.");
                }
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
