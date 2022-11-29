package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Model.Thi;

public class Detail extends AppCompatActivity {
    private Thi item;
    private TextView tvTitle;
    private EditText exTv;
    private TextView tvCongThuc;
    private Button btnSave;
    String save;
    private TextView tvList;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();


    }
    private void init(){
        Intent i = getIntent();
        item = (Thi) i.getSerializableExtra("item");

        tvTitle=findViewById(R.id.title);
        exTv=findViewById(R.id.exTv);

        btnSave=findViewById(R.id.saveBtn);

        tvList=findViewById(R.id.listTv);
        tvCongThuc=findViewById(R.id.congThuc);
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        save=sharedPreferences.getString(String.valueOf(item.getId()),"");





        tvTitle.setText(item.getName());
        tvList.setText(save);
        tvCongThuc.setText("Công thức: "+item.getCongThuc());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exTv.getText().toString().isEmpty()){
                    Toast.makeText(Detail.this, "nhập ví dụ", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove(String.valueOf(item.getId()));
                    save=exTv.getText()+"\n"+save;
                    editor.putString(String.valueOf(item.getId()),save);
                    editor.commit();
                    tvList.setText(save);
                    exTv.setText("");
                }
            }
        });

    }
}