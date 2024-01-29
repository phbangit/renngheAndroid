package com.example.quanly_hssv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInformationDuan extends AppCompatActivity {

    TextView txtTitle,txtCredit,txtTime,txtPlace;
    Button btn_trove;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_duan);

        btn_trove = findViewById(R.id.luive);

        txtCredit = findViewById(R.id.txtSubjectCredit);
        txtPlace = findViewById(R.id.txtSubjectPlace);
        txtTime = findViewById(R.id.txtSubjectTime);
        txtTitle = findViewById(R.id.txtSubjectTitle);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");

        txtTitle.setText(title);
        txtCredit.setText(credit+"");
        txtTime.setText(time);
        txtPlace.setText(place);

        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ActivityInformationDuan.this, ActivityDuan.class);
                startActivity(intent1);
            }
        });

    }
}