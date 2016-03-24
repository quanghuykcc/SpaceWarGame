package com.spacewargame.gameobject;

import com.spacewargame.gamemanager.ScoreManager;
import com.spacewargame.gameview.ScreenSize;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Lifes extends GameObject {
	ScoreManager mScoreManager;

	public Lifes(Bitmap bitmap, ScoreManager scoreManager) {
		this.mBitmap = bitmap;
		this.mScoreManager = scoreManager;
	}

	@Override
	public void draw(Canvas canvas) {
		float x = ScreenSize.getScreenWidth() - 70.0f;
		for (int i = 0; i < mScoreManager.getLife(); i++) {
			canvas.drawBitmap(mBitmap, x, 30.0f, null);
			x -= 90.0f;
		}

	}

}
