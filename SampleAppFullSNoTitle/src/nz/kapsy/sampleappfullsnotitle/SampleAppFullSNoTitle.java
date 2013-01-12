package nz.kapsy.sampleappfullsnotitle;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;

public class SampleAppFullSNoTitle extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);
    }

}