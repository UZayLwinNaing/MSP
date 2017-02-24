package com.mmsp.myanmarsuperpages;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Main_Searchwithbusinessname extends Activity{
	
    String cat_name;
    String busname;
    String cat_id;
   TextView catname;
   ListView lv;
	View footerview,nolist;

	ArrayList<Description> cus_category;
	DatabaseHelper myDbHelper;
	ListAdapter adapter;
	
   private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	ImageView mbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category_search);
		myDbHelper = new DatabaseHelper(this);
		Intent intent = getIntent();
		 busname = intent.getStringExtra("BUSNAME");
		 cat_id = intent.getStringExtra("CATID");
		 cat_name = intent.getStringExtra("CATNAME");
		 catname = (TextView) findViewById(R.id.txt_dialog_title2);
		 lv = (ListView) findViewById(R.id.list_mainsearch);
		 mbtn = (ImageView) findViewById(R.id.iv);
		 
		 if(cat_id.equals("-1")){
			 catname.setText("Include in "+busname);
		 }else{
			 catname.setText(cat_name);
		 }
		setAdapterToListview(busname,cat_id);
		DropDown();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) {	
						if(cus_category.size() == 0){
					
						}else{
								Intent intent = new Intent(Main_Searchwithbusinessname.this,Main_allDetail.class);
								intent.putExtra("NAME", cus_category.get(position).get_name());
								intent.putExtra("CAT", cus_category.get(position).get_catId());
								intent.putExtra("LOC", cus_category.get(position).get_locId());
								startActivity(intent);
						}
					}
				});
	}
	public void setAdapterToListview(String str_name,String str_catid) {
		cus_category = myDbHelper.getsearchbynameandcat_main(str_name,str_catid);
		if(cus_category.size() == 0){
			Toast.makeText(getApplicationContext(), "It is not available now that city.", Toast.LENGTH_SHORT).show();
		    nolist = getLayoutInflater().inflate(R.layout.nolist,null);
		    lv.addFooterView(nolist);
		}else{
			adapter = new ListAdapter(getApplicationContext(), R.layout.list_row, cus_category);
			lv.setAdapter(adapter);
		}
	}
	
	public class ListAdapter extends ArrayAdapter<Description> {
		private ArrayList<Description> items;
		public ListAdapter(Context context, int textViewResourceId) {
			super(context, textViewResourceId);
		}
		public ListAdapter(Context context, int resource,ArrayList<Description> items) {
			super(context, resource, items);
			this.items = items;
		}
        
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.size();
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater vi;
			View v = convertView;
			vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.list_row , null);
			TextView txtname = (TextView) v.findViewById(R.id.webtitle);
			TextView tvcity = (TextView) v.findViewById(R.id.subtitle);
			ImageView ivimage = (ImageView) v.findViewById(R.id.adv);
			
			Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
			txtname.setTypeface(externalFont);
			tvcity.setTypeface(externalFont);
			
			String strname = items.get(position).get_name();
			String strloc = items.get(position).get_locId();
			String str_loc = myDbHelper.getNamelocation_popular(strloc);
			String strcat = items.get(position).get_catId();
			String str_cat = myDbHelper.getNamecategory_popular(strcat);
			txtname.setText(strname);
			tvcity.setText(str_loc +" : "+ str_cat);
			 String advcheck = items.get(position).get_adsStatus();
			if( advcheck.equals("1")){
				ivimage.setVisibility(View.VISIBLE);
			}else{
				ivimage.setVisibility(View.GONE);
			}
			return v;
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
					Intent i1 = new Intent(Main_Searchwithbusinessname.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Main_Searchwithbusinessname.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Main_Searchwithbusinessname.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Main_Searchwithbusinessname.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Main_Searchwithbusinessname.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Main_Searchwithbusinessname.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Main_Searchwithbusinessname.this,Feedback.class);
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
	private void clearlistview() {
		// TODO Auto-generated method stub
		adapter.clear();
		adapter.notifyDataSetChanged();
		//lv.removeFooterView(footerview);
		lv.removeFooterView(nolist);
	}
}
