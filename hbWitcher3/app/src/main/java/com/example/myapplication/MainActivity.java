package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        private ListView list;
        private String[] array;
        private ArrayAdapter adapter;
        private Toolbar toolbar;
        private int category_index;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            list = findViewById(R.id.listView);
            array = getResources().getStringArray(R.array.fish_array);
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList(Arrays.asList(array)));
            list.setAdapter(adapter);
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                    intent.putExtra("category",category_index);
                    intent.putExtra("position",position);
                    startActivity(intent);

                }
            });

        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            toolbar.setTitle(R.string.fish);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

//noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
// Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.id_fish) {

                fillArray(R.string.fish,R.array.fish_array,0 );

            }
            else if
            (id == R.id.id_na)
            {

                fillArray(R.string.na,R.array.na_array,1 );
            }
            else if (id == R.id.id_sna)
            {
                toolbar.setTitle(R.string.sna);
                array = getResources().getStringArray(R.array.sna_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index = 2;
            }
            else if (id == R.id.id_pri)
            {
                toolbar.setTitle(R.string.pri);
                array = getResources().getStringArray(R.array.pri_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index = 3;
            }
            else if (id == R.id.id_history)
            {
                toolbar.setTitle(R.string.history);
                array = getResources().getStringArray(R.array.history_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index = 4;
            }
            else if (id == R.id.id_advice)
            {
                toolbar.setTitle(R.string.advice);
                array = getResources().getStringArray(R.array.advice_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index = 5;
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        private void fillArray(int title,int arrayList,int index )
        {
            toolbar.setTitle(title);
            array = getResources().getStringArray(arrayList);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index = index;
        }
    }