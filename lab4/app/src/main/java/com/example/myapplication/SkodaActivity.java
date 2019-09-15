package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SkodaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skoda);
        ListView listView = (ListView) findViewById(R.id.skodaList);
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0){
                Intent intent = new Intent(SkodaActivity.this,OctaviaActivity.class);
                startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(SkodaActivity.this,FabiaActivity.class);
                startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(SkodaActivity.this,FeliciaActivity.class);
                startActivity(intent);
            }
        }
    };

}
