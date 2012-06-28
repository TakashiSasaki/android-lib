package com.gmail.takashi316.lib.android.filesystem;

import java.io.File;
import java.io.IOException;
import android.graphics.Bitmap;
import com.gmail.takashi316.lib.android.graphics.BitmapFactory;
import com.gmail.takashi316.lib.filesystem.ImageFile;

/**
 * AndroidImageFile implements ImageFile.
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 * 
 */
@SuppressWarnings("serial")
public class AndroidImageFile extends ImageFile<Bitmap> {

	@SuppressWarnings("javadoc")
	public AndroidImageFile(String pathname) throws IOException {
		super(pathname);
	}// a constructor

	public AndroidImageFile(File parent, String child) throws IOException {
		super(parent, child);
	}// a constructor

	@Override
	protected void getSize() throws IOException {
		Bitmap bitmap = this.getImage();
		if (bitmap != null) {
			this.width = bitmap.getWidth();
			this.height = bitmap.getHeight();
			bitmap.recycle();
		}// if
	}// getSize

	@Override
	public Bitmap getImage() throws IOException {
		BitmapFactory bitmap_factory = new BitmapFactory();
		bitmap_factory.loadFile(this);
		if (bitmap_factory.get() != null) {
			return bitmap_factory.get();
		} else {
			throw new IOException("can't load bitmap from image file "
					+ this.getName());
		}// if
	}// getImgae

	@Override
	public Bitmap getResizedImage(int target_width, int target_height)
			throws IOException {
		BitmapFactory bitmap_factory = new BitmapFactory();
		bitmap_factory.loadBitmap(this.getImage());
		bitmap_factory.resize(target_width, target_height);
		return bitmap_factory.get();
	}// getResizeImage
}// AndroidImageFile
