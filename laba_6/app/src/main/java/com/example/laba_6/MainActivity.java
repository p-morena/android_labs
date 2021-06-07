package com.example.laba_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imView = (ImageView) findViewById(R.id.imageView);
        final TextView textView = (TextView) findViewById(R.id.textView);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.auto, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Вызываем адаптер
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);

                if (item.equals("Reno")) {
                    imView.setImageResource(R.drawable.reno);
                    textView.setText(item);
                } else if (item.equals("Hyondai")) {
                    imView.setImageResource(R.drawable.hyndai);
                    textView.setText(item);
                } else if (item.equals("Toyota")) {
                    imView.setImageResource(R.drawable.toyota);
                    textView.setText(item);
                } else if (item.equals("BMV")) {
                    imView.setImageResource(R.drawable.bmv);
                    textView.setText(item);
                } else if (item.equals("Nissan")) {
                    imView.setImageResource(R.drawable.nissan);
                    textView.setText(item);
                } else if (item.equals("Subaru")) {
                    imView.setImageResource(R.drawable.subaru);
                    textView.setText(item);
                }  else if (item.equals("Ford")) {
                imView.setImageResource(R.drawable.ford);
                textView.setText(item);
                } else if (item.equals("Volkswagen")) {
                imView.setImageResource(R.drawable.volkswagen);
                textView.setText(item);
                } else if (item.equals("Honda")) {
                imView.setImageResource(R.drawable.honda);
                textView.setText(item);
                }    else {
                    imView.setImageResource(R.drawable.lexus);
                    textView.setText(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
}