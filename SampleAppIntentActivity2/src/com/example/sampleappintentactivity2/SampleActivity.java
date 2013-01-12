package com.example.sampleappintentactivity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class SampleActivity extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.sample);
        TextView text1 = (TextView)this.findViewById(R.id.text1);

        // Intentを、Activityの「getIntent」で取得します。続いて、
        // このIntentから、受渡されたデータを取り出します。
        Intent intent = this.getIntent();
        String str = intent.getStringExtra("data");
        text1.setText("data: " + str);
    }

}