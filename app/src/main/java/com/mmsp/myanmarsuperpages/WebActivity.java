package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import com.mmsp.myanmarsuperpages.R;

public class WebActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_web);
		WebView wv = (WebView) findViewById(R.id.web_main);
		
		Bundle b = getIntent().getExtras();
		String str_date = b.getString("URL");
		
		 wv.getSettings().setJavaScriptEnabled(true);
		 wv.loadUrl(str_date);
	}
}
