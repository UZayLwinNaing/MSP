package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.content.Intent;
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

public class AboutUs extends Activity{
    TextView tvtextt,text;
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
		text = (TextView) findViewById(R.id.tvtext1);
		text.setText("About Us");
		tvtextt.setText(Html.fromHtml(
	            "<br><b><b>MYANMAR SUPER PAGES DIRECTORY</b>" +
	            "<br>(The Best PLATFORM to market your products and services)</b>" +
	            		
	            "<br><br><b>ADVANCED COMMUNICATIONS MYANMAR COMPANY LIMITED. (SINCE 1994)</b>" +
	            "<br>Advanced Communications Myanmar Co. Ltd. or more popularly referred to as Myanmar Telephone Directory Group, is the nation’s oldest and most respectable directories publisher of Myanmar as the sole and exclusive owner of the Union’s Telephone Directory Publishing Rights since 1994 Myanmar Telephone Directory Group launches the new product “MYANMAR SUPERPAGES DIRECTORY” to replace the Myanmar Telephone Directory in year 2017. This INAUGURAL business directory be out in the market beginning of 2017 and beyond, and its online and mobile applications will be developed and expanded rapidly with a view to sustain our positions as the Union number ONE operator/publisher of Myanmar’s business directory offering not only anb INTEGRATED MULTI-PLATFORM ON LINE ADVERTISING SOLUTIONS to businesses, but the state of the art DIRECTORY MARKETING SERVICES with far reaching results. The Group without doubt has successfully forged a lasting relationship with the people of the Union of Myanmar and this has been the cornerstone of Group ability to emerge as the number 1 directory. NI LWIN SOE PUBLISHING HOUSE currently boasts of the following products and services;</b>" +
	            "<br>(i) Myanmar Super Pages Directory (Annual Publication and circulated in printed copies, CD-ROMs, online Website and mobile applications )</b>" +
	            "<br>(ii) The Naypyitaw Directory (Annual Publication)</b>" +
	            
				"<br><br><b>OUR VISION</b>" +
				"<br> To be the bridge as well as a gateway for enterprises and businesses, both local and foreign in seeking for a better future.</b>" +
	            
				"<br><br><b>CORPORATE MISSION</b>" +
				"<br>To be the Union number “1” Directory dedicated and committed to provide not only an INTEGRATED MULTIPLATFORM ADVERTISING SOLUTIONS but the state of the art DIRECTORY LISTING SERVICES with far reaching results.</b>" +
				
				"<br><br><b>VISIT MYANMAR SUPER PAGES WEBSITE FOR INFORMATION AND GUIDANCE</b>" +
				"<br>Interested clients are cordially invited to visit our internet websites as indicated below which are also available in Mobile Version;</b>" +
				"<br>www.myanmarsuperpages.com and</b>" +
				"<br>www.myanmar-yellowpages.com</b>" +
				"<br>The websites provide guidelines on how to advertise, tariffs and all other relevant information. Free download installation is available. The Myanmar Super Pages Directory mobile phone application is available in Android Version at Google Play Store and other major android application stores.</b>" +
					            
				"<br><br><b>The Myanmar Super Pages Directory – General Guidelines and Adverts</b>" +
				"<br>The Publication has 4 major sections for Clients to place their adverts:</b>" +

				"<br><br><b>Information Section</b>" +
				"<br>Provides a general information on Important & useful telephone numbers of Naypyitaw and Yangon, International and national telephone area codes, Postal Codes, Foreign Embassies, International Organizations and iNGOs .</b>" +
				
				"<br><br><b>White Pages Section (Alphabetical Business Directory)</b>" +
				"<br>This section provides nationwide alphabetical business listings plus advertisers including Naypyitaw, Yangon and the capital of States and Regions in Myanmar.</b>" +				
				
				"<br><br><b>Premier Colour Advertising Section</b>" +
				"<br> Interested clients looking for a premier advertising space can avail themselves to either advertise their company services and products in 2 separate premier sub sections namely;</b>" +		
				"<br>Premier Colour Advert Sub Section designated before the White Pages Section of the Publication and/or</b>" +		
				"<br>Premier Colour Advert Sub Section designated between the White Pages Section and the Business Directory Section of the Publication.</b>" +		
				"<br>These exclusive and premier advertising sub sections have been made available with a view to generate a greater visual impact on clients’ special products and services, necessary to bring about a higher sales turnover in the years ahead. The demand for advertising space in the Premier Colour Advert Section has increased significantly over the years and advertising space availability in based on a first come first serve basis. Tariff rates are affordable and competitive.</b>" +
				
				"<br><br><b>Business Directory Section (Classified Business Directory)</b>" +
				"<br> This section provides the nationwide classified business directory with contact addresses, telephone numbers, fax numbers, email addresses, websites and all relevant information that are important to clients/users. The listings and advertisements are grouped under more than 600 business classifications. The Business Directory Section offers a window as well as a gateway for businesses and enterprises, both local and foreign to make inroads into the newly emerging market of Myanmar</b>" +
				
				"<br><br><b>CIRCULATION AND DISTRIBUTION</b>" +
				"<br> The Myanmar Super Pages Directory is not only the most widely circulated directory in Union of Myanmar but also takes pride in being the nation’s oldest and most respectable directory. Its circulation is nationwide with emphasis on target groups such as companies, hotels, motels & Inns, stores, restaurants, shops & factories. Distributions and circulations are being undertaken efficiently and on a fixed schedule by our mobile sales and collection teams located head office in Yangon and its branch offices in Naypyitaw & Mandalay. Circulation and distribution in selected countries abroad are being done through our appointed sales agents overseas.</b>" +
				
				"<br><br><b>PRINTING AND PRODUCTION</b>" +
				"<br> The Printing and binding of this important Publication is currently being undertaken by one of Asia’s leading and respectable printer i.e. the KHL Press Co Ltd Singapore. It is the aim of us to ensure that the high quality standard of such publication be given top priority.The CD Rom and Internet Websites have been developed in collaboration with qualified and competent local IT companies. The internet websites www.myanmarsuperpages.com what came online in 2017 and www.myanmar-yellowpages.com what came online in 2004 have both received good ratings with the number of visitors increasing annually.</b>" +

				"<br><br><b>SALES AND CIRCULATION SCHEDULES for forthcoming Year 2018 publication</b>" +
				"<br> To be the bridge as well as a gateway.</b>" +
				
				"<br><br><b>OUR VISION</b>" +
				"<br>Naypyitaw : Regional Office</b>" +
				"<br>A.Closing Date for Advertising Submission: August 31st 2017 </b>" +
				"<br>B.Closing Date for Design Submission: September 30th 2017 </b>" +
				"<br>C.Closing Date for Advertising Submission: October 31st 2017 </b>" +
				"<br>D.Distribution/circulation Date: January 2018 </b>" +
				
				"<br><br><b>HISTORY (Mile Stones)</b>" +
				"<br>17th March 1994	- Incorporation of Advanced Communications Myanmar Co Ltd in accordance with the law of the Union of Myanmar</b>" +
				"<br>29th July 1994	– The signing of the Telephone Directory Concession Agreement for the first five years term (1994-1999) was signed by Advanced Communications of Myanmar Co Ltd and Myanma Posts and Telecommunications (MPT) Ministry of Communications, Posts and Telegraph</b>" +
				"<br>First quarter 1995	– The first publication and distribution of Myanmar’s nationwide Telephone Directory and Official Yellow Pages.</b>" +
				"<br>1999	– The signing of the Telephone Directory Concession Agreement first renewal for the Second five years term (2000-2004) was signed. </b>" +
				"<br>2002	– The launch of Myanmar Telephone Directory & Official Yellow Pages Website “myanmarteldir.com.mm”. </b>" +
				"<br>2003	– the launch of Myanmar Telephone Directory & Official Yellow Pages Website “myanmarteldir.com” and myanmar-yellowpages.com by Advanced Communications of Myanmar Co Ltd (ACM).</b>" +
				"<br>2004	– The launch of the ACM’s first regional directory i.e. The Shan State (South) Telephone Directory.</b>" +
				"<br>November 2004	– the signing of the Telephone Directory Concession Agreement Second renewal for the Third five years term (2005-2009) was signed. </b>" +
				"<br>2005	– The launch of Myanmar Telephone Directory & Official Yellow Pages new product CD-ROM. </b>" +
				"<br>2006	– The Mandalay branch office was opened.</b>" +
				"<br>2007	– The launch of Naypyitaw Telephone Directory, the first directory for Myanmar's new capital. The Naypyitaw branch office was opened. </b>" +
				"<br>2009	– The signing of the Telephone Directory Concession Agreement Third renewal for the Forth Five years term (2010-2014) was signed. </b>" +
				"<br>2010	– The new products The Naypyitaw Directory and The Map of Naypyitaw were launched by Ni Lwin Soe & Associates Co., Ltd. (Mother Company of Ni Lwin Soe Publishing House). In collaboration with Naypyitaw Development Committee.</b>" +
				"<br>2011	– The launch of the ACM’s regional directory i.e. The Chin State Telephone Directory – 2011 </b>" +
				"<br>2012	– The launch of the ACM’s regional directory i.e. The Magwe Telephone Directory (2012-13). </b>" +
				"<br>2014	- The Myanmar Telephone Directory launching Mobile applications (Android and iOS) collaboration with qualified and competent local IT Company Myanmars.Net. </b>" +
				"<br>2015	- Forming the Ni Lwin Soe Publishing House accordance with the law of the Union of Myanmar. 2015 - The Super Pages Directory launching the Android Mobile applications at Google Play Store by Ni Lwin Soe Publishing House.</b>" +
				"<br>2016	- Myanmar Telephone Directory Group launches the new product “MYANMAR SUPER PAGESDIRECTORY” to replace the Myanmar Telephone Directory in year 2017. This INAUGURAL business directory is out in the market beginning of 2017 and beyond. </b>" +
				"<br>2007	– “MYANMAR SUPER PAGESDIRECTORY” office will relocate to new place on April 2017. We are staying at this present office since 19995. </b>" +
				
				"<br><br><b>CONTACT US FOR ASSISTANCE AND CONSULTATION: </b>" +
				"<br><br><b>Contact Information : </b>" +
				
				"<br><br><b>Head Office : </b>" +
				"<br>Contact Person:U Ni Lwin Soe, Managing Director </b>" +
				"<br>Address :15(C),Inya Myaing Road,Golden Valley,Bahan Township, Yangon, Myanmar. </b>" +
				"<br>Phone :+ (95-1) 525380, 525384, 525372, 534766 Fax : + (95-1) 525364 </b>" +
				"<br>Email :acmmyanmar@gmail.com ; mmsuperpages@gmail.com </b>" +
				"<br>Website :http://www.myanmar-yellowpages.com, http://www.myanmarsuperpages.com </b>" +
				"<br><br><b>Naypyitaw : Regional Office </b>" +
				
				"<br>Contact Person: Daw Mar Mar Swe, Manager </b>" +
				"<br>Address :Blk-1191,Yarza Htarni Rd., Paung Laung (3) Qtr, Pyinmana, Naypyitaw, Myanmar. </b>" +
				"<br>Phone :+ (95-67) 23593, 23594 </b>" +
				"<br><br><b>Mandalay : Regional Office </b>" +
				
				"<br>Contact Person: Manager </b>" +
				"<br>Address : D-205, Shwe Phyu Plaza, Bet. 32nd and 33rd St., Bet. 77th and 78th St., Mandalay, Myanmar. </b>" +
				"<br>Phone :+ (95-67) 23593, 23594 <br><br><br></b>" 
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
					Intent i1 = new Intent(AboutUs.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(AboutUs.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(AboutUs.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(AboutUs.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(AboutUs.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(AboutUs.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(AboutUs.this,Feedback.class);
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
