package com.spacewargame.gameobject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class MainPlane extends GameObject {

	public MainPlane(Bitmap bitmap) {
		this.mBitmap = bitmap;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, mX, mY, null);
	}

}
