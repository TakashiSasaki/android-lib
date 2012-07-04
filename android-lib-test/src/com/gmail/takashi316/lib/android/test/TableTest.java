package com.gmail.takashi316.lib.android.test;

import java.util.HashMap;
import java.util.Map;

import com.gmail.takashi316.lib.android.db.Table;
import com.gmail.takashi316.lib.android.stub.HelloAndroidActivity;
import com.gmail.takashi316.lib.android.stub.R;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.TextView;

/**
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
public class TableTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	public TableTest() {
		super(HelloAndroidActivity.class);
	}// HelloAndroidTestCase

	public void testTextViewHello() {
	}// testTextViewHello

	Table table;
	TextView textView;

	class TestSqliteOpenHelper extends SQLiteOpenHelper {

		/**
		 * @param context
		 * @param name
		 * @param factory
		 * @param version
		 */
		public TestSqliteOpenHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database
		 * .sqlite.SQLiteDatabase)
		 */
		@Override
		public void onCreate(SQLiteDatabase db) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database
		 * .sqlite.SQLiteDatabase, int, int)
		 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}// TestSqliteOpenHelper

	@Override
	protected void setUp() throws Exception {
		SQLiteOpenHelper sqlite_open_helper = new TestSqliteOpenHelper(
				getActivity(), "test.db", null, 1);
		HashMap<String, String> columns = new HashMap<String, String>();
		columns.put("first", "TEXT");
		columns.put("second", "TEXT");
		this.table = new Table("test_table", sqlite_open_helper, columns, null);
		super.setUp();
	}// setUp

	@Override
	protected void tearDown() throws Exception {
		this.table.drop();
		super.tearDown();
	}// tearDown
}// UsersActivityTestCase

