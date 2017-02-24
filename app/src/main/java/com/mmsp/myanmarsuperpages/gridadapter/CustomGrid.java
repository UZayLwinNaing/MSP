package com.mmsp.myanmarsuperpages.gridadapter;

import java.util.ArrayList;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mmsp.myanmarsuperpages.R;
import com.mmsp.myanmarsuperpages.R.id;
import com.mmsp.myanmarsuperpages.R.layout;

public class CustomGrid extends BaseAdapter{
	 Context context;
	   private String[]txt;
	   private  int[] image;
	   public CustomGrid(Context con,String[] text,int[] img){
		   context = con;
		   this.txt = text;
		   this.image = img;
	   }
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return txt.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View grid;
			
			if(convertView == null){
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				grid = inflater.inflate(R.layout.grid_imtxt,parent,false);
				
			}
			else{
				grid = (View) convertView;
				
			}
			String topic = txt[10];
			ImageView iv = (ImageView) grid.findViewById(R.id.ivgrid);
			TextView txtname = (TextView) grid.findViewById(R.id.tvgrid);
			Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "myanmar3.ttf");
			txtname.setTypeface(externalFont);
			txtname.setText(txt[position]);
			iv.setImageResource(image[position]);
			return grid;
		}
}
