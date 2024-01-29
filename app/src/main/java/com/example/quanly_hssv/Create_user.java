package com.example.quanly_hssv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Create_user extends AppCompatActivity {
Button btn_create_u, btn_nocreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        btn_create_u = findViewById(R.id.btn_create_user);
        btn_nocreate = findViewById(R.id.btn_noCreate);

        btn_create_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_user.this, Login.class);
                startActivity(intent);
            }
        });
        btn_nocreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_user.this, Login.class);
                startActivity(intent);
            }
        });

    }
}