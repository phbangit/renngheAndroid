package com.example.quanly_hssv;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quanly_hssv.adapter.adapterDuan;
import com.example.quanly_hssv.database.database;
import com.example.quanly_hssv.model.Subject;

import java.util.ArrayList;

public class ActivityDuan extends AppCompatActivity {

    Toolbar toolbarSubject;
    ListView listViewSubject;
    ArrayList<Subject> ArrayListSubject;
    database database;
    adapterDuan adapterDuan;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duan);

        toolbarSubject = findViewById(R.id.toolbarSubject);
        listViewSubject = findViewById(R.id.listviewSubject);

        setSupportActionBar(toolbarSubject);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);

        ArrayListSubject = new ArrayList<>();

        Cursor cursor = database.getDataSubjects();
        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credits = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);

            ArrayListSubject.add(new Subject(id,title,credits,time,place));
        }
        adapterDuan = new adapterDuan(ActivityDuan.this,ArrayListSubject);
        listViewSubject.setAdapter(adapterDuan);
        cursor.moveToFirst();
        cursor.close();


    }
    //Nạp một menu add vào actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;
    }
    //Bắt sự kiện khi click vào Add
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuAdd:
                //Chuyển tới màn hình thêm môn học
                Intent intent = new Intent(ActivityDuan.this, ActivityAddDuan.class);
                startActivity(intent);
                break;
            default:
                Intent intent2 = new Intent(ActivityDuan.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Phương thức xóa subject
    public void delete(final int position){

        DialogDeleteSubject(position);
    }
    public void update(final int position){

        Cursor cursor = database.getDataSubjects();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            if(id == position){
                Intent intent = new Intent(ActivityDuan.this, ActivityUpdateDuan.class);
                intent.putExtra("id",position);

                String title = cursor.getString(1);
                int credits = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);

                intent.putExtra("title",title);
                intent.putExtra("credit",credits);
                intent.putExtra("time",time);
                intent.putExtra("place",place);

                startActivity(intent);
            }
        }


    }
    public void information(final int pos){


        Cursor cursor = database.getDataSubjects();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            if (id == pos) {
                Intent intent = new Intent(ActivityDuan.this, ActivityInformationDuan.class);
                intent.putExtra("id", pos);

                String title = cursor.getString(1);
                int credits = cursor.getInt(2);
                String time = cursor.getString(3);
                String place = cursor.getString(4);

                intent.putExtra("title", title);
                intent.putExtra("credit", credits);
                intent.putExtra("time", time);
                intent.putExtra("place", place);

                startActivity(intent);
            }
        }

    }

    //Dialog Update
    private void DialogDeleteSubject(int position) {

        //Tạo đối tượng cửa sổ dialog
        Dialog dialog  =  new Dialog(this);

        //Nạp layout vào
        dialog.setContentView(R.layout.dialogdeleteduan);

        //Click No mới thoát, click ngoài ko thoát
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYesDeleteSubject);
        Button btnNo = dialog.findViewById(R.id.buttonNoDeleteSubject);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new database(ActivityDuan.this);
                //Xóa trong SQL
                database.DeleteSubject(position);
                database.DeleteSubjectStudent(position);
                //Cập nhật lại listview
                Intent intent = new Intent(ActivityDuan.this, ActivityDuan.class);
                startActivity(intent);

            }
        });
        //Nếu no thì đóng dialog
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        //show dialog lên activity
        dialog.show();
    }


    //Nhấn nút back ở activity này thì chuyển qua activity được thiết lập riêng
    @Override
    public void onBackPressed() {
        counter++;
        if (counter ==1){
            Intent intent = new Intent(ActivityDuan.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

}