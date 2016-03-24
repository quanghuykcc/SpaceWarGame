package com.spacewargame.gameobject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bullet extends GameObject {

	public Bullet(Bitmap bitmap) {
		this.mBitmap = bitmap;
	}

	public void initTargetedBullet(float x, float y, float targetX,
			float targetY, float velocity) {
		this.mX = x;
		this.mY = y;
		double angle = (float) Math.atan(((targetX - x) / (targetY - y)));
		this.mVelocityX = (float) (Math.sin(angle) * velocity);
		this.mVelocityY = (float) (Math.cos(angle) * velocity);
	}

	public void initStraightBullet(float x, float y, float velocityY) {
		this.mX = x;
		this.mY = y;
		this.mVelocityY = velocityY;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, mX, mY, null);
		mX += mVelocityX;
		mY += mVelocityY;

	}

}
