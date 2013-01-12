package com.example.sampleappcamera2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.io.*;

import android.app.*;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;
import android.view.*;
import android.widget.Toast;

public class SampleAppCamera2 extends Activity {
    private Preview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mPreview = new Preview(this);
        setContentView(mPreview);
    }

}

class Preview extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder mHolder;
    Camera mCamera;

    Preview(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = Camera.open();
        try {
            mCamera.setPreviewDisplay(holder);
        } catch (IOException exception) {
            mCamera.release();
            mCamera = null;
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewSize(w, h);
        mCamera.setParameters(parameters);
        mCamera.startPreview();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            PictureCallback jpeg = new PictureCallback() {
                @Override
                public void onPictureTaken(byte[] bytes, Camera camera) {
                    FileOutputStream stream = null;
                    BufferedOutputStream buffer = null;
                    try {
                        stream = new FileOutputStream("/sdcard/capimg.jpg");
                        buffer = new BufferedOutputStream(stream);
                        buffer.write(bytes);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            buffer.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            mCamera.takePicture(null,null,jpeg);
            mCamera.startPreview();
        }
        return true;
    }
}