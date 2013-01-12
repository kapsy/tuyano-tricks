package nz.kapsy.sampleappcamera1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.view.*;

public class SampleAppCamera1 extends Activity {
    private Preview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mPreview = new Preview(this);
        setContentView(mPreview);
    }

}

class Preview extends SurfaceView
        implements SurfaceHolder.Callback {
    SurfaceHolder mHolder;
    Camera mCamera;

    Preview(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.
                SURFACE_TYPE_PUSH_BUFFERS);
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

    public void surfaceChanged(SurfaceHolder holder,
            int format, int w, int h) {
        Camera.Parameters parameters =
                mCamera.getParameters();
        parameters.setPreviewSize(w, h);
        mCamera.setParameters(parameters);
        mCamera.startPreview();
    }
}
