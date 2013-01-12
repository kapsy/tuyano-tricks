package nz.kapsy.sampleappsurfaceview;

import java.util.Random;
import java.util.concurrent.*;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;

public class MySurfaceView extends SurfaceView implements
        SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private float x, y, r; // ★rを追加

    private int red, grn, blu;
    private int redlimit, grnlimit, blulimit;
    private int biggestdropsize;
    private boolean biggestmet = false;
    
	private float rspeed;
	private float yspeed;
	private int alpha;
	private float alphaslower;
	
	private boolean initbackground;

	Rect screensizerect;

	
	
    private Random rnd = new Random();
    
    Bitmap backg_bitmap = 
    		BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.bg_test_2);
    

//    private Random rndthread = new Random();
//    int rndthreadint;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        holder = getHolder();
        holder.setFormat(PixelFormat.TRANSLUCENT);
        holder.addCallback(this);
        
       
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
            int format, int width, int height) {}

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        x = getWidth() / 2;
        y = getHeight() / 2;
        
//        int h = backg_bitmap.getHeight();
//        int w = backg_bitmap.getWidth();
//        
//       
//float ratio = (float)backg_bitmap.getHeight() / (float)backg_bitmap.getWidth();
       int rectheight = (int)((float)getWidth()*((float)backg_bitmap.getHeight() / (float)backg_bitmap.getWidth()));
    	
       // Rect rect = new Rect(l, t, r, b);
       screensizerect = new Rect(0, 0, getWidth(), rectheight);
        
       // alpha = 1;
        //draw();
        //drawBackGround();
        initbackground = true;
        startnow(); // ★追加
        //timedTrigger();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            x = event.getX();
            y = event.getY();
            
            //dropInit();
            
            initbackground = false;
            
            
		r = 18 - rnd.nextInt(8);
		biggestmet = false;
		alpha = 1;
		alphaslower = (float)0;
		
		red = rnd.nextInt(1);
		grn = rnd.nextInt(2);
		blu = rnd.nextInt(3);
		Log.d("COLOR", "Initial Colors: r" + red + " g" + grn + " b" + blu);
		
		redlimit = rnd.nextInt(254 - rnd.nextInt(6));
		grnlimit = rnd.nextInt(254 - rnd.nextInt(6));
		blulimit = rnd.nextInt(245 - rnd.nextInt(6));		
		Log.d("COLOR", "Color Limits: r" + redlimit + " g" + grnlimit + " b" + blulimit);
		
		//biggestdropsize = rnd.nextInt(100 - rnd.nextInt(40));
		biggestdropsize = 120;
		
		rspeed = (float)0.234;
		yspeed = (float)0.674375;

        //draw();
        }
        return super.onTouchEvent(event);
    }



    public void draw() {
        Canvas c = holder.lockCanvas();
        
        if(initbackground) {

            c.drawColor(Color.BLACK); 
            
        	//c.drawBitmap(background, 0, 0, null);
        	
            //c.drawBitmap(backg_bitmap, null, screensizerect, null);
            
            
            Paint p1 = new Paint();
            p1.setColor(Color.RED);
            Path path = new Path();
            path.moveTo(100, 300);
            path.lineTo(10, 350);
            path.lineTo(80, 330);
            c.drawPath(path, p1);
            
            
            
        }
        
        
        //c.drawColor(Color.argb(0, 100, 100, 100));
        //c.dr
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setColor(Color.argb(alpha, red, grn, blu));
        p.setAntiAlias(true);
        p.setDither(true);

       // c.
        
        
        c.drawCircle(x, y, r, p); // ★修正
        holder.unlockCanvasAndPost(c);
    }
    
/*    public void drawBackGround() {
    	
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.GRAY); 
//        Paint p = new Paint();
//        Rect rect = new Rect( );
//        
//        
//        
//        rect.set(10, 10, 100, 100);
//        
//        RectF rectf = new RectF();
        
       //c.drawBitmap(background, 0, 0, null);
       
//        p.setStyle(Paint.Style.FILL_AND_STROKE);
//        p.setColor(Color.argb(alpha, red, grn, blu));
//        p.setAntiAlias(true);
//        p.setDither(true);

       
        
        
        //c.drawCircle(x, y, r, p); // ★修正
        holder.unlockCanvasAndPost(c);
    	
    }*/
    

    // ★追加メソッド
    public void startnow(){
        ScheduledExecutorService executor =
                Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            	// 100: 最大 ?: まだ知らない 10: 最初の値
				//            	r = r > 100 ? 10 : r + 1;]
				//            	if (r > 60){}
            	


            	if(r > biggestdropsize){
            		biggestmet = true;
            	}

            	if (biggestmet == false) {
            		
            		
            		
            		if (alpha < 7) {            			
            			alphaslower += (float).32;
            			alpha = (int)alphaslower;
            			//Log.d("RUN", "alpha: " + alpha);
            		}
            		

            		y = y + yspeed;
            		r = r +rspeed;
            		rspeed = rspeed + (float).00072;

            	 	if (red <= redlimit){red++;}
            	 	if (grn <= grnlimit){grn++;}
            	 	if (blu <= blulimit){blu++;}
            	 	//Log.d("COLOR", "Update Color: r" + red + " g" + grn + " b" + blu);
            	 	draw();
            	}
            	

            }
        }, 25, 25, TimeUnit.MILLISECONDS);

    }

}


