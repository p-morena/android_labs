package com.example.task_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton toogleButton;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toogleButton = (ToggleButton) findViewById(R.id.toggleButton);
         sw = (Switch) findViewById(R.id.switch1);
        if (sw != null) {
            sw.setOnCheckedChangeListener(this);
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Отслеживание переключения: " + (isChecked ? "on" : "off"),
                Toast.LENGTH_LONG).show();}

    public void onClick(View view){
        if (toogleButton.isChecked()==false)
            toogleButton.setText("Пуск");
        else
            toogleButton.setText("Стоп");
    }

}
