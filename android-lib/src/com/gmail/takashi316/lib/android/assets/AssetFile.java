package com.gmail.takashi316.lib.android.assets;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class AssetFile {
	String pathInAsset;
	static AssetManager assetManager;
	static Context context;

	AssetFile(String path_in_asset) {
		pathInAsset = path_in_asset;
	}// constructor

	void setContext(Context context) {
		if (AssetFile.context == null) {
			AssetFile.context = context;
			return;
		}
		assert (AssetFile.context.equals(context));
	}// setContext

	public static Context getContext() {
		if (context == null)
			throw new NullPointerException("context is not set");
		return context;
	}// getContext

	public String getPathInAsset() {
		assert (pathInAsset != null);
		return this.pathInAsset;
	}// getPathInAsset

	public static AssetManager getAssetManager() {
		if (assetManager == null)
			throw new NullPointerException("assetManager is not set.");
		return assetManager;
	}// getAssetManager

	void preareAssetManager() {
		if (assetManager != null)
			return;
		assetManager = context.getResources().getAssets();
	}// prepareAssetManager

	BufferedInputStream getBufferedInputStream() throws IOException {
		InputStream input_stream = AssetFile.assetManager.open(pathInAsset);
		return new BufferedInputStream(input_stream);
	}// getBufferedInputStream
}// AssetFile
