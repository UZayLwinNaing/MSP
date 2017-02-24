package com.mmsp.myanmarsuperpages;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Searchby_Name extends Activity implements OnClickListener {
	
	EditText bname;
	Spinner dropdownspinner;
	Button btsearch;
	String[] sp = {"Start With","Include in"};
	int sid;
	Cursor curName;
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	ImageView mbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.byname);
		Declaration();
		 ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.selected_item,sp);
			dropdownspinner.setAdapter(adapter);
			dropdownspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					// Get select item
				 sid=dropdownspinner.getSelectedItemPosition();	
				}
				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub		
				}
			});	 
			DropDown();
}
	private void Declaration() {
		// TODO Auto-generated method stub
		bname = (EditText) findViewById(R.id.etbusinessname);
		dropdownspinner = (Spinner) findViewById(R.id.spinner1);
		btsearch = (Button) findViewById(R.id.btnsearch);
		btsearch.setOnClickListener(this);
		mbtn = (ImageView) findViewById(R.id.iv);
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
					Intent i1 = new Intent(Searchby_Name.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Searchby_Name.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Searchby_Name.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Searchby_Name.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Searchby_Name.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Searchby_Name.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Searchby_Name.this,Feedback.class);
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
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String str = bname.getText().toString();
		String st = sp[sid];
		Intent in = new Intent(Searchby_Name.this,Searchby_NameResult.class);
		in.putExtra("NAME",str);
		in.putExtra("SID",st);
		startActivity(in);
		
	}
	
}