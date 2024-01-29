package com.example.quanly_hssv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
Button btn_login;
TextView btn_create, btn_reset;
EditText tendangnhap, matkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login= findViewById(R.id.btn_Login);
        btn_create = findViewById(R.id.txt_dangky);
        btn_reset = findViewById(R.id.txt_resetpass);
        tendangnhap = findViewById(R.id.edt_tendangnhap);
        matkhau = findViewById(R.id.edt_matkhau);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voidlogin();
            }
        });

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Create_user.class);
                startActivity(intent);
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, reset_pass.class);
                startActivity(intent);
            }
        });

    }
    private void voidlogin(){
        String edt_ten = tendangnhap.getText().toString().trim();
        Name_user.tendangnhap = edt_ten;

        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }
}