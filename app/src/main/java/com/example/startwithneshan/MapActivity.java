package com.example.startwithneshan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.neshan.mapsdk.MapView;

public class MapActivity extends AppCompatActivity {



    MapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        map=findViewById(R.id.map);
    }
}