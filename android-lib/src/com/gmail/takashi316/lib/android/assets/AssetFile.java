package com.gmail.takashi316.lib.android.assets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import android.content.Context;
import android.content.res.AssetManager;

public class AssetFile {
	AssetManager assetManager;
	String path;
	Context context;

	public AssetFile(Context context_,
			String path_in_assets_without_heading_slash) {
		this.context = context_;
		this.path = path_in_assets_without_heading_slash;
		// this.assetManager = context_.getAssets();
	}// a constructor

	public AssetFile(Context context_, String parent_, String child_) {
		File f = new File(parent_, child_);
		this.path = f.getPath();
	}// a constructor

	public BufferedInputStream getBufferedInputStream() throws IOException {
		AssetManager am = this.context.getAssets();
		return new BufferedInputStream(this.assetManager.open(this.path));
	}// getBufferedInputStream()

	public String getPath() {
		return path;
	}// getPath
}// AssetFile
