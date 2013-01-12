package nz.kapsy.sampleapprotateinfo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.content.res.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SampleAppRotateInfo extends Activity {
    private Activity me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        me = this;
        Button btn = (Button)this.findViewById(R.id.button1);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                Configuration config = resources.getConfiguration();
                int orientation = config.orientation;
                String msg = "不明。";
                switch(orientation){
                case Configuration.ORIENTATION_PORTRAIT:
                    msg = "ポートレイト！";
                    break;
                case Configuration.ORIENTATION_LANDSCAPE:
                    msg = "ランドスケープ！";
                    break;
                }
                Toast toast = Toast.makeText(me, msg, Toast.LENGTH_LONG);
                toast.show();
        }});
    }
}