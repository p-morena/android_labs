package com.example.task_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView mesClick;
private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesClick=(TextView)findViewById(R.id.textView);
    }

    public  void onScreenClick(View view){
          counter++;

          mesClick.setText(String.valueOf(counter));
          if (counter%3==0){
              Toast toast = Toast.makeText(getApplicationContext(),
                      "Кликнули "+counter+" раза",
                      Toast.LENGTH_SHORT);
              toast.setGravity(Gravity.CENTER, 0, 0);
              toast.show();
          }

    }
}