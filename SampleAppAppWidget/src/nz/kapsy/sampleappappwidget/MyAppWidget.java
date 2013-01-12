package nz.kapsy.sampleappappwidget;

import android.appwidget.*;
import android.content.*;

public class MyAppWidget extends AppWidgetProvider {

	//onUpdate――システムによりAppWidgetの更新の要求があったときに呼び出されます。
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) {
        Intent serviceIntent = new Intent(context, nz.kapsy.sampleappappwidget.MyService.class);
        context.startService(serviceIntent);
    }


}