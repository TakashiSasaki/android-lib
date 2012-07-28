package com.gmail.takashi316.lib.android.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * FindViewActivity provides utility method to find widgets by its ID with
 * appropriate type cast.
 * 
 * @author TakashiSASAKI
 * 
 */
class FindViewActivity extends FragmentsActivity {

	@SuppressWarnings("javadoc")
	protected TextView textView(int view_id) {
		View view = findViewById(view_id);
		return (TextView) view;
	}// textView

	@SuppressWarnings("javadoc")
	protected Button button(int view_id) {
		View view = findViewById(view_id);
		return (Button) view;
	}// button

}// FindViewActivity
