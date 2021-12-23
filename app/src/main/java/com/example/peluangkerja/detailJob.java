package com.example.peluangkerja;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class detailJob extends AppCompatActivity {

    ListView lvqual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);
        initToolbar();
        lvqual = findViewById(R.id.lvQualif);
        String[] qualify = new String[] {
                "Wanita berusia maks 27",
                "Minimal lulusan SMK / SMA sederajat",
                "Memiliki laptop pribadi",
                "Memiliki skill design yang mumpuni",
                "Masih jomblo gak boleh taken",
                "Gak suka seblak",
                "Kalau ditanya mau makan dimana gak jawab terserah"
        };

        // Create a List from String Array elements
        final List<String> qual_list = new ArrayList<String>(Arrays.asList(qualify));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, qual_list);

        // DataBind ListView with items from ArrayAdapter

        lvqual.setAdapter(arrayAdapter);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Detail Job");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}