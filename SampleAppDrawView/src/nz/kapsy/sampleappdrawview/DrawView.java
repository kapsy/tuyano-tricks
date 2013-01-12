package nz.kapsy.sampleappdrawview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    private Bitmap bitmap;

    public DrawView(Context context) {
        super(context);
        Resources res = this.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.image1);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


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

}

