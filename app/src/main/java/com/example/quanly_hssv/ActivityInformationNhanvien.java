package com.example.quanly_hssv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInformationNhanvien extends AppCompatActivity {

    TextView edtName,edtCode,edtBirthday,edtSex;
Button btn_luive;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_nhanvien);
btn_luive = findViewById(R.id.luivenhanvien);
        edtName = findViewById(R.id.txtStudentName);
        edtSex = findViewById(R.id.txtStudentSex);
        edtBirthday = findViewById(R.id.txtStudentDateOfBirth);
        edtCode = findViewById(R.id.txtStudentCode);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String code = intent.getStringExtra("code");
        String birhday = intent.getStringExtra("birthday");

        edtCode.setText(code);
        edtBirthday.setText(birhday);
        edtSex.setText(sex);
        edtName.setText(name);

        btn_luive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ActivityInformationNhanvien.this, ActivityNhanvien.class);
                startActivity(intent1);
            }
        });
    }
}