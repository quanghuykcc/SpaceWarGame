package com.spacewargame.gameobject;

import com.spacewargame.gameview.ScreenSize;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class PausePlayButton extends GameObject {
	private Bitmap mPauseBitmap;
	private boolean mIsPause = false;

	public PausePlayButton(Bitmap playBitmap, Bitmap pauseBitmap) {
		this.mBitmap = playBitmap;
		this.mPauseBitmap = pauseBitmap;
		mX = ScreenSize.getScreenWidth() - 30.0f;
		mY = 1.0f;
	}

	public void setPause(boolean isPause) {
		this.mIsPause = isPause;
	}

	public boolean isPause() {
		return mIsPause;
	}

	@Override
	public void draw(Canvas canvas) {
		if (mIsPause) {
			canvas.drawBitmap(mBitmap, mX, mY, null);
		} else {
			canvas.drawBitmap(mPauseBitmap, mX, mY, null);
		}

	}

}
