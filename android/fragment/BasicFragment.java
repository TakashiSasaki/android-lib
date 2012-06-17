package com.gmail.takashi316.lib.android.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BasicFragment extends Fragment {
	private int fragmentLayoutId = -1;
	View view;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}// onAttach

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}// onCreate

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (this.fragmentLayoutId == -1) {
			throw new RuntimeException(
					"BasicFragment#setFragmentLayoutId should be called before");
		}
		this.view = inflater.inflate(this.fragmentLayoutId, container, false);
		assert this.view != null;
		return this.view;
	}// onCreateView

	protected void setFragmentLayoutId(int fragment_layout_id) {
		this.fragmentLayoutId = fragment_layout_id;
	}// setFragmentLayoutId
	
	protected void setButtonOnClickListener(int button_id, OnClickListener on_click_listener){
		assert this.view != null;
		Button button = (Button)this.view.findViewById(button_id);
		button.setOnClickListener(on_click_listener);
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
}// BasicFragment
