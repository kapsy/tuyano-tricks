package nz.kapsy.sampleappdb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.io.*;
import java.util.Calendar;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SampleAppDB extends Activity {
    private static final String ID = "id";
    private DatabaseHelper dbhelper;
    private EditText edit;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        dbhelper = new DatabaseHelper(this);
        setContentView(R.layout.main);
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

    // メモの保存
    public void saveText(String data) throws IOException{
        String t = Calendar.getInstance().getTime().toString();
        String m = edit.getText().toString();
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.TITLE, t);
        values.put(DatabaseHelper.MEMO, m);
        db.insert(DatabaseHelper.TABLE_NAME,null,values);
        edit.setText(null);
    }
    //     メモの検索
    public void loadText() throws IOException{
        String m = edit.getText().toString();
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String query = "select * from " + DatabaseHelper.TABLE_NAME +
            " where " + DatabaseHelper.MEMO + " like '%" + m + "%';";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            edit.setText(c.getString(1) + "\n" + c.getString(2));
        }
    }

    // ヘルパークラスの定義
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "mydata.db";
        private static final int DATABASE_VERSION = 2;
        private static final String TABLE_NAME = "memodata";
        private static final String TITLE = "title";
        private static final String MEMO = "memo";


        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "create table " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY," +
                TITLE + " TEXT," +
                MEMO + " TEXT);";
            db.execSQL(query);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + TABLE_NAME);
            onCreate(db);
        }
    }
}