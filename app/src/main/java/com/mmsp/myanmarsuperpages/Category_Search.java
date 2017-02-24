package com.mmsp.myanmarsuperpages;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Category_Search extends Activity
{
	ArrayList<Description> cus_category;
	ListView lv;
	Context context = null;
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	ImageView mbtn;
	String str_type,str_char;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category_search);
		mbtn = (ImageView) findViewById(R.id.iv);
		DatabaseHelper myDbHelper = new DatabaseHelper(this);
			
		Intent intent = getIntent();
		str_type = intent.getStringExtra("TYPE");
		str_char = intent.getStringExtra("CHAR");
		
		cus_category = new ArrayList<Description>();
		lv = (ListView) findViewById(R.id.list_mainsearch);
		
		cus_category = myDbHelper.getchar_category(str_type,str_char);		
		ListAdapter adapter = new ListAdapter(this, R.layout.list_row, cus_category);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				if(cus_category.size() == 0){
									
				}else{
					Intent intent = new Intent(Category_Search.this,Category_Listing.class);
					int aa =   cus_category.get(position).get_id();
					intent.putExtra("CATID", String.valueOf(aa));
					startActivity(intent);
				}
			}
	    });
		DropDown();
	}
	
	public class ListAdapter extends ArrayAdapter<Description> 
	{
		private ArrayList<Description> items;
		public ListAdapter(Context context, int textViewResourceId) 
		{
			super(context, textViewResourceId);
		}
		public ListAdapter(Context context, int resource,ArrayList<Description> items) 
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
			v = vi.inflate(R.layout.listitem, null);
			TextView txtname = (TextView) v.findViewById(R.id.webtitle);
			Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
			txtname.setTypeface(externalFont);
			if(str_char.equals("ENG")){
				txtname.setText(items.get(position).get_cdespeng());
			}else{
				txtname.setText(items.get(position).get_cdespmm());
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
        quickAction.addActionItem(okItem);
        
        //Set listener for action item clicked
		quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
			@Override
			public void onItemClick(QuickAction source, int pos, int actionId) {				
				ActionItem actionItem = quickAction.getActionItem(pos);
                 
				//here we can filter which action item was clicked with pos or actionId parameter
				switch(actionId){
				case ID_POP:
					Intent i1 = new Intent(Category_Search.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Category_Search.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Category_Search.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Category_Search.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Category_Search.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Category_Search.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Category_Search.this,Feedback.class);
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