package nz.kapsy.sampleapptouchevent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.*;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.*;
 
public class SampleAppTouchEvent extends Activity {
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
    }
 
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Toast toast = Toast.makeText(this,"X: " + x + "\nY: " + y,
                Toast.LENGTH_LONG);
        toast.show();
        return false;
    }
     
}