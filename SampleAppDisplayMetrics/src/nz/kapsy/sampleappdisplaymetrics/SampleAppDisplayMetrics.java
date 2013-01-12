package nz.kapsy.sampleappdisplaymetrics;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.view.*;
 
public class SampleAppDisplayMetrics extends Activity {
    DisplayMetrics metrics;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
         
        DrawView view = new DrawView(getApplication());
        setContentView(view);
         
        WindowManager manager = this.getWindowManager();
        Display display = manager.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }
 
    class DrawView extends View {
 
        public DrawView(Context context) {
            super(context);
        }
 
 
        public void onDraw(Canvas c) {
            int w = metrics.widthPixels;
            int h = metrics.heightPixels;
            float d = 100f * metrics.density;
            c.drawColor(Color.BLACK);
             
            Paint fill_paint = new Paint();
            fill_paint.setStyle(Paint.Style.FILL);
            fill_paint.setColor(Color.RED);
            c.drawOval(new RectF(0f, 0f, d, d), fill_paint);
            c.drawOval(new RectF(w - d, 0f, (float)w, d), fill_paint);
            c.drawOval(new RectF(0f, h - d, d, (float)h), fill_paint);
            c.drawOval(new RectF(w - d, h - d, (float)w, (float)h), fill_paint);
 
        }
 
    }
}