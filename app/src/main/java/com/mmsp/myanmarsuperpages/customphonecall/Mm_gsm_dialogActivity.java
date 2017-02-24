package com.mmsp.myanmarsuperpages.customphonecall;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.R.id;
import com.mmsp.myanmarsuperpages.R.layout;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Mm_gsm_dialogActivity extends Activity {

	TextView txt_dialog_title;
	Button btn_sim2;
	Button btn_sim1;
	
	Typeface typeface;
	 String s_meg,s_noti,s_dialog_title;
	 String s_btn_sim2,s_btn_sim1;
	
	 boolean isDualSIM;
	 String OperatorName;
	 String SimOperatorName;
	 TelephonyManager  manager;
	 
	 String phone_number;
	 
	public static final String [] dualSimTypes = { "subscription", "Subscription", 
	        "Com.android.phone.extra.slot", 
	        "Phone", "com.android.phone.DialingMode", 
	        "SimId", "simnum", "phone_type", 
	        "SimSlot"};
		
	int simnumber;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_s_dialoglayout);
		
		typeface = Typeface.createFromAsset(getAssets(),"myanmar3.ttf");

		txt_dialog_title = (TextView) findViewById(R.id.txt_dialog_title);
		
		btn_sim2 = (Button) findViewById(R.id.btn_sim2);
		btn_sim1 = (Button) findViewById(R.id.btn_sim1);
		
		txt_dialog_title.setTypeface(typeface);
		txt_dialog_title.setTextSize(14);
		txt_dialog_title.setText("Myanmar Yellow pages ");
		
		btn_sim2.setTypeface(typeface);
		btn_sim1.setTypeface(typeface);
		
		Bundle b = getIntent().getExtras();
		phone_number = b.getString("CallPhone");
		
		manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		
		btn_sim1.setText("SIM 1");
		btn_sim2.setText("SIM 2");
		
		btn_sim1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = phone_number;
	               if (number.equals ( "")) { 
	                   Toast.makeText (Mm_gsm_dialogActivity.this, "Well do not enter a number empty", 1500) .show ();
	               } else {
	                   call (number,2); 
	               }
			}
		}); 
		btn_sim2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = phone_number;
	               if (number.equals ( "")) { 
	                   Toast.makeText (Mm_gsm_dialogActivity.this, "Well do not enter a number empty", 1500) .show ();
	               } else {
	                   call (number,1); 
	               }
			}
		}); 
	}
	
	
	  private void call (String phone,int num) {
	        Intent callIntent = new Intent (Intent.ACTION_CALL) .setFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
	        callIntent.setData (Uri.parse ( "tel:" + phone));
	        for (int i = 0; i <dualSimTypes.length; i ++) {
	            callIntent.putExtra (dualSimTypes [i], num);
	        }
	        this.startActivity (callIntent);
	        moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
	    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
	        switch (event.getAction()) {
	        case KeyEvent.ACTION_DOWN:
	        	finish();
	            }
	            return true;
	    }
	    return false;
	}

}
