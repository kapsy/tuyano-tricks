package nz.kapsy.sampleappwidget;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class SampleAppWidget extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        MySimpleView view = new MySimpleView
                (getApplication());
            view.setMessage("onCreateから作ってみる");
            view.setMessageColor(Color.DKGRAY);
            view.setMessageSize(16);
            view.setDrawColor(Color.GREEN);
            view.setW(200);
            view.setH(100);
            setContentView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
}
