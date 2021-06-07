package com.example.task_2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtLetter;
    private EditText txtString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLetter=(EditText)findViewById(R.id.editTextTextPersonName);
        txtString=(EditText)findViewById(R.id.editTextTextPersonName2);

    }

    public void clickSearch(View view){

        String str1 = txtLetter.getText().toString();
        String str2 = txtString.getText().toString();
        char ch = str1.charAt(0);
        int counter=1;
        char[] result= str2.toCharArray();
        for(int i=0; i < result.length; i++){
            if(ch == result[i]){
           Toast toast = Toast.makeText(getApplicationContext(),
                "символ совпал "+ counter++ +" раз",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
            }
        }
    }
    public void clickClean(View view){
    txtLetter.setText("");
    txtString.setText("");


    }




}