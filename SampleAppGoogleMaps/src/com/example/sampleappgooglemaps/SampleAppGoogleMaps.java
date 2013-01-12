package com.example.sampleappgooglemaps;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class SampleAppGoogleMaps extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MapView map1 = (MapView)findViewById(R.id.map1);
        MapController controller = map1.getController();
        GeoPoint latlng = new GeoPoint(35681126,139767251);
        controller.setCenter(latlng);
        controller.setZoom(12);
        map1.setClickable(true);
        map1.setBuiltInZoomControls(true);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
