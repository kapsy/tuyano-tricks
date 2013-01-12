package nz.kapsy.sampleappwidget;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;


class MySimpleView extends View {
    private String message = "sample message.";
    private float messageSize = 10f;
    private int drawColor = Color.RED;
    private int messageColor = Color.BLUE;
    private int width = 300;
    private int height = 200;


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public float getMessageSize() {
        return messageSize;
    }
    public void setMessageSize(float messageSize) {
        this.messageSize = messageSize;
    }
    public int getDrawColor() {
        return drawColor;
    }
    public void setDrawColor(int drawColor) {
        this.drawColor = drawColor;
    }
    public int getMessageColor() {
        return messageColor;
    }
    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }
    public int getW() {
        return width;
    }
    public void setW(int width) {
        this.width = width;
    }
    public int getH() {
        return height;
    }
    public void setH(int height) {
        this.height = height;
    }

    public MySimpleView(Context context) {
        super(context);
    }
    public MySimpleView(Context context,
                AttributeSet attr) {
        super(context, attr);
        String message = attr.getAttributeValue(null,
                "message");
        this.message = message != null ? message :
                this.message;
        this.messageSize = attr.getAttributeIntValue
                (null, "messageSize", 10);
        this.drawColor = attr.getAttributeIntValue(null,
                "drawColor", Color.RED);
        this.messageColor = attr.getAttributeIntValue
                (null, "messageColor", Color.BLUE);
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawColor(Color.WHITE);
        Paint fill_paint = new Paint();
        fill_paint.setStyle(Paint.Style.FILL);
        fill_paint.setColor(this.drawColor);
        c.drawOval(new RectF(0f, 0f, this.width,
                this.height),
                fill_paint);
        fill_paint.setColor(this.messageColor);
        fill_paint.setTextSize(this.messageSize);
        c.drawText(this.message, 5f,
                this.messageSize + 5, fill_paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,
            int heightMeasureSpec) {
        setMeasuredDimension(width, height);
    }
}