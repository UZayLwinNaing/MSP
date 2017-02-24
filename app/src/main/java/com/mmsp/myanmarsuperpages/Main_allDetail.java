package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mmsp.myanmarsuperpages.customphonecall.Mm_cdma_dialogActivity;
import com.mmsp.myanmarsuperpages.customphonecall.Mm_gsm_dialogActivity;
import com.mmsp.myanmarsuperpages.customphonecall.SimNoInfo;
import com.mmsp.myanmarsuperpages.database.DatabaseHelper;
import com.mmsp.myanmarsuperpages.database.Description;
import com.mmsp.myanmarsuperpages.imageloader.ImageLoader_large;
import com.mmsp.myanmarsuperpages.listview.horizontal.adapter.HorizontalListView;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main_allDetail extends Activity
{   
	final Context context = this;
	String temp;
	String temp1;

	 ImageView mbtn,name,img_adv;
	 TextView txtName,txtAdd,txtTitle,txtWeb,txtPh,txtPh1,txtEmail,txtcode,txtcode1,txttext;
	 LinearLayout webLayout,phLayout,phLayout1,emailLayout,advimageayout;
	 RelativeLayout bottom;
	 HorizontalListView horlistview;
	 View v;
	ImageLoader_large imageLoader;
	 private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	
	String phone_a;
	String phone_b;
	String OperatorName;
	
	TelephonyManager telephonyManager;
	boolean isDualSIM;
	
	ArrayList<Description> cus_detail;
	ArrayList<Description> cus_detail_image;
	DatabaseHelper myDbHelper;
	String str_syskey;
	String str_name;
	String str_address;
	String str_phone;
	String str_fax;
	String str_email;
	String str_websit;
	String str_title;
	String str_description;
	String str_mapLat;
	String str_mapLon;
	String str_locId;
	String str_catId;
	String str_imageId;
	String str_adsStatus;
	String str_status;
	String str_createUsr;
	
	String str_advimage;
	ConnectivityManager conMgr;
	 String str_areaphone;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.category_detail);
		DeclartaionVariable();
		myDbHelper = new DatabaseHelper(this);
		 cus_detail = new ArrayList<Description>();
		Intent intent = getIntent();
		conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		String _name = intent.getStringExtra("NAME");
		String _catid = intent.getStringExtra("CAT");
		String _locid = intent.getStringExtra("LOC");

		cus_detail = myDbHelper.getdetailList(_name,_catid,_locid);
		for (Description ER : cus_detail) { 
			str_syskey = ER.get_strsyskey().toString();
			str_name = ER.get_name().toString();
			if(ER.get_address() != null){str_address = ER.get_address();}
			if(ER.get_phone() != null){str_phone = ER.get_phone();}
			if(ER.get_fax() != null){str_fax = ER.get_fax();}
			if(ER.get_email() != null){str_email = ER.get_email();}
			if(ER.get_websit() != null){str_websit = ER.get_websit();}
			if(ER.get_title() != null){str_title = ER.get_title();}
			if(ER.get_locId() != null){str_locId = ER.get_locId();}
			if(ER.get_catId() != null){str_catId = ER.get_catId();}
			if(ER.get_imageId() != null){str_imageId = ER.get_imageId();}
			if(ER.get_adsStatus() != null){str_adsStatus = ER.get_adsStatus();}
			//str_address = ER.get_address().toString();
			//str_phone = ER.get_phone().toString();
			//str_fax = String.valueOf(ER.get_fax());
			//str_fax = ER.get_fax().toString();
			//str_email = ER.get_email().toString();
			//str_websit = ER.get_websit().toString();
			//str_title = ER.get_title().toString();
			//str_description = String.valueOf(ER.get_description().toString());
			//str_mapLat = String.valueOf(ER.get_mapLat().toString());
			//str_mapLon = String.valueOf(ER.get_mapLon().toString());
			//str_locId = ER.get_locId().toString();
			//str_catId = ER.get_catId().toString();
			//str_imageId = ER.get_imageId().toString();
			//str_adsStatus = ER.get_adsStatus().toString();
         }
		
		if(!isNetworkAvailable()){
			img_adv.setVisibility(View.VISIBLE);
			txttext.setVisibility(View.VISIBLE);
    	}else{
			if(str_adsStatus.equals("0")){
				advimageayout.setVisibility(View.GONE);
				img_adv.setVisibility(View.GONE);
				txttext.setVisibility(View.GONE);
			}else{
				advimageayout.setVisibility(View.GONE);
				img_adv.setVisibility(View.GONE);
				txttext.setVisibility(View.GONE);
				
				img_adv.setVisibility(View.VISIBLE);
				cus_detail_image = myDbHelper.getimageid_detail(String.valueOf(str_syskey));
				
				for (Description ER_IMG : cus_detail_image) {
					 if(ER_IMG.get_imgname() != null){
						 str_advimage = ER_IMG.get_imgname() ;

						// ImageView image = new ImageView(this);
						 //String ed="http://www.domain.com/image.jpg";
						 //String image_url = "http://myanmarsuperpages.com/admin/" + str_advimage;
						// image.setTag(image_url);
						//new DownloadImagesTask(getBaseContext()).execute(image);
						 String image_url = "http://myanmarsuperpages.com/admin/" + str_advimage;
						imageLoader = new ImageLoader_large(getApplicationContext());
						imageLoader.DisplayImage(image_url, img_adv);
					}
				}
				//Toast.makeText(getApplication(), "Size : "+str_advimage, Toast.LENGTH_SHORT).show();
				//http://myanmarsuperpages.com/admin/upload/0600040397A.jpg

				//More image (1 or many)
				/*cus_detail_image = myDbHelper.getimageid_detail(String.valueOf(str_syskey));
				Toast.makeText(getApplication(), "Size : "+cus_detail_image.size(), Toast.LENGTH_SHORT).show();
				if(cus_detail_image.size()==1){
					img_adv.setVisibility(View.VISIBLE);
					for (Description ER_IMG : cus_detail_image) {str_advimage = ER_IMG.get_imgname().toString(); }
					//http://myanmar-yellowpages.com/temp/admin/upload/0600040397A.jpg
					String image_url = "http://myanmar-yellowpages.com/temp/admin/" + str_advimage;
					imageLoader = new ImageLoader_large(getApplicationContext());
					imageLoader.DisplayImage(image_url, img_adv);
				}else{
					advimageayout.setVisibility(View.VISIBLE);
					cus_detail_image = myDbHelper.getimageid_detail(String.valueOf(str_syskey));
					 HAdapter hadapter= new HAdapter(CategoryDetail.this,R.layout.viewitem,cus_detail_image);
					 horlistview.setAdapter(hadapter);
				}*/
			}		
		}
		//
		if (str_address== null) {
			txtAdd.setVisibility(View.GONE);
		} else {
			String str_aaddress = myDbHelper.getAreacode(str_locId,"address");
			txtAdd.setVisibility(View.VISIBLE);
			txtAdd.setText(str_address+str_aaddress);
		}
		
		if (str_websit == null) {
			webLayout.setVisibility(View.GONE);
		} else {
			webLayout.setVisibility(View.VISIBLE);
			txtWeb.setText(str_websit);
		}
		
		if (str_email== null) {
			emailLayout.setVisibility(View.GONE);
		} else {
			emailLayout.setVisibility(View.VISIBLE);
			txtEmail.setText(str_email);
		}

		if (str_phone == null) {
			phLayout.setVisibility(View.GONE);
			phLayout1.setVisibility(View.GONE);
		} else {
			phLayout.setVisibility(View.VISIBLE);
			str_phone = "123455,11444,14212,";
			final String[] ph = str_phone.split(",");
			int ph_num = ph.length;
			txtcode.setText("(+95)");
			txtcode1.setText("(+95)");
			
			if(ph_num==0){
				phLayout.setVisibility(View.GONE);
				phLayout1.setVisibility(View.GONE);
			}else if(ph_num==1){
				if(ph[0].startsWith("09")) {
					str_areaphone =  ph[0];
					temp = str_areaphone;
				}else{
					String str_acode = myDbHelper.getAreacode(str_locId,"phone");
					str_areaphone =  str_acode+""+ph[0];
					temp = str_areaphone;
				}
				txtPh.setText(Html.fromHtml("<u>"+temp+"</u>"));
				txtPh.setTextColor(Color.BLUE);
				phLayout1.setVisibility(View.GONE);
			}else if(ph_num==2){
				//Phone one in data
				if(ph[0].startsWith("09")) {
					str_areaphone =  ph[0];
					temp = str_areaphone;
				}else{
					String str_acode = myDbHelper.getAreacode(str_locId,"phone");
					str_areaphone =  str_acode+""+ph[0];
					temp = str_areaphone;
				}
			    //Phone two in data
				if(ph[1].startsWith("09")) {
					str_areaphone =  ph[1];
					temp1 = str_areaphone;
				}else{
					String str_acode = myDbHelper.getAreacode(str_locId,"phone");
					str_areaphone =  str_acode+""+ph[1];
					temp1 = str_areaphone;
				}
				
				txtPh.setText(Html.fromHtml("<u>"+ temp+"</u>"));
				txtPh1.setText(Html.fromHtml("<u>"+ temp1+"</u>"));
				txtPh.setTextColor(Color.BLUE);
				txtPh1.setTextColor(Color.BLUE);
			}else {
				if(ph[0].startsWith("09")) {
					str_areaphone =  ph[0];
					temp = str_areaphone;
				}else{
					String str_acode = myDbHelper.getAreacode(str_locId,"phone");
					str_areaphone =  str_acode+""+ph[0];
					temp = str_areaphone;
				}
			
				if(ph[1].startsWith("09")) {
					str_areaphone =  ph[1];
					temp1 = str_areaphone;
				}else{
					String str_acode = myDbHelper.getAreacode(str_locId,"phone");
					str_areaphone =  str_acode+""+ph[1];
					temp1 = str_areaphone;
				}
				
				txtPh.setText(Html.fromHtml("<u>"+ temp+"</u>"));
				txtPh1.setText(Html.fromHtml("<u>"+ temp1+"</u>"));
				txtPh.setTextColor(Color.BLUE);
				txtPh1.setTextColor(Color.BLUE);
			}
		}
		
		telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		txtTitle.setText(str_title);
		txtName.setText(str_name);
	
		txtWeb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent webIntent = new Intent(Main_allDetail.this, WebActivity.class);
				webIntent.putExtra("URL", txtWeb.getText().toString());
				startActivity(webIntent);	
			}
		});
		txtPh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				//Get android local version
				String myAPI= Build.VERSION.SDK;
				int anAPI = Integer.parseInt(myAPI);
				
				SimNoInfo telephonyInfo = SimNoInfo.getInstance(Main_allDetail.this);
				isDualSIM =  telephonyInfo.isDualSIM();
				 if(isDualSIM == true){
					String p_num =  telephonyManager.getSimOperatorName();
					if(p_num.equals("")){
							Intent callIntent = new Intent(Intent.ACTION_CALL);
							callIntent.setData(Uri.parse("tel:"+temp1));
							startActivity(callIntent);
					}else{
						 if( anAPI < 19){
							Intent intent = new Intent(Main_allDetail.this,Mm_gsm_dialogActivity.class);
							intent.putExtra("CallPhone", temp);
							startActivity(intent);
						 }else{
							 Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					         callIntent.setData(Uri.parse("tel:"+temp));
					         startActivity(callIntent);
							 callIntent.putExtra("com.android.phone.extra.slot", 0); //For sim 1
							 callIntent.putExtra("com.android.phone.extra.slot", 1); //For sim 2
						 }
				    }
				 }else{
					 String p_num =  telephonyManager.getSimOperatorName();
					if(p_num.equals("")){
						Intent callIntent = new Intent(Intent.ACTION_CALL);
					    callIntent.setData(Uri.parse("tel:"+temp));
					     startActivity(callIntent);
					}else{
						if( anAPI < 19){
							Intent intent = new Intent(Main_allDetail.this,Mm_gsm_dialogActivity.class);
							intent.putExtra("CallPhone", temp);
							startActivity(intent);
						 }else{
							 Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					         callIntent.setData(Uri.parse("tel:"+temp));
					         startActivity(callIntent);
							 callIntent.putExtra("com.android.phone.extra.slot", 0); //For sim 1
							 callIntent.putExtra("com.android.phone.extra.slot", 1); //For sim 2
						 }
					}
				 }
			}
		});
		txtPh1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Get android local version
				String myAPI= Build.VERSION.SDK;
				int anAPI = Integer.parseInt(myAPI);
				SimNoInfo telephonyInfo = SimNoInfo.getInstance(Main_allDetail.this);
				isDualSIM =  telephonyInfo.isDualSIM();
				 if(isDualSIM == true){
					String p_num =  telephonyManager.getSimOperatorName();
					if(p_num.equals("")){
						 Intent callIntent = new Intent(Intent.ACTION_CALL);
						 callIntent.setData(Uri.parse("tel:"+temp1));
						 startActivity(callIntent);
					}else{					 
						 if( anAPI < 19){
							Intent intent = new Intent(Main_allDetail.this,Mm_gsm_dialogActivity.class);
							intent.putExtra("CallPhone", temp1);
							startActivity(intent);
						 }else{
							 Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					         callIntent.setData(Uri.parse("tel:"+temp1));
					         startActivity(callIntent);
							 callIntent.putExtra("com.android.phone.extra.slot", 0); //For sim 1
							 callIntent.putExtra("com.android.phone.extra.slot", 1); //For sim 2
						 }
					}
				 }else{
					String operator  =  telephonyManager.getNetworkOperator();
					if(operator.equals("41404")){
						Intent intent = new Intent(Main_allDetail.this,Mm_cdma_dialogActivity.class);
						intent.putExtra("CallPhone", temp1);
						startActivity(intent);
					}else{
						String p_num =  telephonyManager.getSimOperatorName();
						if(p_num.equals("")){
							Intent callIntent = new Intent(Intent.ACTION_CALL);
						    callIntent.setData(Uri.parse("tel:"+temp1));
						     startActivity(callIntent);
						}else{
							if( anAPI < 19){
								Intent intent = new Intent(Main_allDetail.this,Mm_gsm_dialogActivity.class);
								intent.putExtra("CallPhone", temp1);
								startActivity(intent);
							 }else{
								 Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						         callIntent.setData(Uri.parse("tel:"+temp1));
						         startActivity(callIntent);
								 callIntent.putExtra("com.android.phone.extra.slot", 0); //For sim 1
								 callIntent.putExtra("com.android.phone.extra.slot", 1); //For sim 2
							 }
						}
					}
				 }
			}
		});
	    DropDown();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private class DownloadImagesTask extends AsyncTask<ImageView, Void, Bitmap> {

		ImageView imageView = null;
		ProgressDialog dialog;
		Context context;

		public DownloadImagesTask(Context context) {
			this.context = context;
		}

		@Override
		protected Bitmap doInBackground(ImageView... imageViews) {
			this.imageView = imageViews[0];
			return download_Image((String)imageView.getTag());
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			imageView.setImageBitmap(result);
			if (dialog != null)
				dialog.dismiss();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = ProgressDialog.show(context, "Title","Message");
		}

		private Bitmap download_Image(String url) {

			Bitmap bmp =null;
			try{
				URL ulrn = new URL(url);
				HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
				InputStream is = con.getInputStream();
				bmp = BitmapFactory.decodeStream(is);
				if (null != bmp)
					return bmp;

			}catch(Exception e){}
			return bmp;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public class HAdapter extends ArrayAdapter<Description> {
		
		ArrayList<Description> item;
		private LayoutInflater layoutInflater;
		LinearLayout liner_layout1;
		Context context;
			
		public HAdapter(Context context,int resourceId,ArrayList<Description> data) {
			super(context,resourceId,data);
			 this.item = data;
			 this.context = context;
			layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			// Inflate the item layout and set the views
			View listItem = convertView;
			final int pos = position;
			if (listItem == null) {
				listItem = layoutInflater.inflate(R.layout.viewitem, null);
			}
			ImageView img_hor_detail = (ImageView) listItem.findViewById(R.id.img_hor_detail);
			String str_image = item.get(position).get_imgname();
			//http://myanmar-yellowpages.com/temp/admin/upload/0600040397A.jpg
			String image_url = "http://myanmar-yellowpages.com/temp/admin/" + str_image;
			imageLoader = new ImageLoader_large(getApplicationContext());
			imageLoader.DisplayImage(image_url, img_hor_detail);
			return listItem;
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
					Intent i1 = new Intent(Main_allDetail.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Main_allDetail.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Main_allDetail.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Main_allDetail.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Main_allDetail.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Main_allDetail.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Main_allDetail.this,Feedback.class);
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
	
	private void DeclartaionVariable() {
		// TODO Auto-generated method stub
		txtTitle = (TextView) findViewById(R.id.title);
		 txtName = (TextView) findViewById(R.id.webtitle);
		 txtAdd = (TextView) findViewById(R.id.address);
		 txtWeb = (TextView) findViewById(R.id.popular);
		 txtPh = (TextView) findViewById(R.id.search_cat);
		 txtPh1 = (TextView) findViewById(R.id.search_cat1);
		 txtEmail = (TextView) findViewById(R.id.next4);
         txtcode =(TextView) findViewById(R.id.search_ph);
         txtcode1 =(TextView) findViewById(R.id.search_ph1);
         txttext = (TextView) findViewById(R.id.tvintenttext);
		 webLayout = (LinearLayout) findViewById(R.id.weblayout);
		 phLayout = (LinearLayout) findViewById(R.id.phlayout);
		 phLayout1 = (LinearLayout) findViewById(R.id.phlayout1);
		 emailLayout = (LinearLayout) findViewById(R.id.emaillayout);
		 advimageayout = (LinearLayout) findViewById(R.id.advimageayout);
		 horlistview = (HorizontalListView) findViewById(R.id.list_deatil_image);
		 img_adv = (ImageView) findViewById(R.id.img_adv);
		 imageLoader = new ImageLoader_large(context);
		 mbtn = (ImageView) findViewById(R.id.iv);
		 
		 Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		 txtName.setTypeface(externalFont);
		 txtAdd.setTypeface(externalFont);
		 //txtTitle.setTypeface(externalFont);
		 txtWeb.setTypeface(externalFont);
		 txtPh.setTypeface(externalFont);
		 txtPh1.setTypeface(externalFont);
		 txtEmail.setTypeface(externalFont);
		 txtcode.setTypeface(externalFont);
		 txtcode1.setTypeface(externalFont);
		 txttext.setTypeface(externalFont);
		 
		 advimageayout.setVisibility(View.GONE);
		 img_adv.setVisibility(View.GONE);
	}
	
	 public boolean isNetworkAvailable() {
		    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
		    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}