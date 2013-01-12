package com.example.sampleappintentactivity1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleAppIntentActivity1 extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        Button button = (Button)this.findViewById(R.id.button1);
        button.setOnClickListener(new MyClickAdapter());
    }

    class MyClickAdapter implements OnClickListener {

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("http://apple.com/jp/");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }
    }

}
