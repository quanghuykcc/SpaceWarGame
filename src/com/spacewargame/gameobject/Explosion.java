package com.spacewargame.gameobject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Explosion extends GameObject {
	private Bitmap mMediumBitmap;
	private Bitmap mBigBitmap;
	private boolean isDone = false;
	private int count = 0;

	public Explosion(float x, float y, Bitmap smallBitmap, Bitmap mediumBitmap,
			Bitmap bigBitmap) {
		this.mX = x;
		this.mY = y;
		this.mBitmap = smallBitmap;
		this.mMediumBitmap = mediumBitmap;
		this.mBigBitmap = bigBitmap;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Canvas canvas) {
		count++;
		if (count < 5) {
			canvas.drawBitmap(mBitmap, mX - mBitmap.getWidth() / 2, mY
					- mBitmap.getHeight() / 2, null);
		} else if (count < 10) {
			canvas.drawBitmap(mMediumBitmap, mX - mMediumBitmap.getWidth() / 2,
					mY - mMediumBitmap.getHeight() / 2, null);
		} else if (count < 15) {
			canvas.drawBitmap(mBigBitmap, mX - mBigBitmap.getWidth() / 2, mY
					- mBigBitmap.getHeight() / 2, null);
		} else if (count < 20) {
			canvas.drawBitmap(mMediumBitmap, mX - mMediumBitmap.getWidth() / 2,
					mY - mMediumBitmap.getHeight() / 2, null);
		} else if (count < 25) {
			canvas.drawBitmap(mBitmap, mX - mBitmap.getWidth() / 2, mY
					- mBitmap.getHeight() / 2, null);
		} else {
			isDone = true;
		}

	}

	public boolean isDone() {
		return isDone;
	}

}
