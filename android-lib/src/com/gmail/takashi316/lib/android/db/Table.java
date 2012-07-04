package com.gmail.takashi316.lib.android.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.gmail.takashi316.lib.string.StringArray;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Table {
	String tableName;
	SQLiteOpenHelper sqliteOpenHelper;

	public Table(String table_name, SQLiteOpenHelper sqlite_open_helper,
			HashMap<String, String> columns_definition, String[] primary_key) {
		this.tableName = table_name;
		this.sqliteOpenHelper = sqlite_open_helper;
		if (!exists()) {
			create(columns_definition, primary_key);
		}
	}// a constructor

	public Table(String table_name, SQLiteOpenHelper sqlite_open_helper) {
		this.tableName = table_name;
		this.sqliteOpenHelper = sqlite_open_helper;
	}// a constructor

	private boolean exists() {
		SQLiteDatabase rdb = this.sqliteOpenHelper.getReadableDatabase();
		Cursor c = rdb
				.rawQuery(
						"SELECT count(*) FROM sqlite_master WHERE type='table' AND name=?",
						new String[] { this.tableName });
		c.moveToFirst();
		boolean result = (c.getInt(0) > 0) ? true : false;
		c.close();
		return result;
	}// exists

	private void create(HashMap<String, String> columns_definition,
			String[] primary_key) {
		if (!columns_definition.containsKey("_id")) {
			columns_definition.put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
		}

		StringBuilder sb = new StringBuilder("CREATE TABLE " + this.tableName
				+ " ("
				+ (new StringArray(columns_definition, " ")).concat(", "));
		if (primary_key != null) {
			sb.append(", PRIMARY KEY(")
					.append(new StringArray(primary_key).concat(", "))
					.append(")");
		}
		sb.append(");");

		SQLiteDatabase wdb = this.sqliteOpenHelper.getWritableDatabase();
		wdb.execSQL(sb.toString());
	}// create

	public void drop() {
		if (this.sqliteOpenHelper != null && exists()) {
			SQLiteDatabase wdb = this.sqliteOpenHelper.getWritableDatabase();
			wdb.execSQL("DROP TABLE " + this.tableName);
		}
		this.sqliteOpenHelper = null;
	}// drop

	public void close() {
		this.sqliteOpenHelper = null;
	}// close

	public void deleteAll() {
		SQLiteDatabase wdb = this.sqliteOpenHelper.getWritableDatabase();
		wdb.delete(this.tableName, null, null);
	}// deleteAll

	public String[] getPrimaryKeyColumns() {
		SQLiteDatabase rdb = this.sqliteOpenHelper.getReadableDatabase();
		Cursor c = rdb.rawQuery("PRAGMA table_info(" + this.tableName + ");",
				null);
		ArrayList<String> primary_key_columns = new ArrayList<String>();
		while (!c.isAfterLast()) {
			int is_pk = c.getInt(c.getColumnIndex("pk"));
			if (is_pk == 1) {
				primary_key_columns.add(c.getString(c.getColumnIndex("name")));
			}// if
		}
		c.close();
		return (String[]) primary_key_columns.toArray();
	}// getPrimaryKeyColumns

	public void insert(Map<String, String> new_record) {
		SQLiteDatabase wdb = this.sqliteOpenHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		for (String key : new_record.keySet()) {
			cv.put(key, new_record.get(key));
		}
		wdb.insert(this.tableName, null, cv);
	}// insert

	public void replace(Map<String, String> new_record) {

	}
}// Table
