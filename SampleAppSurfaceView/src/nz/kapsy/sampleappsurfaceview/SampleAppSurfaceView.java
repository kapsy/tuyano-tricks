package nz.kapsy.sampleappsurfaceview;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.support.v4.app.NavUtils;

public class SampleAppSurfaceView extends Activity {

//    private final String TAG = "StartingActivity";
//    
//MySurfaceView mysurfview;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        
//        Log.d(TAG, "onCreate");
//        sv = new MySurfaceView(this);
//        setContentView(sv);
        
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
//        mysurfview = new MySurfaceView(getApplication());
//        setContentView(mysurfview);
        
        DrawView view = new DrawView(getApplication());
        setContentView(view);
        
    }

    class DrawView extends View {
    	 
        public DrawView(Context context) {
            super(context);
        }
 
 
        public void onDraw(Canvas c) {
//            int w = metrics.widthPixels;
//            int h = metrics.heightPixels;
//            float d = 100f * metrics.density;
            c.drawColor(Color.BLACK);
             
//            Paint fill_paint = new Paint();
//            fill_paint.setStyle(Paint.Style.FILL);
//            fill_paint.setColor(Color.RED);
//            c.drawOval(new RectF(0f, 0f, d, d), fill_paint);
//            c.drawOval(new RectF(w - d, 0f, (float)w, d), fill_paint);
//            c.drawOval(new RectF(0f, h - d, d, (float)h), fill_paint);
//            c.drawOval(new RectF(w - d, h - d, (float)w, (float)h), fill_paint);
 
        }
 
    }
    
}
