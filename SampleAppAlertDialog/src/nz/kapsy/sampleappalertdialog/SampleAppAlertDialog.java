package nz.kapsy.sampleappalertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.*;
import android.view.Window;

import android.app.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class SampleAppAlertDialog extends Activity {
    private TextView text1;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text1 = (TextView)this.findViewById(R.id.text);
         
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("これはアラートのテストです。");
        DialogInterface.OnClickListener oklistener = new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int button){
                text1.setText("OKしたよ!");
            }
        };
        DialogInterface.OnClickListener cancellistener = new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int button){
                text1.setText("キャンセルされました...");
            }
        };
        builder.setNeutralButton("おっけー!", oklistener);
        builder.setNegativeButton("cancel", cancellistener);
        builder.show();
    }
 
}