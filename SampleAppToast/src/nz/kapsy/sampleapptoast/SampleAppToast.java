package nz.kapsy.sampleapptoast;

import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class SampleAppToast extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toast toast = Toast.makeText(this, "これがトースト！", Toast.LENGTH_LONG);
        toast.show();
    }

}