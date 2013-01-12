package nz.kapsy.sampleappgps;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.content.Context;
import android.location.*;
import android.widget.TextView;

public class SampleAppGPS extends Activity
        implements LocationListener {
    private LocationManager manager;
    private TextView text1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text1 = (TextView)this.findViewById(R.id.text);
        manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }

    @Override
    public void onLocationChanged(Location loc) {
        double lat = loc.getLatitude();
        double lgt = loc.getLongitude();
        text1.setText("Lat: " + lat + "\nLgt: " + lgt);
    }

    @Override
    public void onProviderDisabled(String arg0) {}

    @Override
    public void onProviderEnabled(String arg0) {}

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}

}