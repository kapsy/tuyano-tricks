package nz.kapsy.sampleappnotification;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.app.*;
import android.content.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleAppNotification extends Activity
        implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)this.findViewById(R.id.button1);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManager manager =(NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        int icon = R.drawable.ic_launcher;
        CharSequence msg = "情報バーに表示する！";
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon, msg, when);
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent nIntent = new Intent(this, SampleAppNotification.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, nIntent, 0);

        Context context = getApplicationContext();
        CharSequence title = "sample Notify!";
        CharSequence content = "これがノーティフィケーションだ！";
        notification.setLatestEventInfo(context, title, content, pIntent);
        manager.notify(1, notification);
    }
}