package com.example.applaptop.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applaptop.Model.Database;
import com.example.applaptop.Model.User;
import com.example.applaptop.R;

public class ChangePass2Activity extends AppCompatActivity {
    private Button btnChangePass;
    private EditText txtoldpass, txtnewpass, txtrepass;
    private Database database;
    private String email;
    private User s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_logining);
        database = new Database(this);
        // anh xa
        btnChangePass = findViewById(R.id.btnchangepass);
        txtnewpass = findViewById(R.id.txtnewpass);
        txtoldpass = findViewById(R.id.txtoldpass);
        txtrepass = findViewById(R.id.txtrepass);

        email = getIntent().getExtras().getString("email2").trim();
          s = database.getUser(email);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            String oldp = txtoldpass.getText().toString();
            String newp = txtnewpass.getText().toString();
            String rep = txtrepass.getText().toString();
            @Override
            public void onClick(View v) {
                if (!oldp.equals(s.getPassword())) {
                    createDialog("Mật khẩu không chính xác");
                }else if(newp.length() < 5){
                    createDialog("Mật khẩu từ 5 ký tự trở lên");
                } else if (!newp.equals(rep)) {
                    createDialog("Mật khẩu nhập lại không khớp");
                } else {
                    if (database.changePassword(s.getEmail(), rep)) {
                        createDialog("Đổi mật khẩu thành công");
                    } else {
                        createDialog("ERROR: Vui lòng thử lại");
                    }
                }
            }
        });
    }

    public void createDialog(String mess) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.drawable.notice);
        alertDialog.setMessage(mess);
        alertDialog.show();
    }
}
