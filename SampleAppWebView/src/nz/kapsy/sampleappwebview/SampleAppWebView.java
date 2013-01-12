package nz.kapsy.sampleappwebview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import android.webkit.WebView;
import android.webkit.*;
import android.widget.*;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.Calendar;

import android.app.*;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.*;

public class SampleAppWebView extends Activity {
    public WebView webview01;

    // ※指定したアドレスにアクセスする
/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webview01 = (WebView)findViewById(R.id.WebView01);
        webview01.loadUrl("http://www.google.com/");
    }*/

/*    // ※表示するデータをStringで用意しておく
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            webview01 = (WebView)findViewById(R.id.WebView01);
            String data = "<html><body><h1>Hello!</h1></body></html>";
            webview01.loadData(data,"text/html","utf8");
        }*/


/*        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            webview01 = (WebView)findViewById(R.id.WebView01);
            webview01.setWebViewClient(new WebViewClient(){

                @Override
                public void onReceivedError(WebView view, int errorCode,
                        String description, String failingUrl) {
                    view.loadData("ERROR: " + description,"text/plain","utf8");
                }

            });

            webview01.getSettings().setBuiltInZoomControls(true);
            webview01.getSettings().setJavaScriptEnabled(true);
            webview01.getSettings().setMinimumFontSize(12);
            webview01.getSettings().setSupportZoom(true);
            webview01.getSettings().setSaveFormData(true);
            webview01.getSettings().setSavePassword(true);
            webview01.loadUrl("http://www.google.com/");
        }*/



/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webview01 = (WebView)findViewById(R.id.WebView01);
        webview01.getSettings().setJavaScriptEnabled(true);
        webview01.addJavascriptInterface(new JSObj(this), "jsobj");
        String data = "<html><head><script type=\"text/javascript\">" +
                "function init(){ jsobj.showMsg('Hello!!'); }" +
                "</script></head><body onload=\"init()\">" +
                "<h1>Sample</h1><p>JavaScript test.</p></bod></html>";
        webview01.loadData(data,"text/html","utf8");
    }

    class JSObj {
        private Context context;

        public JSObj(Context c){
            context = c;
        }

        public void showMsg(String msg) {
            Toast.makeText(context, msg,Toast.LENGTH_LONG).show();
        }
    }*/
    
    
    // では、今度は「Java側から、表示しているWebページ
    // 内のJavaScriptの処理を呼び出す」
    // というのはどうやるのでしょか？
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webview01 = (WebView)findViewById(R.id.WebView01);
        webview01.getSettings().setJavaScriptEnabled(true);
        webview01.addJavascriptInterface(new JSObj(this,webview01), "jsobj");
        String data = "<html><head><script type=\"text/javascript\">" +
                "function init(){ jsobj.showDlg(); }" +
                "function showDate(msg){document.getElementById('msg').innerHTML = msg;}" +
                "</script></head><body onload=\"init()\">" +
                "<h1>Sample</h1><p id=\"msg\">JavaScript test.</p></bod></html>";
        webview01.loadData(data,"text/html","utf8");
    }
    
    
    class JSObj {
        private Context context;
        private WebView web;
         
        public JSObj(Context c,WebView w){
            context = c;
            web = w;
        }
         
        public void showDlg() {
            Calendar calendar = Calendar.getInstance();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DAY_OF_MONTH);
            final DatePickerDialog dlg = new DatePickerDialog(
                    context,new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view,
                                int y, int m, int d) {
                            web.loadUrl("javascript:showDate('" + y +
                                    "/" + m + "/" + d + "')");
                        }
                    },y,m,d);
                dlg.show();
        }
    }
    


}