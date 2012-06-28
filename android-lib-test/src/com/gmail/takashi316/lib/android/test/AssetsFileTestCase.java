package com.gmail.takashi316.lib.android.test;

import java.io.IOException;

import com.gmail.takashi316.lib.android.assets.AssetFile;
import com.gmail.takashi316.lib.android.filesystem.AndroidDirectory;
import com.gmail.takashi316.lib.android.filesystem.AndroidImageFile;
import com.gmail.takashi316.lib.android.stub.HelloAndroidActivity;
import com.gmail.takashi316.lib.filesystem.File;

import android.test.ActivityInstrumentationTestCase2;

/**
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
public class AssetsFileTestCase extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {
	AssetFile assetFileLena;
	AndroidDirectory filesDir;
	File fileLena;

	@SuppressWarnings("javadoc")
	public AssetsFileTestCase() {
		super(HelloAndroidActivity.class);
	}// HelloAndroidTestCase

	/**
	 * testing copy function and AndroidImageFile class.
	 * 
	 * @throws IOException
	 */
	public void testCopy() throws IOException {
		assertFalse(this.fileLena.exists());
		this.fileLena.copyFrom(this.assetFileLena.getBufferedInputStream());
		assertTrue(this.fileLena.exists());
		AndroidImageFile aif = new AndroidImageFile(
				this.fileLena.getAbsolutePath());
		assertEquals(512, aif.getHeight());
		assertEquals(512, aif.getWidth());
	}// testTextViewHello

	@Override
	protected void setUp() throws Exception {
		this.filesDir = AndroidDirectory.getFilesDir(getActivity());
		if (!this.filesDir.exists()) {
			this.filesDir.mkdir();
		}
		assert (this.filesDir.exists());
		this.fileLena = new File(this.filesDir, "lena2.bmp");
		if (this.fileLena.exists()) {
			this.fileLena.delete();
		}
		assertFalse(this.fileLena.exists());
		this.assetFileLena = new AssetFile(getActivity(), "dir1/lena.bmp");
		super.setUp();
	}// setUp

	@Override
	protected void tearDown() throws Exception {
		if (this.fileLena.exists()) {
			this.fileLena.delete();
		}
		assertFalse(this.fileLena.exists());
		super.tearDown();
	}// tearDown
}// UsersActivityTestCase

