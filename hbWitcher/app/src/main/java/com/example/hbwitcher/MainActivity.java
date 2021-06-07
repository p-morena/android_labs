package com.example.hbwitcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private Intent intent;
private int category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        array = getResources().getStringArray(R.array.person);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("position", position);
                intent.putExtra("category", category);

                startActivity(intent);
            }
        });

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            toolbar.setTitle(R.string.person);
            return true;
        }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();}
    }

    @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){
            int id = item.getItemId();
            if (id == R.id.person) {

                fillArray(R.string.person, R.array.person, 0);


            } else if (id == R.id.monster) {

                fillArray(R.string.monster, R.array.monster, 1);


            } else if (id == R.id.animal) {

                fillArray(R.string.animal, R.array.animal, 2);


            } else if (id == R.id.elixir) {

                fillArray(R.string.elixir, R.array.elixir, 3);

            } else if (id == R.id.sword) {

                fillArray(R.string.sword, R.array.sword, 4);

            } else if (id == R.id.magic) {

                fillArray(R.string.magic, R.array.magic, 5);

            } else if (id == R.id.about) {
                toolbar.setTitle(R.string.about);
                intent = new Intent(MainActivity.this, About_Content.class);
                startActivity(intent);

            }
            drawer.closeDrawer(GravityCompat.START);

            return true;
        }

        private void fillArray ( int title, int arrayList, int index){
            toolbar.setTitle(title);
            array = getResources().getStringArray(arrayList);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category = index;
        }



}