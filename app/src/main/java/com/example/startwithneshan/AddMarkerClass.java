package com.example.startwithneshan;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.carto.styles.AnimationStyle;
import com.carto.styles.AnimationStyleBuilder;
import com.carto.styles.AnimationType;
import com.carto.styles.MarkerStyle;
import com.carto.styles.MarkerStyleBuilder;
import com.carto.utils.BitmapUtils;

import org.neshan.common.model.LatLng;
import org.neshan.mapsdk.MapView;
import org.neshan.mapsdk.model.Marker;

public class AddMarkerClass {

    Context context;
    MapView map;


    AnimationStyle animSt;

    public AddMarkerClass(Context context,MapView map){
        this.context=context;
        this.map=map;

    }
    // We use findViewByID for every element in our layout file here
    private void initViews(){
//        map = findViewById(R.id.map);
    }
    // Initializing layout references (views, map and map events)
    public void initLayoutReferences() {
        // Initializing views
        //initViews();

        // when clicked on map, a marker is added in clicked location
        map.setOnMapClickListener(latLng -> {

            //set marker on each location that user clicked on it
            map.addMarker(createMarker(latLng));
        });
        // when on marker clicked, change marker style to blue
        map.setOnMarkerClickListener(marker1 -> {
            //changeMarkerToBlue(marker1);
        });
    }

    // This method gets a LatLng as input and adds a marker on that position
    private Marker createMarker(LatLng loc) {

        // Creating animation for marker. We should use an object of type AnimationStyleBuilder, set
        // all animation features on it and then call buildStyle() method that returns an object of type
        // AnimationStyle
        AnimationStyleBuilder animStBl = new AnimationStyleBuilder();
        animStBl.setFadeAnimationType(AnimationType.ANIMATION_TYPE_SMOOTHSTEP);
        animStBl.setSizeAnimationType(AnimationType.ANIMATION_TYPE_SPRING);
        animStBl.setPhaseInDuration(0.5f);
        animStBl.setPhaseOutDuration(0.5f);
        animSt = animStBl.buildStyle();

        // Creating marker style. We should use an object of type MarkerStyleCreator, set all features on it
        // and then call buildStyle method on it. This method returns an object of type MarkerStyle
        MarkerStyleBuilder markStCr = new MarkerStyleBuilder();
        markStCr.setSize(30f);
        markStCr.setBitmap(BitmapUtils.createBitmapFromAndroidBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_marker)));
        // AnimationStyle object - that was created before - is used here
        markStCr.setAnimationStyle(animSt);
        MarkerStyle markSt = markStCr.buildStyle();

        // Creating marker
        return new Marker(loc, markSt);
    }

    /***
     * for removing marker from map we use :
     * map.removeMarker(marker);
     *
     */
}
