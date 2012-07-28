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
import com.gmail.takashi316.lib.android.log.Log;

/**
 * A non-public class FragmentsActivity represents an activity with single
 * fragment. It is intended to hide details of the code for Android
 * compatibility package.
 * 
 * @author Takashi SASAKI
 * 
 */
class FragmentsActivity extends MenuActivity {

	private int activityLayoutId = -1;
	private int fragmentContainerId = -1;
	private Class<? extends Fragment> fragmentClass;

	/**
	 * setActivityLayoutId is intended to be called in onCreate of derived
	 * class.
	 * 
	 * @param activity_layout_id
	 */
	protected void setActivityLayoutId(int activity_layout_id) {
		this.activityLayoutId = activity_layout_id;
	}// setActivityLayoutId

	/**
	 * setFragmentContainer is intended to be called in onCreate of derived
	 * class.
	 * 
	 * @param fragment_container_id
	 */
	protected void setFragmentContainer(int fragment_container_id) {
		this.fragmentContainerId = fragment_container_id;
	}// setFragmentContainer

	/**
	 * setFragmentClass is intended to be called in onCreate of derived class.
	 * 
	 * @param fragment_class
	 */
	protected void setFragmentClass(Class<? extends Fragment> fragment_class) {
		this.fragmentClass = fragment_class;
	}// setFragmentClass

	@Override
	protected void onStart() {
		if (this.activityLayoutId == -1) {
			Log.e(new Exception(
					"setActivityLayoutId shoud be called in onCreate"));
		}// if
		if (this.fragmentContainerId == -1) {
			Log.e(new Exception(
					"setFragmentContainer sould be called in onCreate"));
		}// if
		if (this.fragmentClass == null) {
			Log.e(new Exception("setFragmentClass should be called in onCreate"));
		}// if
		super.onStart();
	}// onStart

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
