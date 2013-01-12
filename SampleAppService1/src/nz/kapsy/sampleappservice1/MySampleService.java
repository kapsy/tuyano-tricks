package nz.kapsy.sampleappservice1;


import java.util.*;

import android.app.Service;
import android.content.*;
import android.os.*;

public class MySampleService extends Service {
    public static final String ACTION = "MySampleService";
    private Timer timer;
    private int counter;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                counter++;
                Intent intent = new Intent(ACTION);
                intent.putExtra("counter", counter);
                sendBroadcast(intent);
            }

        }, 1000, 1000);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MySampleBinder();
    }

    @Override
    public void onRebind(Intent intent) {

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    // Binder内部クラス
    class MySampleBinder extends Binder {

        MySampleService getService() {
            return MySampleService.this;
        }

    }
}