package com.example.task_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView txt1, txt2, txt3,  txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(TextView)findViewById(R.id.textView);
        txt2=(TextView)findViewById(R.id.textView2);
        txt3=(TextView)findViewById(R.id.textView3);
        txt4=(TextView)findViewById(R.id.textView4);
    }

    public void onClick1(View view){
        txt1.setVisibility(view.VISIBLE);
        txt2.setVisibility(view.INVISIBLE);
        txt3.setVisibility(view.INVISIBLE);
        txt4.setVisibility(view.INVISIBLE);
    }

    public void onClick2(View view){
        txt1.setVisibility(view.INVISIBLE);
        txt2.setVisibility(view.VISIBLE);
        txt3.setVisibility(view.INVISIBLE);
        txt4.setVisibility(view.INVISIBLE);
    }

    public void onClick3(View view){
        txt1.setVisibility(view.INVISIBLE);
        txt2.setVisibility(view.INVISIBLE);
        txt3.setVisibility(view.VISIBLE);
        txt4.setVisibility(view.INVISIBLE);
    }


    public void onClick4(View view){
        txt1.setVisibility(view.INVISIBLE);
        txt2.setVisibility(view.INVISIBLE);
        txt3.setVisibility(view.INVISIBLE);
        txt4.setVisibility(view.VISIBLE);
    }









}