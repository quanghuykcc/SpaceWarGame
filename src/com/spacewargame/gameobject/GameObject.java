package com.spacewargame.gameobject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class GameObject {
	protected float mX;
	protected float mY;
	protected Bitmap mBitmap;
	protected float mVelocityX = 0.0f;
	protected float mVelocityY = 0.0f;
	protected boolean mIsRender = true;

	public abstract void draw(Canvas canvas);

	public boolean isRender() {
		return mIsRender;
	}

	public void setRender(boolean isRender) {
		this.mIsRender = isRender;
	}

	public float getX() {
		return mX;
	}

	public void setX(float x) {
		this.mX = x;
	}

	public float getY() {
		return mY;
	}

	public void setY(float y) {
		this.mY = y;
	}

	public Bitmap getBitmap() {
		return mBitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.mBitmap = bitmap;
	}

	public float getWidth() {
		return mBitmap.getWidth();
	}

	public float getHeight() {
		return mBitmap.getHeight();
	}

	public float getCenterX() {

		return mX + mBitmap.getWidth() / 2;
	}

	public float getCenterY() {
		return mY + mBitmap.getHeight() / 2;
	}

	public float getVelocityX() {
		return mVelocityX;
	}

	public void setVelocityX(float velocityX) {
		this.mVelocityX = velocityX;
	}

	public float getVelocityY() {
		return mVelocityY;
	}

	public void setVelocityY(float velocityY) {
		this.mVelocityY = velocityY;
	}

	public void setVelocity(float velocityX, float velocityY) {
		this.mVelocityX = velocityX;
		this.mVelocityY = velocityY;
	}

	public void setLocation(float x, float y) {
		this.mX = x;
		this.mY = y;
	}

}
