package nz.kapsy.sampleappdrawview;

import android.os.Bundle;
import android.app.Activity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.content.Context;
import android.graphics.*;
import android.view.View;

import android.content.res.Resources;


 public class SampleAppDrawView extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DrawView view = new DrawView(getApplication());
        setContentView(R.layout.main);
    }


/*    class DrawView extends View {


        public DrawView(Context context) {
            super(context);
        }

//        public void onDraw(Canvas c) {
//            c.drawColor(Color.BLACK);
//
//            Paint fill_paint = new Paint();
//            fill_paint.setStyle(Paint.Style.FILL);
//            fill_paint.setColor(Color.BLUE);
//            c.drawRect(100f, 100f, 200f, 200f, fill_paint);
//
//            fill_paint.setColor(Color.RED);
//            c.drawOval(new RectF(0f, 0f, 100f, 100f), fill_paint);
//        }

        public void onDraw(Canvas c) {
            c.drawColor(Color.WHITE);

            Paint fill_paint = new Paint();
            fill_paint.setStyle(Paint.Style.FILL_AND_STROKE);
            fill_paint.setColor(Color.argb(50, 255, 0, 0));
            for(int i = 0;i < 10;i++){
                c.drawOval(new RectF(25f * i, 25f * i, 25f * i + 100f,
                        25f * i + 100f), fill_paint);
            }
        }


    }*/


}
