package com.example.sampleappintentactivity2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.content.Intent;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SampleAppIntentActivity2 extends Activity {
    private EditText edit;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        edit = (EditText)this.findViewById(R.id.edit);
        Button button =
             (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new MyClickAdapter());
    }

    class MyClickAdapter implements OnClickListener {
        @Override
        public void onClick(View v) {
            Editable str = edit.getText();
            Intent intent = new Intent(
                getApplicationContext(),
                com.example.sampleappintentactivity2.SampleActivity.class);
            intent.putExtra("data", str.toString());
            startActivity(intent);
        }
    }

}