package jp.tuyano.sampleappfileio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.io.*;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SampleAppFileIO extends Activity {
    private Activity me;
    private EditText edit;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sample_app_file_io);
        edit = (EditText)this.findViewById(R.id.edit);
        Button load = (Button)this.findViewById(R.id.load);
        load.setOnClickListener(new MyLoadAdapter());
        Button save = (Button)this.findViewById(R.id.save);
        save.setOnClickListener(new MySaveAdapter());
    }

    // イベントクラス
    class MyLoadAdapter implements OnClickListener {


        @Override
        public void onClick(View v) {
            try {
                loadText();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // イベントクラス
    class MySaveAdapter implements OnClickListener {


        @Override
        public void onClick(View v) {
            Editable s = edit.getText();
            try {
                saveText(s.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //++++++++++++++++
    //FileOutputStream
    //++++++++++++++++
/*    // テキストの保存
    public void saveText(String data) throws IOException{
        String path = "data.txt";
        // ここでは、MODE_WORLD_READABLEというものが指定されていますね。
        // 他のプログラムからもファイルの読み込みを許可する場合にはこれを指定しておきます。
        // もし外部から利用する必要がなければ、MODE_PRIVATEを指定します。
        // また、MODE_APPENDを指定すると、データを追記していけます。
        FileOutputStream output = this.openFileOutput(path, Context.MODE_WORLD_READABLE);
        output.write(data.getBytes());
        output.close();
    }
    // テキストの読込
    public void loadText() throws IOException{
        String path = "data.txt";
        FileInputStream input = this.openFileInput(path);
        byte[] buffer = new byte[1000];
        input.read(buffer);
        String s = new String(buffer).trim();
        edit.setText(s);
        input.close();
    }*/

    //+++++++++++++++++++++++++++++++
    //FileReader/FileWriterを使うと？
    //+++++++++++++++++++++++++++++++
/*    public void saveText(String data) throws IOException{
        String path = "/data/data/" + this.getPackageName() + "/files/data.txt";
        FileWriter writer = new FileWriter(path);
        writer.write(data);
        writer.close();
    }

    public void loadText() throws IOException{
        String path = "/data/data/" + this.getPackageName() + "/files/data.txt";
        FileReader reader = new FileReader(path);
        char[] buffer = new char[1000];
        reader.read(buffer);
        edit.setText(new String(buffer).trim());
        reader.close();
    }*/
    //++++++++++++++++++++++++++++
    //SDカードにファイルを保存する
    //++++++++++++++++++++++++++++
    public void saveText(String data) throws IOException {
        String path = "/sdcard/data.txt"; // ★
        FileWriter writer = new FileWriter(path);
        writer.write(data);
        writer.close();
    }

    public void loadText() throws IOException {
        String path = "/sdcard/data.txt"; // ★
        FileReader reader = new FileReader(path);
        char[] buffer = new char[1000];
        reader.read(buffer);
        edit.setText(new String(buffer).trim());
        reader.close();
    }






}