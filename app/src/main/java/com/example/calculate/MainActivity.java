package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.ListViewAdapter;
import Adapter.Swap;
import Model.Thi;

public class MainActivity extends AppCompatActivity implements Swap {
    private ListView listView;
    private List<Thi> list;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){

        listView = findViewById(R.id.listView);
        list= new ArrayList<>();
        getData();
        adapter = new ListViewAdapter(list,this,R.layout.item_calculate);
        listView.setAdapter(adapter);

    }
    private void getData(){

        list.add(new Thi("Thì hiện tại đơn","S + V(s/es) + O",1));
        list.add(new Thi("Thì hiện tại tiếp diễn","S + am/is/are + V_ing",2));
        list.add(new Thi("Thì hiện tại hoàn thành","S + have/has + V3/ed + O",3));
        list.add(new Thi("Thì hiện tại hoàn thành tiếp diễn","S + have/has + been + V_ing",4));
        list.add(new Thi("Thì quá khứ đơn","S + V2/ed + O",5));
        list.add(new Thi("Thì quá khứ tiếp diễn","S + was/were + V_ing + O",6));
        list.add(new Thi("Thì quá khứ hoàn thành","S + had + V3/ed + O",7));
        list.add(new Thi("Thì quá khứ hoàn thành tiếp diễn","S + had been + V_ing + O",8));

    }

    @Override
    public void swap(Thi item) {
        Intent i = new Intent(MainActivity.this,Detail.class);
        i.putExtra("item",item);
        startActivity(i);
    }



}