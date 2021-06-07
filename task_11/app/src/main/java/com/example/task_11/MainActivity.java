package com.example.task_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

  private   EditText editText;
   private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        textView=(TextView) findViewById(R.id.textView);
    }

    public void read(View view){
        try {
            FileInputStream fileInput = openFileInput("example.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while ((lines=buffer.readLine())!=null)     {
                strBuffer.append(lines+"\n");
            }
            textView.setText(strBuffer.toString());
             } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
          e.printStackTrace();
        };

    }

    public void write(View view){
String myTxt = editText.getText().toString();
try{
    FileOutputStream fileOutput = openFileOutput("task.txt", MODE_PRIVATE);
    fileOutput.write(myTxt.getBytes());
    fileOutput.close();
    editText.setText("");
    Toast.makeText(MainActivity.this, "saved",Toast.LENGTH_LONG).show();
} catch (FileNotFoundException e){

    e.printStackTrace();

}catch (IOException e){
    e.printStackTrace();
}

    }



}