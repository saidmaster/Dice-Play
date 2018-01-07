package dice.play.game.gamesswitch;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Said BAHAOUARY on 12/03/17.
 */

public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dice.play.game.gamesswitch.R.layout.about);

        WebView wv=(WebView) findViewById(dice.play.game.gamesswitch.R.id.webView_id);

        WebSettings webSettings = wv.getSettings();

        webSettings.setJavaScriptEnabled(true);

        wv.loadUrl("file:///android_asset/about.html");
    }
}
