package com.mmsp.myanmarsuperpages;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.Popular_SearchResult.ListAdapter;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Category_Listing extends Activity implements OnClickListener
{
	ArrayList<Description> cus_category;
	ListView lv;
	TextView tvnay,tvygn,tvmdy,tvoth,title;
	DatabaseHelper myDbHelper;
	ListAdapter adapter;
	String cat_id;
	View footerview,nolist;
	LayoutInflater inflater;
	boolean boo = false;
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	ImageView mbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category_listing);

		Intent intent = getIntent();
		cat_id = intent.getStringExtra("CATID");
	    tvnay = (TextView) findViewById(R.id.tvNay);
		tvygn = (TextView) findViewById(R.id.tvYan);
		tvmdy = (TextView) findViewById(R.id.tvMan);
		tvoth = (TextView) findViewById(R.id.tvOther);
		mbtn = (ImageView) findViewById(R.id.iv);
		
		lv = (ListView) findViewById(R.id.search_cat_list);
		
		cus_category = new ArrayList<Description>();

		TextView title = (TextView) findViewById(R.id.txt_dialog_title2);
		//title.setText(cat_id);
		myDbHelper = new DatabaseHelper(this);
		setAdapterToListview("000");
        DropDown();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) {	
				//please change phone one(get_phone1) and code(get_ccode)
				if(cus_category.size() == 0){
									
				}else{			
					Intent intent = new Intent(Category_Listing.this,Main_allDetail.class);
					intent.putExtra("NAME", cus_category.get(position).get_name());
					intent.putExtra("CAT", cus_category.get(position).get_catId());
					intent.putExtra("LOC", cus_category.get(position).get_locId());
					startActivity(intent);
				}
			}
		});
		tvnay.setOnClickListener(this);
		tvygn.setOnClickListener(this);
		tvmdy.setOnClickListener(this);
		tvoth.setOnClickListener(this);
 	}

	public void setAdapterToListview(String strlocation) {
		if(strlocation.equals("ygn")){
			cus_category = myDbHelper.getpopularCatList(cat_id,strlocation);
		}else if(strlocation.equals("mdy")){
			cus_category = myDbHelper.getpopularCatList(cat_id,strlocation);
		}else if(strlocation.equals("npt")){
			cus_category = myDbHelper.getpopularCatList(cat_id,strlocation);
		}else if(strlocation.equals("other")){
			cus_category = myDbHelper.getpopularCatList(cat_id,strlocation);
		}else{
			cus_category = myDbHelper.getpopularCatList(cat_id,strlocation);
		}
		if(cus_category.size() == 0){
			Toast.makeText(getApplicationContext(), "It is not available now that city.", Toast.LENGTH_SHORT).show();
			clearlistview();
		    nolist = getLayoutInflater().inflate(R.layout.nolist,null);
		    lv.addFooterView(nolist);
		}else{
			adapter = new ListAdapter(getApplicationContext(), R.layout.list_row, cus_category);
			lv.setAdapter(adapter);
		}
	}

	public class ListAdapter extends ArrayAdapter<Description> 
	{
		private ArrayList<Description> items;

		public ListAdapter(Context context, int textViewResourceId) 
		{
			super(context, textViewResourceId);
		}

		public ListAdapter(Context context, int resource,
				ArrayList<Description> items) 
		{
			super(context, resource, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			LayoutInflater vi;
			View v = convertView;
			vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.list_row, null);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.tvNay:
			boo = false;
			tvnay.setTextColor(Color.parseColor("#1084cd"));
			tvygn.setTextColor(Color.parseColor("#6F6F6F"));
			tvmdy.setTextColor(Color.parseColor("#6F6F6F"));
			tvoth.setTextColor(Color.parseColor("#6F6F6F"));
			clearlistview();
			setAdapterToListview("npt");
			break;
		case R.id.tvYan:
			boo = false;
			tvygn.setTextColor(Color.parseColor("#1084cd"));
			tvnay.setTextColor(Color.parseColor("#6F6F6F"));
			tvmdy.setTextColor(Color.parseColor("#6F6F6F"));
			tvoth.setTextColor(Color.parseColor("#6F6F6F"));
			clearlistview();
			setAdapterToListview("ygn");
			break;
		case R.id.tvMan:
			boo = false;
			tvmdy.setTextColor(Color.parseColor("#1084cd"));
			tvygn.setTextColor(Color.parseColor("#6F6F6F"));
			tvnay.setTextColor(Color.parseColor("#6F6F6F"));
			tvoth.setTextColor(Color.parseColor("#6F6F6F"));
			clearlistview();
			setAdapterToListview("mdy");
			break;
		case R.id.tvOther:
			boo = true;
			tvoth.setTextColor(Color.parseColor("#1084cd"));
			tvygn.setTextColor(Color.parseColor("#6F6F6F"));
			tvmdy.setTextColor(Color.parseColor("#6F6F6F"));
			tvnay.setTextColor(Color.parseColor("#6F6F6F"));
			clearlistview();
			setAdapterToListview("other");
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
       
        final QuickAction  quickAction = new QuickAction(this, QuickAction.VERTICAL);
		//add action items into QuickAction
        quickAction.addActionItem(nextItem);
		quickAction.addActionItem(prevItem);
        quickAction.addActionItem(searchItem);
        quickAction.addActionItem(infoItem);
        quickAction.addActionItem(eraseItem);
        quickAction.addActionItem(okItem);
        
        //Set listener for action item clicked
		quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
			@Override
			public void onItemClick(QuickAction source, int pos, int actionId) {				
				ActionItem actionItem = quickAction.getActionItem(pos);
                 
				//here we can filter which action item was clicked with pos or actionId parameter
				switch(actionId){
				case ID_POP:
					Intent i1 = new Intent(Category_Listing.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Category_Listing.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Category_Listing.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Category_Listing.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Category_Listing.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Category_Listing.this,ContactUs.class);
					startActivity(i6);
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