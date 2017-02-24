/**
 * @author Zay Lwin Naing
 * date: 27/4/2015
 * Description : This is a database helper to create database, copy the database from 
 * the assets folder and then move it into the data/package_name/database folder to 
 * access in the future.
 * 
 */
package com.mmsp.myanmarsuperpages.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("SdCardPath")
public class DatabaseHelper extends SQLiteOpenHelper 
{
	// The Android's default system path of your application database.
	private static String DB_PATH = "/data/data/com.mmsp.myanmarsuperpages/databases/";
	private static String DB_NAME = "mmypnew_001.db";
	private static SQLiteDatabase myDataBase;
	private final Context myContext;
	 private static final String DB_COLUMN_1_NAME = "NAME";
	 public static final String MYP_ID = "syskey";
	 public static final String MYP_NAME = "name";
	 public static final String MYP_ADDRESS = "address";
	 public static final String MYP_PHONE = "phone";
	 public static final String MYP_FAX = "fax";
	 public static final String MYP_EMAIL = "email";
	 public static final String MYP_WEBSITE = "websit";
	 public static final String MYP_TITLE = "title";
	 public static final String MYP_DESP = "description";
	 public static final String MYP_MAPLAT = "mapLat";
	 public static final String MYP_MAPLON = "mapLon";
	 public static final String MYP_LOCID = "locId";
	 public static final String MYP_CATID = "catId";
	 public static final String MYP_IMAGEID = "imageId";
	 public static final String MYP_ADSSTATUS = "adsStatus";
	 public static final String MYP_STATUS = "status";
	 public static final String MYP_CREATEUSR = "createUsr";
	 
	 public static final String MYP_CATMM = "catName";
	 public static final String MYP_CATENG = "catNamemm";
	 
	 public static final String MYP_IMGNAME = "imgName";
	 
