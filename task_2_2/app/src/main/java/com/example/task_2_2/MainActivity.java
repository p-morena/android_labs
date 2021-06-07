package com.example.task_2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView txtV;
private EditText edTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtV =(TextView)findViewById(R.id.txtView);
        edTxt=(EditText)findViewById(R.id.editTextTextPersonName);

    }

    public void btnClick(View view){
String str = edTxt.getText().toString();
txtV.setText(String.valueOf(str));
    }

    public void btnClick1(View view){
edTxt.setText("");
txtV.setText("");
    }

}

