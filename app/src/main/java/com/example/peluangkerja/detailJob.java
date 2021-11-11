package com.example.peluangkerja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class detailJob extends AppCompatActivity {

    ListView lvqual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);
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
}