package nz.kapsy.sampleapprotateprob;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SampleAppRotateProb extends Activity {
    private TextView text1;
    private EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text1 = (TextView)this.findViewById(R.id.textView1);
        edit1 = (EditText)this.findViewById(R.id.editText1);
        Button btn = (Button)this.findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("入力：" + edit1.getText());
            }
        });
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String s = (String)text1.getText() + "(回転前に保存)";
        outState.putString("MESSAGE", s);
    }
     
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String s = savedInstanceState.getString("MESSAGE");
        text1.setText(s);
    }
    
    
}


