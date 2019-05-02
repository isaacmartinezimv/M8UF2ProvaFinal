package com.example.isaac.m8uf2provafinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.musicItem:
                Toast.makeText(this, "MusicaPlay", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
        }
            return super.onOptionsItemSelected(item);
    }

}
