package com.gmail.takashi316.lib.android.test;

import java.io.IOException;
import java.util.ArrayList;

import com.gmail.takashi316.lib.android.assets.AssetDirectory;
import com.gmail.takashi316.lib.android.assets.AssetFile;
import com.gmail.takashi316.lib.android.filesystem.AndroidDirectory;
import com.gmail.takashi316.lib.android.stub.HelloAndroidActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
public class AssetDirectoryTestCase extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {
	private AssetDirectory assetDirectoryRoot;
	private AssetDirectory assetDirectoryDir1;
	private AndroidDirectory filesDir;

	// File fileLena;

	@SuppressWarnings("javadoc")
	public AssetDirectoryTestCase() {
		super(HelloAndroidActivity.class);
	}// HelloAndroidTestCase

	/**
	 * testing copy function and AndroidImageFile class.
	 * 
	 * @throws IOException
	 */
	public void testRoot() throws IOException {
		ArrayList<AssetFile> alaf = assetDirectoryRoot.list();
		assertEquals(4, alaf.size());
		assertEquals("dir1", alaf.get(0).getPath());
		assertEquals("images", alaf.get(1).getPath());
		assertEquals("sounds", alaf.get(2).getPath());
		assertEquals("webkit", alaf.get(3).getPath());
	}// testRoot

	public void testDir1() throws IOException {
		ArrayList<AssetFile> alaf = new ArrayList<AssetFile>();
		alaf = this.assetDirectoryDir1.list();
		assertEquals(1, alaf.size());
		assertEquals("dir1/lena.bmp", alaf.get(0).getPath());
	}// testDir1

	@Override
	protected void setUp() throws Exception {
		this.assetDirectoryRoot = new AssetDirectory(getActivity());
		this.assetDirectoryDir1 = new AssetDirectory(getActivity(), "dir1");
		super.setUp();
	}// setUp

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}// tearDown
}// UsersActivityTestCase

