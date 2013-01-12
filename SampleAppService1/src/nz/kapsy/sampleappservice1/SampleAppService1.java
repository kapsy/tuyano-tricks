package nz.kapsy.sampleappservice1;

import java.util.Calendar;

import android.app.Activity;
import android.content.*;
import android.os.*;
import android.widget.TextView;

public class SampleAppService1 extends Activity {
    private ServiceConnection serviceConnection;
    private final MyServiceReceiver receiver = new MyServiceReceiver();
    public TextView textview01;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textview01 = (TextView)findViewById(R.id.TextView01);
        startMyService();
    }

    public void startMyService(){
        // ServiceConnectionの用意
        serviceConnection = new MyServiceConnection();

        // サービスを開始
        Intent intent = new Intent(this, MySampleService.class);
        ComponentName component = startService(intent);
        IntentFilter filter = new IntentFilter(MySampleService.ACTION);
        registerReceiver(receiver, filter);

        // サービスにバインド
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        // サービス終了
        unbindService(serviceConnection); // バインド解除
        unregisterReceiver(receiver); // レシーバー解除
        super.onDestroy();
    }

}

// ServiceConnectionクラス
class MyServiceConnection implements ServiceConnection {
    private MySampleService myservice;

    @Override
    public void onServiceConnected(ComponentName className, IBinder service) {
        myservice = ((MySampleService.MySampleBinder)service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName className) {
        myservice = null;
    }

}

// Receiverクラス
class MyServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int counter = intent.getIntExtra("counter", 0);
        ((SampleAppService1)context).textview01.setText("count: " + counter);
    }

}