package com.gmail.takashi316.lib.android.assets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.AssetManager;

public class AssetDirectory {
	String path;
	Context context;

	public AssetDirectory(Context context_, String path) {
		this.context = context_;
		this.path = path;
	}// a constructor for specific assets path

	public AssetDirectory(Context context_) {
		this.context = context_;
		this.path = "";
	}// a constructor for assets root

	public ArrayList<AssetFile> list() throws IOException {
		return list(null);
	}// list

	public ArrayList<AssetFile> list(Pattern pattern) throws IOException {
		ArrayList<AssetFile> results = new ArrayList<AssetFile>();
		AssetManager am = this.context.getAssets();
		String[] children = am.list(this.path);
		for (String c : children) {
			if (pattern != null) {
				Matcher m = pattern.matcher(c);
				if (!m.find()) {
					continue;
				}
			}
			results.add(new AssetFile(this.context, this.path, c));
		}// for
		return results;
	}// list

} // AssetDirectory

