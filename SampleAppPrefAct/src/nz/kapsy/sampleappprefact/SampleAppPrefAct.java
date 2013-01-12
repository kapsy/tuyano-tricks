package nz.kapsy.sampleappprefact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.*;

public class SampleAppPrefAct extends Activity {
    public TextView textview01;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textview01 = (TextView)findViewById(R.id.TextView01);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem pref_item = menu.add("Pref");
        OnMenuItemClickListener listener = new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                openPref();
                return false;
            }
        };
        pref_item.setOnMenuItemClickListener(listener);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123){
            String myname = SampleAppPrefActPrefActivity.getMyName(this);
            String mylist = SampleAppPrefActPrefActivity.getMyList(this);
            String res = "my Name: " + myname + "\n" + "My List: " + mylist;
            textview01.setText(res);
            Toast toast = Toast.makeText(this, res, Toast.LENGTH_LONG);
            toast.show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void openPref(){
        Intent intent = new Intent(this, (Class<?>)SampleAppPrefActPrefActivity.class);
        startActivityForResult(intent,123);
    }

}
