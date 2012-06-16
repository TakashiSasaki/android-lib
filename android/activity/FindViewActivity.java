package com.gmail.takashi316.lib.android.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class FindViewActivity extends FragmentActivity {

	public TextView textView(int view_id) {
		View view = findViewById(view_id);
		return (TextView) view;
	}// textView

	public Button button(int view_id) {
		View view = findViewById(view_id);
		return (Button) view;
	}// button
	
}// FindViewActivity
