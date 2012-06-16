package com.gmail.takashi316.lib;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

class FragmentActivity extends MenuActivity {

	private int activityLayoutId = -1;
	private int fragmentContainerId = -1;
	private Class<? extends Fragment> fragmentClass;

	protected void setActivityLayoutId(int activity_layout_id) {
		this.activityLayoutId = activity_layout_id;
	}// setActivityLayoutId

	protected void setFragmentContainer(int fragment_container_id,
			Class<? extends Fragment> fragment_class) {
		this.fragmentContainerId = fragment_container_id;
		this.fragmentClass = fragment_class;
	}// setFragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (this.activityLayoutId == -1) {
			throw new RuntimeException(
					"BasicActivity#onCreate failed without setting BasicActivity#activityLayoutId");
		}
		View view = getLayoutInflater().inflate(this.activityLayoutId, null);
		if (this.fragmentContainerId != -1 && this.fragmentClass != null) {
			FragmentManager fragment_manager = getFragmentManager();
			FragmentTransaction fragment_transaction = fragment_manager
					.beginTransaction();
			try {
				Fragment fragment;
				fragment = this.fragmentClass.newInstance();
				fragment_transaction.add(this.fragmentContainerId, fragment);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}// try
			fragment_transaction.commit();
		}// if
		setContentView(view);
		super.onCreate(savedInstanceState);
	}// onCreate
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
}// FragmentActivity
