package com.mmsp.myanmarsuperpages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class MainActivity extends Activity implements OnClickListener{
	
	ArrayList<Description> category;
	DatabaseHelper myDbHelper;
	ImageView mbtn;
	ImageView img_mainlarge_mm;
	ImageView img_mainlarge_en ;
	
	EditText businessname;
	Spinner spinnerdropdown;
	Button bsearch,bpop,bcat,bname,bcity;
    List<String> labels_cat ;
    String str_char;
	int sid;
	int code;
	String cdesp;
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	 //
	private long lastPressedTime;
	private static final int PERIOD = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Display display = getWindowManager().getDefaultDisplay();
		  Point size = new Point();
		  display.getSize(size);
		  int width = size.x;
		  int height = size.y;
		  if(width == 720){
			  setContentView(R.layout.activity_mainlarge);
		  }else{
			  setContentView(R.layout.activity_main);
		  }
		 Initialize();
		 load_categorySpinnerData("ENG");
		 img_mainlarge_mm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				str_char = "MM";
				 load_categorySpinnerData(str_char);
			}
		});
		 img_mainlarge_en.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					str_char = "ENG";
					 load_categorySpinnerData(str_char);
				}
			});
		
		 DropDown();
	}
	
    private void load_categorySpinnerData(String strchar) {
    	labels_cat = myDbHelper.getallcategory_city(strchar);  
        // Creating adapter for spinner 
       ArrayAdapter<String> adaptersss = new ArrayAdapter<String>(this,  R.layout.selected_item, labels_cat) {
		     public View getView(int position, View convertView, ViewGroup parent) {
		             View v = super.getView(position, convertView, parent);
		             Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		             ((TextView) v).setTypeface(externalFont);
		             v.setBackgroundColor(getResources().getColor(R.color.white));
		             return v;
		     }
		     public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
		              View v =super.getDropDownView(position, convertView, parent);
		             Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		             ((TextView) v).setTypeface(externalFont);
		              v.setBackgroundColor(getResources().getColor(R.color.white));
		             return v;
		     }
		};
        spinnerdropdown.setAdapter(adaptersss);  
        spinnerdropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// Get select item
				sid=spinnerdropdown.getSelectedItemPosition();	
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub		
			}
		});
        
    } 
	private void Initialize() {
		// TODO Auto-generated method stub
		 mbtn = (ImageView) findViewById(R.id.menubtn);
		 img_mainlarge_mm = (ImageView) findViewById(R.id.img_mainlarge_mm);
		 img_mainlarge_en = (ImageView) findViewById(R.id.img_mainlarge_en);
		 businessname = (EditText) findViewById(R.id.etbusinessname);
		 spinnerdropdown = (Spinner) findViewById(R.id.spinner1);
		
		 bsearch = (Button) findViewById(R.id.btnsearch);
		 bpop = (Button) findViewById(R.id.btnpop);
		 bcat = (Button) findViewById(R.id.btncat);
		 bname = (Button) findViewById(R.id.btnname);
		 bcity = (Button) findViewById(R.id.btncity);
		 Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		 bsearch.setTypeface(externalFont);
		 bpop.setTypeface(externalFont);
		 bname.setTypeface(externalFont);
		 bcity.setTypeface(externalFont);
		 bcat.setTypeface(externalFont);
		 businessname.setTypeface(externalFont);
		 
		 category = new ArrayList<Description>();
		  myDbHelper = new DatabaseHelper(this);
			try {
				myDbHelper.createDataBase();
			} catch (IOException ioe) {
				throw new Error("Unable to create database");
			}

			try {
				myDbHelper.openDataBase();
			} catch (SQLException sqle) {
				throw sqle;
			} 
			bsearch.setOnClickListener(this);
			bpop.setOnClickListener(this);
			bcat.setOnClickListener(this);
			bname.setOnClickListener(this);
			bcity.setOnClickListener(this);
			
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnsearch:
			String busName = businessname.getText().toString();
			cdesp = labels_cat.get(sid);
			code = myDbHelper.getIdAllCategoryName_main(cdesp);
			if(cdesp.equals("Choose Category")){
				cdesp = busName;
				code = -1;
			}else{
				cdesp = cdesp;
				code = myDbHelper.getIdAllCategoryName_main(cdesp);
			}
		
			 if(code==-1 && (busName.equals(""))){
				 Toast.makeText(MainActivity.this,"Please select at least one...!", Toast.LENGTH_SHORT).show();
			 }else{
					Intent fact = new Intent(MainActivity.this,Main_Searchwithbusinessname.class);
					fact.putExtra("BUSNAME", busName);
					fact.putExtra("CATNAME", cdesp);
					fact.putExtra("CATID",String.valueOf(code));
					startActivity(fact);
			 }
			break;
		case R.id.btnpop:
			Intent sact = new Intent(MainActivity.this,Popular_categories.class);
			startActivity(sact);
			break;
		case R.id.btncat:
			Intent tact = new Intent(MainActivity.this,Category_Menu.class);
			startActivity(tact);
			break;
		case R.id.btncity:
			Intent foact = new Intent(MainActivity.this,Searchby_City.class);
			startActivity(foact);
			break;
		case R.id.btnname:
			Intent ffact = new Intent(MainActivity.this,Searchby_Name.class);
			startActivity(ffact);
			break;
		}
	}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
					Intent i1 = new Intent(MainActivity.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(MainActivity.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(MainActivity.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(MainActivity.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(MainActivity.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(MainActivity.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(MainActivity.this,Feedback.class);
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
	        switch (event.getAction()) {
	        case KeyEvent.ACTION_DOWN:
	            if (event.getDownTime() - lastPressedTime < PERIOD) {
	            	finish();
			        Intent intent = new Intent(Intent.ACTION_MAIN);
				    intent.addCategory(Intent.CATEGORY_HOME);
				    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				    startActivity(intent);
/*			        moveTaskToBack(true);
		            android.os.Process.killProcess(android.os.Process.myPid());
		            System.exit(1);*/
	            } else {
	            	//Toast in custom font
	            	//Exit
		    	    String str = "Press one more time to exit Myanmar Super Pages.";
	            	Toast toast = Toast.makeText(MainActivity.this,str, Toast.LENGTH_SHORT);
	    			LinearLayout toastLayout = (LinearLayout) toast.getView();
	    		    TextView toastTV = (TextView) toastLayout.getChildAt(0);
	    		    toastTV.setTextSize(12);
	    		    toast.show();
	                lastPressedTime = event.getEventTime();
	            }
	            return true;
	        }
	    }
	    return false;
	}
	

}
