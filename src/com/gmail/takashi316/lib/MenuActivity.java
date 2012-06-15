package com.gmail.takashi316.lib;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

class MenuActivity extends Activity {

	private Map<Integer, Class<? extends Activity>> activityMap;
	private int exitItemId = -1;
	private int menuResourceId = -1;

	public MenuActivity() {
		super();
		this.activityMap = new HashMap<Integer, Class<? extends Activity>>(5);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}// onCreate

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
		if (item.getItemId() == this.exitItemId) {
			Intent intent = new Intent();
			intent.putExtra("text", "終了");
			setResult(RESULT_OK);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}// onOptionsItemSelected

	protected void addActivityClass(Integer item_id,
			Class<? extends Activity> activity_) {
		this.activityMap.put(item_id, activity_);
	}// addActivityClass

	protected void setExitItemId(int exit_item_id) {
		this.exitItemId = exit_item_id;
	}// setExitItemId

	protected void setMenuResourceId(int menu_resource_id) {
		this.menuResourceId = menu_resource_id;
	} // setMenuResourceId
}// MenuActivity
