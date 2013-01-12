// http://libro.tuyano.com/index3?id=1059&page=1

package nz.kapsy.sampleappappwidget;

import java.util.*;

import android.app.*;
import android.appwidget.AppWidgetManager;
import android.content.*;
import android.os.IBinder;
import android.widget.RemoteViews;

public class MyService extends Service {
    private static final String ACTION_BTNCLICK =
            "nz.kapsy.sampleappappwidget.MyService.ACTION_BTNCLICK";

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        AppWidgetManager manager = AppWidgetManager.getInstance(this);


        RemoteViews view = new RemoteViews(getPackageName(), R.layout.appwidget);
        if (ACTION_BTNCLICK.equals(intent.getAction())) {
            btnClicked(view);
        }

        Intent newintent = new Intent();
        newintent.setAction(ACTION_BTNCLICK);

/*        PendingIntentは、指定した時間や、
        イベントのときにIntentを発信させるのに用いられるものです。
        PendingIntent.getServiceでPendingIntentインスタンスを用意し、
        そしてRemoteViewsの「setOnClickPendingIntent」を使い、
        指定したViewのリソースIDにPendingIntentを設定してやります。
        これで、クリックしたらIntentが発信され、
        結果、先ほど設定したようにACTION_BTNCLICKのアクションであれば
        btnClickedが実行されるようになります。*/

        PendingIntent pending = PendingIntent.getService(this, 0, newintent, 0);
        view.setOnClickPendingIntent(R.id.button1, pending);
        ComponentName widget = new ComponentName(this, MyAppWidget.class);
        manager.updateAppWidget(widget, view);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void btnClicked(RemoteViews view){
        String[] msg = new String[]{"大吉。すべてよし！","中吉。いい一日。",
                "小吉。小市民な一日。","吉。可もなく不可もなし。",
                "凶。注意すべし。","大凶。南無阿弥陀仏。"};
        int n = new Random(new Date().getTime()).nextInt(msg.length);
        view.setTextViewText(R.id.text1, msg[n]);
    }


}