package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHello = (TextView)findViewById(R.id.textView2);
    }

    public void onClick(View view) {
          mHello.setVisibility(View.VISIBLE);

    }

    public void onMyButtonClick(View view){
        mHello.setVisibility(View.INVISIBLE);
    }
}

