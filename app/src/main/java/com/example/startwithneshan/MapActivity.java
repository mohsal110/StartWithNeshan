package com.example.startwithneshan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.carto.styles.AnimationStyle;
import com.carto.styles.AnimationStyleBuilder;
import com.carto.styles.AnimationType;
import com.carto.styles.MarkerStyle;
import com.carto.styles.MarkerStyleBuilder;
import com.carto.utils.BitmapUtils;

import org.neshan.common.model.LatLng;
import org.neshan.mapsdk.MapView;
import org.neshan.mapsdk.model.Marker;

public class MapActivity extends AppCompatActivity {



    MapView map;
    AnimationStyle animSt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        map=findViewById(R.id.map);

        ///starting app in full screen
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // everything related to ui is initialized here
        initLayoutReferences();
    }

    // We use findViewByID for every element in our layout file here
    private void initViews(){
//        map = findViewById(R.id.map);
    }
    // Initializing layout references (views, map and map events)
    private void initLayoutReferences() {
        // Initializing views
        //initViews();
        AddMarkerClass addMarkerClass = new AddMarkerClass(getApplicationContext(), map);
        addMarkerClass.initLayoutReferences();


    }

}