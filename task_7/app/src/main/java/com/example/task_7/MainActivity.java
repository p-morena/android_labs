package com.example.task_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView textView = (TextView) findViewById(R.id.textView);
            GridView gridView = (GridView) findViewById(R.id.gridview);

            //Создаем пример класса ImageAdapter:
            gridView.setAdapter((ListAdapter) new ImageAdapter(this));


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {

                    //Отправляем id изображения в класс FullImageActivity:
                   /* Intent i = new Intent(String.valueOf(getApplicationContext()));
                    //Передаем необходимый index:
                    i.putExtra("id", position);
                    startActivity(i);*/
                }
            });

        }
    }
