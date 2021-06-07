package com.example.task_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    String[] mashina ={"Reno", "Hyondai", "Toyota", "Lexus" }; ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lsView = (ListView) findViewById(R.id.autoList);
        final ImageView imView= (ImageView) findViewById(R.id.imageView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, mashina);
        // устанавливаем для списка адаптер
        lsView.setAdapter(adapter);
        lsView.setOnItemClickListener(new  AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // по позиции получаем выбранный элемент
                String selectedItem = mashina[position];

                if (selectedItem.equals("Reno")) {
                    imView.setImageResource(R.drawable.reno);
                } else if (selectedItem.equals("Hyondai")) {
                    imView.setImageResource(R.drawable.hyndai);
                } else if (selectedItem.equals("Toyota")) {
                    imView.setImageResource(R.drawable.toyota);
                } else {
                    imView.setImageResource(R.drawable.lexus);
                }


            }
        });
    }


}
//imgview.setImageDrawable(null);