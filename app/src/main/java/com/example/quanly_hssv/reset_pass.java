package com.example.quanly_hssv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reset_pass extends AppCompatActivity {
Button btn_OK_re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        btn_OK_re = findViewById(R.id.btn_OK_reset);

        btn_OK_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reset_pass.this, Login.class);
                startActivity(intent);
            }
        });
    }
}