package com.gmail.takashi316.lib.android.assets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * ZipFilesInAssets represents ZIP files in assets folder. Once zip files are
 * enumerated, it is represented as instances of ZipUrl.
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
@SuppressWarnings("serial")
public class AssetDirectory extends ArrayList<AssetFile> {
	// private static final String zipAssetDirectory = "zip";
	// private AssetManager assetManager;
	static Context context;

	public static Context getContext() {
		if (context == null)
			throw new NullPointerException("context is not set");
		return context;
	}

	public static AssetManager getAssetManager() {
		if (assetManager == null)
			throw new NullPointerException("assetManager is not set");
		return assetManager;
	}

	public String getPathInAssets() {
		assert (pathInAssets != null);
		return this.pathInAssets;
	}

	static AssetManager assetManager;
	String pathInAssets;
	Pattern pattern;

	public void setContext(Context context) {
		if (context == null) {
			assert (AssetFile.context != null);
			return;
		}
		if (AssetDirectory.context == null) {
			AssetDirectory.context = context;
			return;
		}
		assert (AssetDirectory.context.equals(context));
	}// setContext

	void prepareAssetManager() {
		assetManager = context.getResources().getAssets();
	}

	public AssetDirectory(String path_in_asset, String regex)
			throws IOException {
		setContext(context);
		prepareAssetManager();
		// this.clear();
		pattern = Pattern.compile(regex /* "^[^.][a-zA-Z_0-9.-]+[^.].zip$" */);
		String[] asset_paths;

		asset_paths = assetManager.list("");

		for (String asset_path : asset_paths) {
			Matcher matcher = pattern.matcher(asset_path);
			if (!matcher.find())
				continue;
			// URI uri;
			// try {
			// uri = new URI("file", null, "assets", -1, "/" + asset_path,
			// null, null);
			// } catch (URISyntaxException e) {
			// e.printStackTrace();
			// continue;
			// }// try
			this.add(new AssetFile(pathInAssets + "/" + asset_path));
		}// for
	}// constructor

}// Assets
