package nz.kapsy.sampleappnotification2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

import android.widget.Button;
import android.widget.RemoteViews;
import android.view.View.OnClickListener;

public class SampleAppNotification2 extends Activity
		implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)this.findViewById(R.id.button1);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    	doAction(v);

    }

/*    public void doAction(View view){
        Intent intent = new Intent
        		(this,nz.kapsy.sampleappnotification2.SampleAppNotification2.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = new Notification();
        notify.flags = Notification.FLAG_AUTO_CANCEL;
        notify.icon = R.drawable.ic_launcher;
        notify.setLatestEventInfo(this, "TEST INFO",
                "テストのノーティフィケーションです。", pending);
        NotificationManager manager = (NotificationManager)this.
                getSystemService(Activity.NOTIFICATION_SERVICE);
        manager.notify(0, notify);
    }*/


/*    public void doAction(View view){
        Intent intent = new Intent(this,nz.kapsy.sampleappnotification2.SampleAppNotification2.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = new Notification();
        notify.flags = Notification.FLAG_AUTO_CANCEL;
        notify.icon = R.drawable.ic_launcher;
        notify.ledARGB = 0xff00ff00;
        notify.ledOnMS = 500;
        notify.ledOffMS = 500;
        notify.setLatestEventInfo(this, "TEST INFO",
                "テストのノーティフィケーションです。", pending);
        NotificationManager manager = (NotificationManager)this.
                getSystemService(Activity.NOTIFICATION_SERVICE);
        manager.notify(0, notify);
    }*/


/*    private int counter = 1;

    private Notification notify = null;
    private PendingIntent pending = null;

    public void doAction(View view){
        if (notify == null){
            Intent intent = new Intent(this,nz.kapsy.sampleappnotification2.SampleAppNotification2.class);
            pending = PendingIntent.getActivity(this, 0,
                    intent, PendingIntent.FLAG_CANCEL_CURRENT);
            notify = new Notification();
        }
        notify.flags = Notification.FLAG_AUTO_CANCEL;
        notify.flags = Notification.FLAG_ONGOING_EVENT;
        notify.icon = R.drawable.ic_launcher;
        notify.number = counter++;
        notify.setLatestEventInfo(this, "TEST INFO",
                "テストのノーティフィケーションです。", pending);
        NotificationManager manager = (NotificationManager)this.
                getSystemService(Activity.NOTIFICATION_SERVICE);
        manager.notify(0, notify);
    }*/


    // ※オリジナルの表示を行う

    public void doAction(View view){
        RemoteViews remoteview = new RemoteViews(this.getPackageName(), R.layout.item);
        Intent intent = new Intent(this,nz.kapsy.sampleappnotification2.SampleAppNotification2.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = new Notification();
        notify.contentView = remoteview;
        notify.flags = Notification.FLAG_AUTO_CANCEL;
        notify.icon = R.drawable.ic_launcher;
        notify.contentIntent = pending;
        NotificationManager manager = (NotificationManager)this.
                getSystemService(Activity.NOTIFICATION_SERVICE);
        manager.notify(0, notify);
    }




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}



}
