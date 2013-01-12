package nz.kapsy.sampleappoptionmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.*;
import android.view.*;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.*;

public class SampleAppOptionMenu extends Activity {
    private Activity me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me = this;
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item1 = menu.add("Toast");
        MenuItem item2 = menu.add("Alert");
        OnMenuItemClickListener listener1 = new OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                Toast toast = Toast.makeText(me,"トーストです。",Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        };
        OnMenuItemClickListener listener2 = new OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                AlertDialog.Builder builder = new AlertDialog.Builder(me);
                builder.setMessage("アラートだよ。");
                builder.show();
                return false;
            }
        };
        item1.setOnMenuItemClickListener(listener1);
        item2.setOnMenuItemClickListener(listener2);
        return true;
    }

}