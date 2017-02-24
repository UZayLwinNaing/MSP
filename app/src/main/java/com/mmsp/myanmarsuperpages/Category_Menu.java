package com.mmsp.myanmarsuperpages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.pop.ActionItem;
import com.mmsp.myanmarsuperpages.pop.QuickAction;

public class Category_Menu extends Activity implements OnClickListener 
{   
	private static final int ID_SCAT     = 1;
	private static final int ID_POP   = 2;
	private static final int ID_SN = 3;
	private static final int ID_SC  = 4;
	private static final int ID_AU  = 5;	
	private static final int ID_CU    = 6;
	private static final int ID_FB    = 7;
	ImageView mbtn;
	ImageView img_category_mm;
	ImageView img_category_eng;
	LinearLayout LinearLayout001;
	LinearLayout LinearLayout011;
	
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v_,w,x,y,z;
    Button btn_a,btn_b,btn_c,btn_d,btn_e,btn_f,btn_g,btn_h;
    Button btnAll ;
    String str_chartype;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Display display = getWindowManager().getDefaultDisplay();
		  Point size = new Point();
		  display.getSize(size);
		  int width = size.x;
		  int height = size.y;
		  if(width == 720){
			  setContentView(R.layout.category_menulrg);
		  }
		  else
		     setContentView(R.layout.category_menu);

	 img_category_mm = (ImageView) findViewById(R.id.img_category_mm);
	 img_category_eng = (ImageView) findViewById(R.id.img_category_en);
	 LinearLayout001 = (LinearLayout) findViewById(R.id.LinearLayout001);
	 LinearLayout011 = (LinearLayout) findViewById(R.id.LinearLayout011);
	 //img_category_mm.setVisibility(View.INVISIBLE);
	 //img_category_eng.setVisibility(View.INVISIBLE);
	 LinearLayout001.setVisibility(View.GONE);
	 LinearLayout011.setVisibility(View.GONE);
	 Declaration ();	
     mbtn = (ImageView) findViewById(R.id.iv);
     img_category_mm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 LinearLayout001.setVisibility(View.VISIBLE);
				 LinearLayout011.setVisibility(View.VISIBLE);
				 z.setVisibility(View.GONE);
				a.setText(getResources().getText(R.string.char_mma));
				b.setText(getResources().getText(R.string.char_mma1));
				c.setText(getResources().getText(R.string.char_mma2));
				d.setText(getResources().getText(R.string.char_mma3));
				e.setText(getResources().getText(R.string.char_mma4));
				
				f.setText(getResources().getText(R.string.char_mmb));
				g.setText(getResources().getText(R.string.char_mmb1));
				h.setText(getResources().getText(R.string.char_mmb2));
				i.setText(getResources().getText(R.string.char_mmb3));
				j.setText(getResources().getText(R.string.char_mmb4));
				
				k.setText(getResources().getText(R.string.char_mmc));
				l.setText(getResources().getText(R.string.char_mmc1));
				m.setText(getResources().getText(R.string.char_mmc2));
				n.setText(getResources().getText(R.string.char_mmc3));
				o.setText(getResources().getText(R.string.char_mmc4));
				
				p.setText(getResources().getText(R.string.char_mmd));
				q.setText(getResources().getText(R.string.char_mmd1));
				r.setText(getResources().getText(R.string.char_mmd2));
				s.setText(getResources().getText(R.string.char_mmd3));
				t.setText(getResources().getText(R.string.char_mmd4));
				
				u.setText(getResources().getText(R.string.char_mme));
				v_.setText(getResources().getText(R.string.char_mme1));
				w.setText(getResources().getText(R.string.char_mme2));
				x.setText(getResources().getText(R.string.char_mme3));
				y.setText(getResources().getText(R.string.char_mme4));
				
				btn_a.setText(getResources().getText(R.string.char_mmf));
				btn_b.setText(getResources().getText(R.string.char_mmf1));
				btn_c.setText(getResources().getText(R.string.char_mmf2));
				btn_d.setText(getResources().getText(R.string.char_mmf3));
				btn_e.setText(getResources().getText(R.string.char_mmf4));
				
