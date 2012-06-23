package com.gmail.takashi316.lib.android.graphics;

import java.io.File;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapFactory extends android.graphics.BitmapFactory {
	private Bitmap bitmap;

	public void loadResource(Context context, int drawable_id) {
		Resources resources = context.getResources();
		Options options = new Options();
		options.inPurgeable = true;
		options.inPreferredConfig = Bitmap.Config.RGB_565;
		this.bitmap = decodeResource(resources, drawable_id, options);
	}// LoadResource

	public Bitmap get() {
		return this.bitmap;
	}// get

	public void recycle() {
		if (this.bitmap != null) {
			this.bitmap.recycle();
			this.bitmap = null;
		}
	}// recyecle

	public void loadFile(File file_) {
		Options options = new Options();
		options.inPurgeable = true;
		options.inPreferredConfig = Bitmap.Config.RGB_565;
		this.bitmap = decodeFile(file_.getPath(), options);
	}// loadFile

	public void resize(int width, int height) {
		final int original_height = this.bitmap.getHeight();
		final int original_width = this.bitmap.getWidth();
		final float height_scale = height / (float) original_height;
		final float width_scale = width / (float) original_width;
		Matrix resize_matrix = new Matrix();
		resize_matrix.postScale(width_scale, height_scale);
		Bitmap resized_bitmap = Bitmap.createBitmap(this.bitmap, 0, 0,
				original_width, original_height, resize_matrix, true);
		this.bitmap = resized_bitmap;
	}// resize

}// BitmapFactory
