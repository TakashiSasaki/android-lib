package com.gmail.takashi316.lib.android.activity;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

class FragmentsActivity extends MenuActivity {

	private int activityLayoutId = -1;
	private int fragmentContainerId = -1;
	private Class<? extends Fragment> fragmentClass;

	protected void setActivityLayoutId(int activity_layout_id) {
		this.activityLayoutId = activity_layout_id;
	}// setActivityLayoutId

	protected void setFragmentContainer(int fragment_container_id) {
		this.fragmentContainerId = fragment_container_id;
	}// setFragmentContainer

	protected void setFragmentClass(Class<? extends Fragment> fragment_class) {
		this.fragmentClass = fragment_class;
	}// setFragmentClass

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		View view;
		if (this.activityLayoutId == -1) {
			LinearLayout linear_layout = new LinearLayout(this);
			linear_layout.setOrientation(LinearLayout.VERTICAL);
			linear_layout.setId(this.hashCode());
			this.fragmentContainerId = linear_layout.getId();
			view = linear_layout;
		} else {
			view = getLayoutInflater().inflate(this.activityLayoutId, null);
		}// if
		if (this.fragmentContainerId != -1 && this.fragmentClass != null) {
			// FragmentManager fragment_manager = getFragmentManager();
			FragmentManager fragment_manager = this.getSupportFragmentManager();
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
