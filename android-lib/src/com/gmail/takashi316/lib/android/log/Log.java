package com.gmail.takashi316.lib.android.log;

public class Log {
	public final static String tag = "android-lib";

	public static void d(String s) {
		android.util.Log.d(tag, s);
	}

	public static void d(Throwable t) {
		android.util.Log.d(tag, t.getMessage(), t);
	}

	public static void e(String s) {
		android.util.Log.e(tag, s);
	}

	public static void e(Throwable t) {
		android.util.Log.e(tag, t.getMessage(), t);
	}

	public static void i(String s) {
		android.util.Log.i(tag, s);
	}

	public static void v(String s) {
		android.util.Log.v(tag, s);
	}

	public static void w(String s) {
		android.util.Log.w(tag, s);
	}
}
