package com.gmail.takashi316.lib.android.test;

import java.io.IOException;

import org.junit.Test;

import com.gmail.takashi316.lib.android.filesystem.AndroidImageFile;
import com.gmail.takashi316.lib.android.stub.HelloAndroidActivity;
import com.gmail.takashi316.lib.filesystem.Directory;

import android.test.ActivityInstrumentationTestCase2;

/**
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
public class AndroidImageFileTestCase extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	Directory currentDirectory;
	Directory readonlyDirectory;
	AndroidImageFile androidImageFile;

	public AndroidImageFileTestCase() {
		super(HelloAndroidActivity.class);
	}// HelloAndroidTestCase

	public void testUiThread() {
		getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				getInstrumentation().waitForIdle(null);
			}
		});// runOnUiThread
			// this.androidImageFile = new
			// AndroidImageFile(this.readonlyDirectory,
			// "lena.bmp");
		assertTrue(true);
	}// testTextViewHello

	@Override
	protected void setUp() throws Exception {
		this.currentDirectory = new Directory();
		this.readonlyDirectory = new Directory(currentDirectory, "readonly");
		assertTrue(this.currentDirectory.exists());
		assertTrue(this.readonlyDirectory.exists());
		assertTrue(this.readonlyDirectory.isDirectory());
		super.setUp();
	}// setUp

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}// tearDown
}// UsersActivityTestCase
