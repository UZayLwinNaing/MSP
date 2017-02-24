package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class ContactUs extends Activity{
    TextView tvtextt;
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
		setContentView(R.layout.contactus);
		tvtextt = (TextView) findViewById(R.id.tvtext);
		Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		tvtextt.setTypeface(externalFont);
		tvtextt.setText(Html.fromHtml(
				 "<br><br><b>MYANMAR SUPER PAGES DIRECTORY</b>" +

				 "<br><br><b>Yangon Head Office</b>" +
				 "<br>Managing Director :Ni Lwin Soe (nlsed@myanmarteldir.com)</b>" +

				 "<br><br><b>Sales Department</b>" +
				 "<br>Moe Moe Aye - Director </b>" +
				 "<br>Khin Moe Moe Myint - Assistant Director</b>" +

				 "<br><br><b>UNIT(1)</b>" +
				 "<br>Aye Mya Mu – Senior Sales Manager</b>" +
				 "<br>Than Win Kyaw – Manager</b>" +
				 "<br>Phyu Phyu Tun – Manager</b>" +
				 "<br>Khine Khin Tun – Manager</b>" +
				 "<br>Moe Thet Thet Kyaw - Assistant Sales Executive</b>" +

				 "<br><br><b>UNIT(2)</b>" +
				 "<br>Sandar Aung – Manager</b>" +
				 "<br>Saw Ei Khine - Senior Sales Executive</b>" +
				 "<br>Ei Thinzar Moe - Sales Executive</b>" +
				 "<br>Han Ko Win - Sales Executive</b>" +
				 "<br>Win Sandar Aye - Assistant Sales Executive</b>" +

				 "<br><br><b>UNIT(3)</b>" +
				 "<br>Aye Aye Win – Manager</b>" +
				 "<br>Myo Myo Thaw -Senior Sales Executive</b>" +
				 "<br>Hnin Hnin Yu - Sales Executive</b>" +
				 "<br>Ei Ei Nge - Assistant Sales Executive</b>" +
				 "<br>Zeyar Phyo - Assistant Sales Executive</b>" +
				 "<br>Cherry Soe - Assistant Sales Executive</b>" +

				 "<br><br><b>UNIT(4)</b>" +
				 "<br>Aung Nyein Chan - Senior Manager</b>" +
				 "<br>Chue Thet Lae - Sales Executive</b>" +
				 "<br>Nwe Yee Win - Sales Executive</b>" +
				 "<br>Way War Lwin - Assistant Sales Executive</b>" +

				 "<br><br><b>Production Department</b>" +
				 "<br>Swe Swe Le` - Director</b>" +
				 "<br>Data & Contract Processing</b>" +

				 "<br>Kyae Mone Ei – Manager</b>" +
				 "<br>Pyae Phyo Than</b>" +
				 "<br>Pyu Pyu kyaw</b>" +

				 "<br><br><b>Graphic Design</b>" +
				 "<br>Nu Nu Kyi – Manager</b>" +
				 "<br>Phoo Pwint Han</b>" +
				 "<br>Po Po Linn</b>" +
				 "<br>Zhun Wai Moe</b>" +

				 "<br><br><b>IT</b>" +
				 "<br>Nway Nway Linn - Manager</b>" +
				 "<br>Myat Ko Ko</b>" +

				 "<br><br><b>Finance & Admin Department</b>" +
				 "<br>Myint Zu - Director</b>" +

				 "<br><br><b>Finance</b>" +
				 "<br>Aye Aye Aung - Accountant</b>" +
				 "<br>Kay Thi Myint - Assistant Accountant</b>" +

				 "<br><br><b>Admin</b>" +
				 "<br>Aung Ko Ko Win – Manager</b>" +
				 "<br>Aye Aye Mon - Admin Assistant</b>" +
				 "<br>Yee Yee Khine</b>" +

				 "<br><br><b>Operation</b>" +
				 "<br>Hashin Babulay – Supervisor</b>" +
				 "<br>U Myint Tun</b>" +
				 "<br>U Sann Nyunt Win</b>" +
				 "<br>U Ohn Kyaw</b>" +
				 "<br>U Htun Htun Oo</b>" +
				 "<br>U Maung Khaing</b>" +
				 "<br>Htun Htun</b>" +
				 "<br>Ye Naing Oo</b>" +
				 "<br>U Saw Yin Thein</b>" +

				 "<br><br><b>Myanmar Telephone Directory (Naypyitaw Branch Office)</b>" +
				 "<br>Mar Mar Swe - Branch Manager</b>" +
				 "<br>Thein Than Aung - Senior Sales Executive</b>" +
				 "<br>May Sabai Oo - Sales Executive</b>" +
				 "<br>Yan Myo Naing- Assistant Sales Executive</b>" +
				 "<br>Thae Su Hlaing- Assistant Sales Executive</b>" +
				 "<br>Ei Yadanar - Assistant Sales Executive</b>" +
				 "<br>Hayman Oo - Assistant Sales Executive</b>" +
				
				"<br><br><br><b>Myanmar Telephone Directory (Mandalay Branch Office)</b>" +
				"<br>Ohn Mar Oo - Branch Manager</b>" +
				"<br>Myot Myot Thu - Assistant Sales Executive</b>" +
				
 				"<br><br><b>CONTACT US FOR ASSISTANCE AND CONSULTATION</b>" +
			    "<br><br><b>Yangon : Head office</b>" +
			    "<br>Contact Person:U Ni Lwin Soe, Managing Director" +
			     "<br>15/C, Inya Myaing Road, Bahan Township." +
			            "<br>Tel: (+95-1) 52 5380, 52 5384, 52 5372, 53 4766" +
			            "<br>Fax: (+95-1) 52 5364" +
			            "<br>E-mail: acmmyanmar@gmail.com" +
			            "<br>E-mail: mmsuperpages@gmail.com" +
			            "<br>Website: http://www.myanmar-yellowpages.com" +
			            "<br>Website: http://www.myanmarsuperpages.com" +
			            
			            "<br><br><b>Naypyitaw : Regional Office</b>" + 
			            "<br>Contact Person: Daw Mar Mar Swe" +
			            "<br>Blk-1191, Yar Za Htar Ni Road, Paung Laung Qtr., Naypyitaw Pyinmana." +
			            "<br>Phone :+ (95-67) 23593, 23594" +
			            
			            "<br><br><b>Mandalay : Regional Office</b>" +
			            "<br>Contact Person:Manager" +
			            "<br>D-205, 2nd Floor, Shwe Phyu Plaza, Bet 32nd & 33rd Street, Bet 77th & 78th Street" +
			            "<br>Mandalay." +
			            "<br>Phone :+ (95-67) 23593, 23594 <br><br><br>"
				));
		tvtextt.setMovementMethod(LinkMovementMethod.getInstance());
		 mbtn = (ImageView) findViewById(R.id.menubtn);
			DropDown();
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
					Intent i1 = new Intent(ContactUs.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(ContactUs.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(ContactUs.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(ContactUs.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(ContactUs.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(ContactUs.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(ContactUs.this,Feedback.class);
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
