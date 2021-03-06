package com.gmail.takashi316.lib.android.activity;

import java.util.HashMap;
import java.util.Map;

import com.gmail.takashi316.lib.android.log.Log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

class MenuActivity extends FragmentActivity {

	private Map<Integer, Class<? extends Activity>> activityMap;
	// private int exitItemId = -1;
	private int menuResourceId = -1;

	public MenuActivity() {
		super();
		this.activityMap = new HashMap<Integer, Class<? extends Activity>>();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}// onCreate

	@Override
	protected void onStart() {
		if (this.menuResourceId == -1) {
			Log.e(new Exception(
					"setMenuResourceId should be called in onCreate."));
		}// if
		if (this.activityMap.size() == 0) {
			Log.e(new Exception("No activity is mapped to any menu item."));
		}// if
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		if (this.menuResourceId == -1)
			throw new RuntimeException(
					"MenuActivity#setMenuResourceId should be called before");
		MenuInflater menu_inflater = getMenuInflater();
		menu_inflater.inflate(this.menuResourceId, menu);
		return true;
	}// onCreateOptionsMenu

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		@SuppressWarnings("boxing")
		Class<? extends Activity> activity_class = this.activityMap.get(item
				.getItemId());
		if (activity_class != null) {
			Intent intent = new Intent(this, activity_class);
			startActivityForResult(intent, 0);
			return true;
		}
		Intent intent = new Intent();
		intent.putExtra("text", "Exit");
		setResult(RESULT_OK);
		finish();
		// return true;
		return super.onOptionsItemSelected(item);
	}// onOptionsItemSelected

	protected void addActivityClass(Integer item_id,
			Class<? extends Activity> activity_) {
		this.activityMap.put(item_id, activity_);
	}// addActivityClass

	// protected void setExitItemId(int exit_item_id) {
	// this.exitItemId = exit_item_id;
	// }// setExitItemId

	protected void setMenuResourceId(int menu_resource_id) {
		this.menuResourceId = menu_resource_id;
	} // setMenuResourceId

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	public FragmentManager getSupportFragmentManager() {
		// TODO Auto-generated method stub
		return super.getSupportFragmentManager();
	}
}// MenuActivity
