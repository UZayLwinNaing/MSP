package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Feedback extends Activity {

	TextView edtxt_y_name;
	TextView edtxt_y_detail;
	
	String name;
	String detail;
	String s;
	
	Button btn_feedback;
	ImageView mbtn;
	
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_feedback);
		 mbtn = (ImageView) findViewById(R.id.menubtn_feedback);
		
		edtxt_y_name  = (TextView)findViewById(R.id.edtxt_y_name);
		edtxt_y_detail  = (TextView)findViewById(R.id.edtxt_y_detail);
		
		Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		edtxt_y_name.setTypeface(externalFont);
		edtxt_y_detail.setTypeface(externalFont);
		
		btn_feedback  = (Button)findViewById(R.id.btn_y_feedback);
		DropDown();
		 
		name = edtxt_y_name.getText().toString();
		detail = edtxt_y_detail.getText().toString();

		btn_feedback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = edtxt_y_name.getText().toString();
				detail = edtxt_y_detail.getText().toString();
				if(name.equals("")){
					Toast.makeText(Feedback.this, "Please fill yuor name...!", Toast.LENGTH_SHORT).show();
				}else if(detail.equals("")){
					Toast.makeText(Feedback.this, "Please fill yuor feedback details...!", Toast.LENGTH_SHORT).show();
				}else{
					s =  name+" " +detail;
			    	 SmsManager sms = SmsManager.getDefault();
			    	 sms.sendTextMessage("09968300598", null, s, null, null);
			    	 edtxt_y_name.setText("");
			    	 edtxt_y_detail.setText("");
			    	 edtxt_y_name.requestFocus();
			    	 Toast.makeText(Feedback.this, "Feedback is send...", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	private void DropDown() {
		// TODO Auto-generated method stub
		ActionItem nextItem 	= new ActionItem(ID_POP, "Popular Categories", getResources().getDrawable(R.drawable.logo));
		ActionItem prevItem 	= new ActionItem(ID_SCAT, "Search by Category", getResources().getDrawable(R.drawable.logo));
        ActionItem searchItem 	= new ActionItem(ID_SN, "Search by Name", getResources().getDrawable(R.drawable.logo));
        ActionItem infoItem 	= new ActionItem(ID_SC, "Search by City", getResources().getDrawable(R.drawable.logo));
        ActionItem eraseItem 	= new ActionItem(ID_AU, "About Us", getResources().getDrawable(R.drawable.logo));
        ActionItem okItem 		= new ActionItem(ID_CU, "Contact Us", getResources().getDrawable(R.drawable.logo));
        ActionItem feedbackItem = new ActionItem(ID_FB, "Feedback", getResources().getDrawable(R.drawable.logo));
        
        final QuickAction  quickAction = new QuickAction(this, QuickAction.VERTICAL);
		//add action items into QuickAction
        quickAction.addActionItem(nextItem);
		quickAction.addActionItem(prevItem);
        quickAction.addActionItem(searchItem);
        quickAction.addActionItem(infoItem);
        quickAction.addActionItem(eraseItem);
        quickAction.addActionItem(okItem);
        quickAction.addActionItem(feedbackItem);
        //Set listener for action item clicked
		quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
			@Override
			public void onItemClick(QuickAction source, int pos, int actionId) {				
				ActionItem actionItem = quickAction.getActionItem(pos);
                 
				//here we can filter which action item was clicked with pos or actionId parameter
				switch(actionId){
				case ID_POP:
					Intent i1 = new Intent(Feedback.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Feedback.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Feedback.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Feedback.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Feedback.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Feedback.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Feedback.this,Feedback.class);
					startActivity(i7);
					break;
				}
				
			}
		});
		
		//set listnener for on dismiss event, this listener will be called only if QuickAction dialog was dismissed
		//by clicking the area outside the dialog.
		quickAction.setOnDismissListener(new QuickAction.OnDismissListener() {			
			@Override
			public void onDismiss() {
				//Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
			}
		});
	    mbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				quickAction.show(v);
			}
		});
	}
}
