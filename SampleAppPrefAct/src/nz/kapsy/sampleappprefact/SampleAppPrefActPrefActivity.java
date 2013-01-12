package nz.kapsy.sampleappprefact;

import android.content.*;
import android.os.Bundle;
import android.preference.*;
import android.preference.Preference.OnPreferenceChangeListener;

public class SampleAppPrefActPrefActivity extends PreferenceActivity {
    EditTextPreference myname;
    ListPreference mylist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        myname = (EditTextPreference) findPreference("myname");
        myname.setSummary("Last value: " + myname.getText());
        myname.setOnPreferenceChangeListener(
            new OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference pref, Object val) {
                    String oldval = ((EditTextPreference)pref).getText();
                    String newval = val.toString();
                    myname.setSummary(oldval + " → " + newval);
                    return true;
                }
            }
        );
        mylist = (ListPreference) findPreference("mylist");
        mylist.setSummary("Last select: " + mylist.getValue());
        mylist.setOnPreferenceChangeListener(
            new OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference pref, Object val) {
                    String newval = val.toString();
                    mylist.setSummary("you select '" + newval + "'.");
                    return true;
                }
            }
        );
    }

    public static String getMyName(Context ctx){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(ctx);
        String res  = settings.getString("myname", null);
        return res;
    }
    public static String getMyList(Context ctx){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(ctx);
        String res  = settings.getString("mylist", null);
        return res;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // 保存時の処理
    	// 今回は特に処理は用意していませんが、
    	// 設定を行う際に何らかの処理をしたい場合には、
    	// このメソッドを利用するのが良いでしょう。
        super.onSaveInstanceState(outState);
    }


}