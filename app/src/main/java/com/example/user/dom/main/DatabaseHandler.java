package com.example.user.dom.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 4;

	// Database Name
	private static final String DATABASE_NAME = "contactsManager";

	// Contacts table name
	private static final String TABLE_CONTACTS = "contacts";
	private static final String TABLE_CLEANS = "cleans";
	private static final String TABLE_COOKS = "cooks";
	private static final String TABLE_WASHS = "washs";

	// Contacts Table Columns names
	//-------------Contacts--------------------
	private static final String CONTACT_ID = "contact_id";
	private static final String NAME = "contact_name";
	private static final String ROLE = "contact_role";
	private static final String PHONE = "contact_phone";
	private static final String COMMENT = "contact_comment";
	//-------------Clean--------------------
	private static final String CLEAN_ID = "clean_id";
	private static final String LIST = "clean_list";
	private static final String DATA = "clean_data";
	private static final String TIME = "clean_time";
	private static final String CLEAN_ROLE = "clean_role";
	private static final String WORK = "clean_work";
	private static final String CLEAN_COMMENT = "clean_comment";
        //-------------Cook--------------------
        private static final String COOK_ID = "cook_id";
        private static final String COOK_LIST = "cook_list";
        private static final String COOK_DATE = "cook_date";
        private static final String COOK_TIME = "cook_time";
        private static final String BREAKFAST = "breakfast";
        private static final String COOK_ROLE = "cook_role";
        private static final String VEGETABLE = "vegetable";
        private static final String COOK_COMMENT = "cook_comment";
        //-------------Wash--------------------
        private static final String WASH_ID = "wash_id";
        private static final String WASH_LIST = "wash_list";
        private static final String WASH_DATE = "wash_date";
        private static final String WASH_TIME = "wash_time";
        private static final String WASH_ROLE = "wash_role";
        private static final String WASH_COLOR = "wash_color";
        private static final String WASH_COMMENT = "wash_comment";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ CONTACT_ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
				+ ROLE + " TEXT," + PHONE + " TEXT,"+ COMMENT + " TEXT" +  ")";
		db.execSQL(CREATE_CONTACTS_TABLE);

	String CREATE_CLEAN_TABLE = "CREATE TABLE " + TABLE_CLEANS + "("
				+ CLEAN_ID + " INTEGER PRIMARY KEY," + LIST + " TEXT,"
				+ DATA + " TEXT," + TIME + " TEXT,"+ CLEAN_ROLE + " TEXT,"
				+ WORK + " TEXT," + CLEAN_COMMENT + " TEXT"  + ")";
		db.execSQL(CREATE_CLEAN_TABLE);

		String CREATE_COOK_TABLE = "CREATE TABLE " + TABLE_COOKS + "("
				+ COOK_ID + " INTEGER PRIMARY KEY," + COOK_LIST + " TEXT,"
				+ COOK_DATE + " TEXT," + COOK_TIME + " TEXT,"+ BREAKFAST + " TEXT,"
				+ COOK_ROLE + " TEXT," + VEGETABLE + " TEXT,"  + COOK_COMMENT + " TEXT" + ")";
		db.execSQL(CREATE_COOK_TABLE);

		String CREATE_WASH_TABLE = "CREATE TABLE " + TABLE_WASHS + "("
				+ WASH_ID + " INTEGER PRIMARY KEY," + WASH_LIST + " TEXT,"
				+ WASH_DATE + " TEXT," + WASH_TIME + " TEXT,"
				+ WASH_ROLE + " TEXT," + WASH_COLOR + " TEXT,"  + WASH_COMMENT + " TEXT" + ")";
		db.execSQL(CREATE_WASH_TABLE);

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLEANS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COOKS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WASHS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	void addContact(ContactData contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(NAME, contact.getName());
		values.put(ROLE, contact.getRole());
		values.put(PHONE, contact.getPhone());
		values.put(COMMENT, contact.getComment());
		db.insert(TABLE_CONTACTS, null, values);
		db.close();
	}

	void addClean(CleanData clean) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(LIST, clean.getCleanList());
		values.put(DATA, clean.getCleanData());
		values.put(TIME, clean.getCleanTime());
		values.put(CLEAN_ROLE, clean.getCleanRole());
		values.put(WORK, clean.getCleanWork());
		values.put(CLEAN_COMMENT, clean.getCleanComment());
		db.insert(TABLE_CLEANS, null, values);
		db.close();
	}

	void addCookL(CookData cookL) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COOK_LIST, cookL.getCookList());
		values.put(COOK_DATE, cookL.getCookDate());
		values.put(COOK_TIME, cookL.getCookTime());
		values.put(BREAKFAST, cookL.getCookBreakfast());
		values.put(COOK_ROLE, cookL.getCookRole());
		values.put(VEGETABLE, cookL.getCookVega());
		values.put(COOK_COMMENT, cookL.getCookComment());
		db.insert(TABLE_COOKS, null, values);
		db.close();
}

	void addWash(WashData wash) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(WASH_LIST, wash.getWashList());
		values.put(WASH_DATE, wash.getWashDate());
		values.put(WASH_TIME, wash.getWashTime());
		values.put(WASH_ROLE, wash.getWashRole());
		values.put(WASH_COLOR, wash.getWashColor());
		values.put(WASH_COMMENT, wash.getWashComment());
		db.insert(TABLE_WASHS, null, values);
		db.close();

	}



	
	// Getting All Contacts
	public List<ContactData> getAllContacts() {
		List<ContactData> contactList = new ArrayList<ContactData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ContactData contact = new ContactData();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setRole(cursor.getString(2));
				contact.setPhone(cursor.getString(3));
				contact.setComment(cursor.getString(4));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	public List<CleanData> getAllCleans() {
		List<CleanData> cleanList = new ArrayList<CleanData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_CLEANS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				CleanData clean = new CleanData();
				clean.setCleanID(Integer.parseInt(cursor.getString(0)));
				clean.setCleanList(cursor.getString(1));
				clean.setCleanData(cursor.getString(2));
				clean.setCleanTime(cursor.getString(3));
				clean.setCleanRole(cursor.getString(4));
				clean.setCleanWork(cursor.getString(5));
				clean.setCleanComment(cursor.getString(6));
				// Adding contact to list
				cleanList.add(clean);
			} while (cursor.moveToNext());
		}

		// return contact list
		return cleanList;
	}

	public List<CookData> getAllCook() {
		List<CookData> cookBaseList = new ArrayList<CookData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_COOKS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				CookData cook = new CookData();
				cook.setCookID(Integer.parseInt(cursor.getString(0)));
				cook.setCookList(cursor.getString(1));
				cook.setCookDate(cursor.getString(2));
				cook.setCookTime(cursor.getString(3));
				cook.setCookBreakfast(cursor.getString(4));
				cook.setCookRole(cursor.getString(5));
				cook.setCookVega(cursor.getString(6));
				cook.setCookComment(cursor.getString(7));
				cookBaseList.add(cook);
			} while (cursor.moveToNext());
		}

		// return contact list
		return cookBaseList;
	}

	public List<WashData> getAllWash() {
		List<WashData> washDatebases = new ArrayList<WashData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_WASHS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				WashData wash = new WashData();
				wash.setWashID(Integer.parseInt(cursor.getString(0)));
				wash.setWashList(cursor.getString(1));
				wash.setWashDate(cursor.getString(2));
				wash.setWashTime(cursor.getString(3));
				wash.setWashRole(cursor.getString(4));
				wash.setWashColor(cursor.getString(5));
				wash.setWashComment(cursor.getString(6));
				washDatebases.add(wash);
			} while (cursor.moveToNext());
		}

		// return contact list
		return washDatebases;
	}


	// Updating single contact
//	public int updateContacts(Contacts contacts) {
//		SQLiteDatabase db = this.getWritableDatabase();
//
//		ContentValues values = new ContentValues();
//		values.put(KEY_NAME, contact.getName());
//		values.put(KEY_PH_NO, contact.getPhoneNumber());
//
//		// updating row
//		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//				new String[] { String.valueOf(contact.getID()) });
//	}

	// Deleting single contact
	public void deleteContact(ContactData contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, CONTACT_ID + " = ?",
				new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	public void deleteContact(CleanData contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CLEANS, CLEAN_ID + " = ?",
				new String[] { String.valueOf(contact.getCleanID()) });
		db.close();
	}

	public void deleteContact(CookData contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_COOKS, COOK_ID + " = ?",
				new String[] { String.valueOf(contact.getCookID()) });
		db.close();
	}




	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}



}
