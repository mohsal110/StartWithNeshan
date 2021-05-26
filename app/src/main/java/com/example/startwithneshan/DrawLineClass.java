package com.example.startwithneshan;

import android.content.Context;
import android.view.View;

import com.carto.graphics.Color;
import com.carto.styles.LineStyle;
import com.carto.styles.LineStyleBuilder;

import org.neshan.common.model.LatLng;
import org.neshan.mapsdk.MapView;
import org.neshan.mapsdk.model.Polyline;

import java.util.ArrayList;

public class DrawLineClass {


    Context context;
    MapView map;
    View view;

    public DrawLineClass(Context context, MapView map){
        this.context=context;
        this.map=map;
    }

    // Drawing line on map
    public Polyline drawLine(){
        // Adding some LatLng points to a latLngs
        ArrayList<LatLng> latLngs = new ArrayList<>();
        latLngs.add(new LatLng(51.327650, 35.769368));
        latLngs.add(new LatLng(51.323889, 35.756670));
        latLngs.add(new LatLng(51.383889, 35.746670));
        // Creating a line from LineGeom. here we use getLineStyle() method to define line styles
        Polyline polyline = new Polyline(latLngs, getLineStyle());
        // adding the created line to lineLayer, showing it on map
        map.addPolyline(polyline);
        // focusing camera on first point of drawn line
        map.moveCamera(new LatLng(51.327650, 35.769368),0.25f );
        map.setZoom(14,0);
        return polyline;
    }

    private LineStyle getLineStyle(){
        LineStyleBuilder lineStCr = new LineStyleBuilder();
        lineStCr.setColor(new Color((short) 2, (short) 119, (short) 189, (short)190));
        lineStCr.setWidth(12f);
        lineStCr.setStretchFactor(0f);
        return lineStCr.buildStyle();
    }
    private void deletePlyLine(Polyline polyline){
        map.removePolyline(polyline);
    }
}
