package jp.tuyano;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SampleApp extends Activity {

    private Button button;
    private EditText edit;
    private TextView text;

    private RadioGroup group;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton selradio;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sample_app);

        // コンポーネントの設定
        button = (Button)this.findViewById(R.id.button);
        edit = (EditText)this.findViewById(R.id.edit);
        text = (TextView)this.findViewById(R.id.text);

        // イベント組み込み
        button.setOnClickListener(new MyClickAdapter());

        CheckBox check = (CheckBox)this.findViewById(R.id.check1);
        check.setChecked(true);


		group = (RadioGroup)this.findViewById(R.id.group);
		radio1 = (RadioButton)this.findViewById(R.id.radio1);
		radio2 = (RadioButton)this.findViewById(R.id.radio2);


        radio2.setChecked(true);

        int selid = group.getCheckedRadioButtonId();
        selradio = (RadioButton)this.findViewById(selid);
        text.setText(selradio.getText());


        SeekBar seek = (SeekBar)this.findViewById(R.id.seek);
        int n = seek.getProgress();
        text.setText("現在の値：" +n);


        RatingBar rate = (RatingBar)this.findViewById(R.id.rate);
        float nm = rate.getRating();
        text.setText("現在の値：" +nm);

    }

    // イベントクラス
    class MyClickAdapter implements OnClickListener {
        @Override
        public void onClick(View v) {
            Editable s = edit.getText();
            text.setText("こんにちは、" + s + "さん。");
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sample_app, menu);
        return true;
    }


}