				btn_f.setText(getResources().getText(R.string.char_mmg));
				btn_g.setText(getResources().getText(R.string.char_mmg1));
				btn_h.setText(getResources().getText(R.string.char_mmg2));
			}
		});
         
         img_category_eng.setOnClickListener(new OnClickListener() {
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 LinearLayout001.setVisibility(View.GONE);
				 LinearLayout011.setVisibility(View.GONE);
				 z.setVisibility(View.VISIBLE);
				 Declaration ();
			}
		});
		btnAll.setOnClickListener(this);

		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);

		f.setOnClickListener(this);
		g.setOnClickListener(this);
		h.setOnClickListener(this);
		i.setOnClickListener(this);
		j.setOnClickListener(this);

		k.setOnClickListener(this);
		l.setOnClickListener(this);
		m.setOnClickListener(this);
		n.setOnClickListener(this);
		o.setOnClickListener(this);

		p.setOnClickListener(this);
		q.setOnClickListener(this);
		r.setOnClickListener(this);
		s.setOnClickListener(this);
		t.setOnClickListener(this);

		u.setOnClickListener(this);
		v_.setOnClickListener(this);
		w.setOnClickListener(this);
		x.setOnClickListener(this);
		y.setOnClickListener(this);

		z.setOnClickListener(this);

		 btn_a.setOnClickListener(this);
		 btn_b.setOnClickListener(this);
		 btn_c.setOnClickListener(this);
		 btn_d.setOnClickListener(this);
		 btn_e.setOnClickListener(this);
		 btn_f.setOnClickListener(this);
		 btn_g.setOnClickListener(this);
		 btn_h.setOnClickListener(this);
		
		DropDown();
	}
	public void Declaration (){
		 a = (Button) findViewById(R.id.a);
		 b = (Button) findViewById(R.id.b);
		 c = (Button) findViewById(R.id.c);
		d = (Button) findViewById(R.id.d);
		 e = (Button) findViewById(R.id.e);
		 f = (Button) findViewById(R.id.f);
		 g = (Button) findViewById(R.id.g);
		 h = (Button) findViewById(R.id.h);
		 i = (Button) findViewById(R.id.i);
		 j = (Button) findViewById(R.id.j);
		 k = (Button) findViewById(R.id.k);
		 l = (Button) findViewById(R.id.l);
		 m = (Button) findViewById(R.id.m);
		 n = (Button) findViewById(R.id.n);
		 o = (Button) findViewById(R.id.o);
		 p = (Button) findViewById(R.id.p);
		 q = (Button) findViewById(R.id.q);
		 r = (Button) findViewById(R.id.r);
		 s = (Button) findViewById(R.id.s);
		 t = (Button) findViewById(R.id.t);
		 u = (Button) findViewById(R.id.u);
		 v_ = (Button) findViewById(R.id.v);
		 w = (Button) findViewById(R.id.w);
		 x = (Button) findViewById(R.id.x);
		 y = (Button) findViewById(R.id.y);
		 z = (Button) findViewById(R.id.z);
		 
		 btn_a= (Button) findViewById(R.id.btn_a);
		 btn_b= (Button) findViewById(R.id.btn_b);
		 btn_c= (Button) findViewById(R.id.btn_c);
		 btn_d= (Button) findViewById(R.id.btn_d);
		 btn_e= (Button) findViewById(R.id.btn_e);
		 btn_f= (Button) findViewById(R.id.btn_f);
		 btn_g= (Button) findViewById(R.id.btn_g);
		 btn_h= (Button) findViewById(R.id.btn_h);
		 btnAll = (Button) findViewById(R.id.btnallcat);
		 //Add External font
		 Typeface externalFont=Typeface.createFromAsset(getAssets(), "myanmar3.ttf");
		 a.setTypeface(externalFont);
		 b.setTypeface(externalFont);
		 c.setTypeface(externalFont);
		 d.setTypeface(externalFont);
		 e.setTypeface(externalFont);
		 f.setTypeface(externalFont);
		 g.setTypeface(externalFont);
		 h.setTypeface(externalFont);
		 i.setTypeface(externalFont);
		 j.setTypeface(externalFont);
		 k.setTypeface(externalFont);
		 l.setTypeface(externalFont);
		 n.setTypeface(externalFont);
		 m.setTypeface(externalFont);
		 o.setTypeface(externalFont);
		 p.setTypeface(externalFont);
		 q.setTypeface(externalFont);
		 r.setTypeface(externalFont);
		 s.setTypeface(externalFont);
		 t.setTypeface(externalFont);
		 u.setTypeface(externalFont);
		 v_.setTypeface(externalFont);
		 w.setTypeface(externalFont);
		 
		 w.setTypeface(externalFont);
		 x.setTypeface(externalFont);
		 y.setTypeface(externalFont);
		 
		 z.setTypeface(externalFont);
		 btn_a.setTypeface(externalFont);
		 btn_b.setTypeface(externalFont);
		 btn_c.setTypeface(externalFont);
		 btn_d.setTypeface(externalFont);
		 btn_e.setTypeface(externalFont);
		 btn_f.setTypeface(externalFont);
		 btn_g.setTypeface(externalFont);
		 btn_h.setTypeface(externalFont);
		 btnAll.setTypeface(externalFont);

		a.setText("A");
		b.setText("B");
		c.setText("C");
		d.setText("D");
		e.setText("E");
		
		f.setText("F");
		g.setText("G");
		h.setText("H");
		i.setText("I");
		j.setText("J");
		
		k.setText("K");
		l.setText("L");
		m.setText("M");
		n.setText("N");
		o.setText("O");
		
		p.setText("P");
		q.setText("Q");
		r.setText("R");
		s.setText("S");
		t.setText("T");
		
		u.setText("U");
		v_.setText("V");
		w.setText("W");
		x.setText("X");
		y.setText("Y");
		z.setText("Z");
	}
	@Override
	public void onClick(View v) 
	{
		Intent intent = new Intent(this, Category_Search.class);
		if(a.getText().toString() == "A"){
			str_chartype = "ENG";
		}else{
			str_chartype = "MM";
		}
		  intent.putExtra("CHAR",  str_chartype);
         switch(v.getId()){
	         	case R.id.a:
	        	 intent.putExtra("TYPE",  a.getText().toString());
	        	 break;
	         	case R.id.b:
	        	 intent.putExtra("TYPE", b.getText().toString());
	        	 break;
	         case R.id.c:
	        	intent.putExtra("TYPE", c.getText().toString());
	        	 break;
	        case R.id.d:
			   intent.putExtra("TYPE", d.getText().toString());   	 
				        	 break;
		   	case R.id.e:
				 intent.putExtra("TYPE", e.getText().toString());
				 break;
			 case R.id.f:
				 intent.putExtra("TYPE", f.getText().toString());
				 break;
			 case R.id.g:
				 intent.putExtra("TYPE", h.getText().toString());
				 break;
			 case R.id.h:
				 intent.putExtra("TYPE", h.getText().toString());
				 break;
			 case R.id.i:
				 intent.putExtra("TYPE",i.getText().toString());
				 break;
			 case R.id.j:
				 intent.putExtra("TYPE", j.getText().toString());
				 break;
			 case R.id.k:
				 intent.putExtra("TYPE", k.getText().toString());
				 break;
			 case R.id.l:
				 intent.putExtra("TYPE", l.getText().toString());
				 break;
			 case R.id.m:
				 intent.putExtra("TYPE", m.getText().toString());
				 break;
			 case R.id.n:
				 intent.putExtra("TYPE", n.getText().toString());
				 break;
			 case R.id.o:
				 intent.putExtra("TYPE", o.getText().toString());
				 break;
			 case R.id.p:
				 intent.putExtra("TYPE", p.getText().toString());
				 break;
			 case R.id.q:
				 intent.putExtra("TYPE", q.getText().toString());
				 break;
			 case R.id.r:
				 intent.putExtra("TYPE", r.getText().toString());
				 break;
			 case R.id.s:
				 intent.putExtra("TYPE", s.getText().toString());
				 break;
			 case R.id.t:
				 intent.putExtra("TYPE", t.getText().toString());
				 break; 
				 case R.id.u:
					 intent.putExtra("TYPE", u.getText().toString());
			    	 break;
				 case R.id.v:
					 intent.putExtra("TYPE", v_.getText().toString());
			    	 break;
				 case R.id.w:
					 intent.putExtra("TYPE", w.getText().toString());
			    	 break;
				 case R.id.x:
					 intent.putExtra("TYPE", x.getText().toString());
			    	 break; 
			     case R.id.y:
			    		 intent.putExtra("TYPE", y.getText().toString());
			        	 break;
			     case R.id.z:
				    intent.putExtra("TYPE", z.getText().toString());
        	       break;
			     case R.id.btn_a:
					    intent.putExtra("TYPE", btn_a.getText().toString());
	        	       break;
			     case R.id.btn_b:
					    intent.putExtra("TYPE", btn_b.getText().toString());
	        	       break;
			     case R.id.btn_c:
					    intent.putExtra("TYPE", btn_c.getText().toString());
	        	       break;
			     case R.id.btn_d:
					    intent.putExtra("TYPE", btn_d.getText().toString());
	        	       break;
			     case R.id.btn_e:
					    intent.putExtra("TYPE", btn_e.getText().toString());
	        	       break;
			     case R.id.btn_f:
					    intent.putExtra("TYPE", btn_f.getText().toString());
	        	       break;
			     case R.id.btn_g:
					    intent.putExtra("TYPE", btn_g.getText().toString());
	        	       break;
			     case R.id.btn_h:
					    intent.putExtra("TYPE", btn_h.getText().toString());
	        	       break;
			    case R.id.btnallcat:
				 intent.putExtra("TYPE", "");
				 break;
         }
       
         startActivity(intent); 
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
					Intent i1 = new Intent(Category_Menu.this,Popular_categories.class);
					startActivity(i1);
					break;
				case ID_SCAT:
					Intent i2 = new Intent(Category_Menu.this,Category_Menu.class);
					startActivity(i2);
					break;
				case ID_SN:
					Intent i3 = new Intent(Category_Menu.this,Searchby_Name.class);
					startActivity(i3);
					break;
				case ID_SC:
					Intent i4 = new Intent(Category_Menu.this,Searchby_City.class);
					startActivity(i4);
					break;
				case ID_AU:
					Intent i5 = new Intent(Category_Menu.this,AboutUs.class);
					startActivity(i5);
					break;
				case ID_CU:
					Intent i6 = new Intent(Category_Menu.this,ContactUs.class);
					startActivity(i6);
					break;
				case ID_FB:
					Intent i7 = new Intent(Category_Menu.this,Feedback.class);
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