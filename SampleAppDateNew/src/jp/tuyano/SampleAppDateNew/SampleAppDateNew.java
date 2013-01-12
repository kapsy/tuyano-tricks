package jp.tuyano.SampleAppDateNew;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.*;
import android.os.Bundle;
import android.widget.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;


public class SampleAppDateNew extends Activity {

	private Activity me;
    private ListView list;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sample_app_date_new);
        me = this;

        String[] arr = {"東京都","神奈川県","千葉県","埼玉県","茨城県","栃木県","群馬県"};


        // コンポーネントの設定
        list = (ListView)this.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, arr);
        list.setAdapter(adapter);
        list.setSelection(1);

        // イベント組み込み
        list.setOnItemClickListener(new MyClickAdapter());
    }

    // イベントクラス
    class MyClickAdapter implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter,
                View view, int position, long id) {
        	// AlertDialog.Builderは、引数にダイアログを表示する「親」
        	// となるContext（要するに、このActivity）を指定します。
            AlertDialog.Builder bldr = new AlertDialog.Builder(me);
            bldr.setTitle("選択した都道府県");
            // ここでは、onItemClickで渡されたView（イベントが発生したTextView）
            // をTextViewにキャストし、そのgetTextでテキストを取り出して設定しています。
            TextView txt = (TextView)view;
            bldr.setMessage("選択項目：" + txt.getText());

            DialogInterface.OnClickListener listner = new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setResult(RESULT_OK);
                }
            };

            bldr.setPositiveButton("Set",listner);
            bldr.create();
            bldr.show();
        }
    }





/*    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_app_date_new);


                text1 = (TextView)this.findViewById(R.id.textView1);

        DatePickerDialog.OnDateSetListener listener =
            new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int y, int m, int d) {
                text1.setText("日付：" + y + "年" + (m + 1) + "月" + d + "日");
            }
        };
        DatePickerDialog datePicker =
            new DatePickerDialog(this,listener,2010,0,1);
        datePicker.show();

        TimePickerDialog.OnTimeSetListener listener =
                new TimePickerDialog.OnTimeSetListener(){

                @Override
                public void onTimeSet(TimePicker view, int h, int m) {
                    text1.setText("時刻：" + h + "時" + m + "分");
                }
            };
            TimePickerDialog timePicker =
                new TimePickerDialog(this,listener,0,0,true);
            timePicker.show();



    }*/
}