	private ArrayList<Description> listdesp = new ArrayList<Description>();
	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	public DatabaseHelper(Context context) 
	{
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
	public void createDataBase() throws IOException 
	{
		boolean dbExist = checkDataBase();
		if (dbExist) 
		{
			// do nothing - database already exist
		} 
		else 
		{
			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are going to be able to overwrite that
			// database with our database.
			this.getReadableDatabase();
			try 
			{
				copyDataBase();
			} 
			catch (IOException e) 
			{
				throw new Error("Error copying database");
			}
		}
	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() 
	{
		SQLiteDatabase checkDB = null;
		try 
		{
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);
		} 
		catch (SQLiteException e) 
		{
			// database does't exist yet.
		}
		if (checkDB != null) 
		{
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 * */
	private void copyDataBase() throws IOException 
	{

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) 
		{
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException 
	{
		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);
	}

	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{  }
	 //////Main page/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Description> getsearchbynameandcat_main(String cname,String catid) {
		listdesp.clear();
		Cursor cursor;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		if(catid.equals("-1")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  name LIKE '" + cname + "%' ORDER BY adsStatus DESC",null);
		}else if(cname.equals("")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  catId ='" + catid + "' ORDER BY adsStatus DESC",null);
		}else{
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  name LIKE  '" + cname + "%'  and catId ='" + catid + "' ORDER BY adsStatus DESC",null);
		}
		
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	
	public int getIdAllCategoryName_main(String className){
		String query = "SELECT syskey FROM tbl_category WHERE catName = '" + className + "'";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery(query, null);
		int id=-1;
		if(res!=null&&res.moveToFirst())
		id=res.getInt(res.getColumnIndex("syskey"));
		return id;
	}
   //////Popular Category/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Description> getpopularCatList(String catid,String locid) {
		listdesp.clear();
		Cursor cursor ;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		if(locid.equals("other")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId ='" + catid + "' and locId >=56 and locId <=158 ORDER BY adsStatus DESC ,name ASC",null);
		}else if(locid.equals("npt")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId ='" + catid + "' and locId >=1 and locId <=9 ORDER BY adsStatus DESC ,name ASC ",null);	
		}else if(locid.equals("ygn")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId ='" + catid + "' and locId >=10 and locId <=47 ORDER BY adsStatus DESC ,name ASC ",null);	
		}else if(locid.equals("mdy")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId ='" + catid + "' and locId >=48 and locId <=55 ORDER BY adsStatus DESC ,name ASC ",null);	
		}else{
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId ='" + catid + "' ORDER BY adsStatus DESC ,name ASC ",null);	
			//cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE catId LIKE '" + catid + "%' ORDER BY name",null);	
		}
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	public String getNamecategory_popular(String catid){
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		Cursor res = myDataBase.rawQuery( "SELECT catName FROM tbl_category WHERE syskey = '" + catid + "'", null);
		String str_name = null;
		if(res!=null&&res.moveToFirst())
			str_name=res.getString(res.getColumnIndex("catName"));
		return str_name;
	}
	public String getNamelocation_popular(String catid){
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		Cursor res = myDataBase.rawQuery( "SELECT locState,locName FROM tbl_location WHERE syskey = '" + catid + "'", null);
		String str_name = null;
		if(res!=null&&res.moveToFirst())
			//str_name=res.getString(res.getColumnIndex("locName"))+"/"+res.getString(res.getColumnIndex("locState"));
			str_name=res.getString(res.getColumnIndex("locName"));
		return str_name;
	}
	
	public String getAreacode(String locid,String filterid){
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		String str_name = null;
		if(filterid.equals("phone")){
			Cursor res = myDataBase.rawQuery( "SELECT locArea FROM tbl_location where syskey = '" + locid + "'", null);
			if(res!=null&&res.moveToFirst()){
				str_name=res.getString(res.getColumnIndex("locArea"));
			}
		}else{
			Cursor res = myDataBase.rawQuery( "SELECT locName,locState FROM tbl_location where syskey = '" + locid + "'", null);
			if(res!=null&&res.moveToFirst()){
				str_name=res.getString(res.getColumnIndex("locName"))+", "+res.getString(res.getColumnIndex("locState"));
			}
		}
		return str_name;
	}
	
	public ArrayList<Description> getdetailList(String name,String catid,String locid) {
		listdesp.clear();
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		Cursor cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE name ='" + name + "' and  catId='" + catid + "' and locId ='" + locid + "'",null);
		//Cursor cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE name ='Red Mountain Estate' and  catId='58' and locId ='1'",null);
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();
					item._strsyskey = cursor.getString(cursor.getColumnIndex(MYP_ID));		
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._address = cursor.getString(cursor.getColumnIndex(MYP_ADDRESS));						
					item._phone = cursor.getString(cursor.getColumnIndex(MYP_PHONE));
					item._fax = cursor.getString(cursor.getColumnIndex(MYP_FAX));					
					item._email = cursor.getString(cursor.getColumnIndex(MYP_EMAIL));
					item._websit = cursor.getString(cursor.getColumnIndex(MYP_WEBSITE));
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._description = cursor.getString(cursor.getColumnIndex(MYP_DESP));
					item._mapLat = cursor.getString(cursor.getColumnIndex(MYP_MAPLAT));
					item._mapLon = cursor.getString(cursor.getColumnIndex(MYP_MAPLON));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._imageId = cursor.getString(cursor.getColumnIndex(MYP_IMAGEID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					item._status = cursor.getString(cursor.getColumnIndex(MYP_STATUS));
					item._createUsr = cursor.getString(cursor.getColumnIndex(MYP_CREATEUSR));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	public ArrayList<Description> getimageid_detail(String busid) {
		listdesp.clear();
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		
		//Cursor cursor = myDataBase.rawQuery( "SELECT *  FROM tbl_image WHERE businessId = '21'", null);
		Cursor cursor = myDataBase.rawQuery( "SELECT imgName FROM tbl_image WHERE businessId = '" + busid + "'", null);
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();		
					item._imgname = cursor.getString(cursor.getColumnIndex(MYP_IMGNAME));					
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	 //////Search Category/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Description> getchar_category(String catid,String strcahr) {
		listdesp.clear();
		Cursor cursor ;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		//cur=myDataBase.rawQuery("SELECT * FROM "+ tbl + " WHERE CDESP LIKE '" + cat + "%' GROUP BY CDESP",null);
		if(strcahr.equals("ENG")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_category WHERE  catName LIKE '" + catid + "%' ORDER BY catName",null);
		}else{
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_category WHERE  catNamemm LIKE '" + catid + "%' ORDER BY catNamemm",null);
		}
		
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(MYP_ID)));		
					item._cdespeng = cursor.getString(cursor.getColumnIndex(MYP_CATMM));
					item._cdespmm = cursor.getString(cursor.getColumnIndex(MYP_CATENG));						
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	 //////Search By Name/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Description> getbyname_name(String type,String name) {
		listdesp.clear();
		Cursor cursor;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		//cur=myDataBase.rawQuery("SELECT * FROM "+ tbl + " WHERE CDESP LIKE '" + cat + "%' GROUP BY CDESP",null);
		if(type.equals("include")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  name LIKE  '%" + name + "%' ORDER BY adsStatus DESC",null);
		}else{
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  name LIKE '" + name + "%' ORDER BY adsStatus DESC",null);
		}
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	 //////Spinner to Data/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<String> getalltownship_city(String cityname){  
        List<String> list = new ArrayList<String>();  
        Cursor cursor;
        String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		if(cityname.equals("other")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_location WHERE syskey >=56 and syskey <=158 ORDER BY locName",null);
		}else if(cityname.equals("npt")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_location WHERE syskey >=1 and syskey <=9 ORDER BY locName",null);	
		}else if(cityname.equals("ygn")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_location WHERE syskey >=10 and syskey <=47 ORDER BY locName",null);	
		}else if(cityname.equals("mdy")){
			cursor = myDataBase.rawQuery("SELECT * FROM tbl_location WHERE  syskey >=48 and syskey <=55 ORDER BY locName",null);	
		}else{
			cursor = myDataBase.rawQuery("SELECT  * from tbl_location ORDER BY locName", null);
		}
        if (cursor.moveToFirst()) {  
            do { 
                list.add(cursor.getString(3));//adding 2nd column data  
            } while (cursor.moveToNext());  
        }  
        cursor.close();  
        myDataBase.close();  
        return list;  
    }  
    public List<String> getallcategory_city(String strchar){  
        List<String> list = new ArrayList<String>(); 
        list.add("Choose category");
        Cursor cursor;
        String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		if(strchar.equals("ENG")){
			cursor = myDataBase.rawQuery("SELECT  catName from tbl_category ORDER BY catName", null);
		}else{
			cursor = myDataBase.rawQuery("SELECT catNamemm from tbl_category ORDER BY catNamemm", null);
		}
        if (cursor.moveToFirst()) {  
            do { 
                list.add(cursor.getString(0));//adding 2nd column data  
            } while (cursor.moveToNext());  
        }  
        cursor.close();  
        myDataBase.close();  
        return list;  
    } 
	public ArrayList<Description> getbyname_city(String cityid,String catid) {
		listdesp.clear();
		Cursor cursor;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  locId ='" + cityid + "' and catId ='" + catid + "' ORDER BY adsStatus DESC",null);
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	public ArrayList<Description> getsearchbyname_city(String cname,String cityid,String catid) {
		listdesp.clear();
		Cursor cursor;
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		cursor = myDataBase.rawQuery("SELECT * FROM tbl_business WHERE  name LIKE '" + cname + "%'  and locId ='" + cityid + "' and catId ='" + catid + "' ORDER BY adsStatus DESC",null);
		if (cursor.getCount() != 0) {
			if (cursor.moveToFirst()) {
				do {
					Description item = new Description();	
					item._name = cursor.getString(cursor.getColumnIndex(MYP_NAME));					
					item._title = cursor.getString(cursor.getColumnIndex(MYP_TITLE));
					item._locId = cursor.getString(cursor.getColumnIndex(MYP_LOCID));						
					item._catId = cursor.getString(cursor.getColumnIndex(MYP_CATID));
					item._adsStatus = cursor.getString(cursor.getColumnIndex(MYP_ADSSTATUS));
					listdesp.add(item);
				} while (cursor.moveToNext());
			}
		}
		cursor.close();
		myDataBase.close();
		return listdesp;
	}
	public String getNamecategory_city(String catid){
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		Cursor res = myDataBase.rawQuery( "SELECT syskey FROM tbl_category WHERE catName = '" + catid + "'", null);
		String str_name = null;
		if(res!=null&&res.moveToFirst())
			str_name=res.getString(res.getColumnIndex("syskey"));
		return str_name;
	}
	public String getNamelocation_city(String catid){
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY); 
		Cursor res = myDataBase.rawQuery( "SELECT syskey FROM tbl_location WHERE locName = '" + catid + "'", null);
		String str_name = null;
		if(res!=null&&res.moveToFirst())
			str_name=res.getString(res.getColumnIndex("syskey"));
		return str_name;
	}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}