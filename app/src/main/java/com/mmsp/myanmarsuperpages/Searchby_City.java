package com.mmsp.myanmarsuperpages;

import java.util.ArrayList;
import java.util.List;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.View;

import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Searchby_City extends Activity implements OnClickListener{
    Button btnnpt,btnygn,btnmdy,btnoth,btsearch;
    Spinner townspinner,categoryspinner;
    DatabaseHelper myDbHelper;
    List<String> labels_cat ;
    List<String> labels_town ;
    View nolist;
    ListAdapter adapter;
	int cid,tid;
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	
	ImageView mbtn;
	ImageView img_mainlarge_mm;
	ImageView img_mainlarge_en;
	String str_char;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.searchbycity);
		myDbHelper = new DatabaseHelper(this);
		Declaration();
		load_townshipSpinnerData("000");
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
	
    private void load_townshipSpinnerData(String cityname) {  
    	labels_town= myDbHelper.getalltownship_city(cityname);  
        // Creating adapter for spinner 
        ArrayAdapter<String> adaptersss = new ArrayAdapter<String>(this,  R.layout.selected_item, labels_town) {
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
		             //v.setBackgroundColor(Color.GREEN);
		             return v;
		     }
		};      
        townspinner.setAdapter(adaptersss);  
        townspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// Get select item
			 cid=townspinner.getSelectedItemPosition();	
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub		
			}
		});
    } 
    private void load_categorySpinnerData(String strchar) {  
    	labels_cat = myDbHelper.getallcategory_city(strchar);  
        // Creating adapter for spinner 
        //ArrayAdapter<String> adaptersss = new ArrayAdapter<String>(this,R.layout.selected_item ,labels_cat);
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
		             //v.setBackgroundColor(Color.GREEN);
		             return v;
		     }
		};
        categoryspinner.setAdapter(adaptersss);  
        categoryspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				// Get select item
				cid=categoryspinner.getSelectedItemPosition();	
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub		
			}
			
		});
    } 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnpt:
			load_townshipSpinnerData("npt");
			break;
		case R.id.btygn:
			load_townshipSpinnerData("ygn");
			break;
		case R.id.btmdy:
			load_townshipSpinnerData("mdy");
			break;
		case R.id.btoth:
			load_townshipSpinnerData("other");
			break;
		case R.id.btnsearch:
				Intent intent = new Intent(Searchby_City.this,Searchby_CityAndCat.class);
				intent.putExtra("CATNAME",labels_cat.get(cid));
				intent.putExtra("CITYNAME", labels_town.get(tid));
				startActivity(intent);
			break;
		}
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
					Intent i1 = new Intent(Searchby_City.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Searchby_City.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Searchby_City.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Searchby_City.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Searchby_City.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Searchby_City.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Searchby_City.this,Feedback.class);
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

	private void Declaration() {
		// TODO Auto-generated method stub
		btnnpt = (Button) findViewById(R.id.btnpt);
		btnygn = (Button) findViewById(R.id.btygn);
		btnmdy = (Button) findViewById(R.id.btmdy);
		btnoth = (Button) findViewById(R.id.btoth);
		btsearch = (Button) findViewById(R.id.btnsearch);
		townspinner = (Spinner) findViewById(R.id.spinner1);
		mbtn = (ImageView) findViewById(R.id.iv);
		img_mainlarge_mm = (ImageView) findViewById(R.id.img_searchbycity_mm);
		 img_mainlarge_en = (ImageView) findViewById(R.id.img_searchbycity_en);
		categoryspinner = (Spinner) findViewById(R.id.spinner2);
		myDbHelper = new DatabaseHelper(this);
		Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		btnnpt.setTypeface(externalFont);
		btnygn.setTypeface(externalFont);
		btnmdy.setTypeface(externalFont);
		btnoth.setTypeface(externalFont);
		btsearch.setTypeface(externalFont);
		btnnpt.setOnClickListener(this);
		btnygn.setOnClickListener(this);
		btnmdy.setOnClickListener(this);
		btnoth.setOnClickListener(this);
		btsearch.setOnClickListener(this);
	}

}
