package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.mmsp.myanmarsuperpages.R;

public class Splashscreen extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashscreen);
		
		new Handler().postDelayed(new Runnable() 
		{
			public void run() 
			{
				// Finish the splash activity so it can't be returned to.
				Splashscreen.this.finish();
				// Create an Intent that will start the main activity.
				Intent mainIntent = new Intent(Splashscreen.this, MainActivity.class);
				Splashscreen.this.startActivity(mainIntent);
			}
		}, 3000);
	}
}
