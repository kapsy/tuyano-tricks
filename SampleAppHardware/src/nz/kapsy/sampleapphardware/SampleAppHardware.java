package nz.kapsy.sampleapphardware;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.util.List;

import android.hardware.*;
import android.widget.TextView;

public class SampleAppHardware extends Activity
        implements SensorEventListener {
    private SensorManager manager;
    private TextView text1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text1 = (TextView)this.findViewById(R.id.text);
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            manager.registerListener(this, sensor,
                    SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {}

    @Override
    public void onSensorChanged(SensorEvent event) {
        String result = "";
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            result = "Gx: " + String.valueOf(event.values[0]) + "\n";
            result += "Gy: " + String.valueOf(event.values[1]) + "\n";
            result += "Gz: " + String.valueOf(event.values[2]);
        }
        text1.setText(result);
    }

}