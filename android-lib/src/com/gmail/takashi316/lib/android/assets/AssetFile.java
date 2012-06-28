package com.gmail.takashi316.lib.android.assets;

import java.io.BufferedInputStream;
import java.io.IOException;
import android.content.Context;
import android.content.res.AssetManager;

public class AssetFile {
	AssetManager assetManager;
	String path;

	public AssetFile(Context context_,
			String path_in_assets_without_heading_slash) {
		this.path = path_in_assets_without_heading_slash;
		this.assetManager = context_.getAssets();
	}// a constructor

	public BufferedInputStream getBufferedInputStream() throws IOException {
		return new BufferedInputStream(this.assetManager.open(this.path));
	}// getBufferedInputStream()
}// AssetFile
