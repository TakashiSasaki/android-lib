package com.gmail.takashi316.lib.android.filesystem;

import java.io.File;
import android.content.Context;
import android.os.Environment;

import com.gmail.takashi316.lib.filesystem.Directory;

public class AndroidDirectory extends Directory {

	private AndroidDirectory(File file) {
		super(file);
	}// the constructor

	/**
	 * @param context_
	 * @return application specific directory for files created with
	 *         openFileOutput. These files are removed when the application is
	 *         uninstalled.
	 */
	static public AndroidDirectory getFilesDir(Context context_) {
		return new AndroidDirectory(context_.getFilesDir());
	}// getFilesDir

	static public AndroidDirectory getExternalStorageDirectory() {
		return new AndroidDirectory(Environment.getExternalStorageDirectory());
	}// getExternalStorageDirectory

	static public AndroidDirectory getExternalFilesDir(Context context_) {
		return new AndroidDirectory(context_.getExternalFilesDir(null));
	}// getExternalFilesDir

	static public AndroidDirectory getExternalAlarmsDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_ALARMS));
	}

	static public AndroidDirectory getExternalDcimDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_DCIM));
	}

	static public AndroidDirectory getExternalDownloadsDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
	}

	static public AndroidDirectory getExternalMoviesDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_MOVIES));
	}

	static public AndroidDirectory getExternalMusicDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_MUSIC));
	}

	static public AndroidDirectory getExternalNotificationsDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
	}

	static public AndroidDirectory getExternalPicturesDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
	}

	static public AndroidDirectory getExternalPodcastsDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
	}

	static public AndroidDirectory getExternalRingTonesDir(Context context_) {
		return new AndroidDirectory(
				context_.getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
	}

	static public AndroidDirectory getExternalPublicAlarmsDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
	}

	static public AndroidDirectory getExternalPublicDcimDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
	}

	static public AndroidDirectory getExternalPublicDownloadsDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
	}

	static public AndroidDirectory getExternalPublicMoviesDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
	}

	static public AndroidDirectory getExternalPublicMusicDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
	}

	static public AndroidDirectory getExternalPublicNotificationsDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
	}

	static public AndroidDirectory getExternalPublicPicturesDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
	}

	static public AndroidDirectory getExternalPublicPodcastsDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
	}

	static public AndroidDirectory getExternalPublicRingTonesDir() {
		return new AndroidDirectory(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
	}
}// AndroidDirectory
