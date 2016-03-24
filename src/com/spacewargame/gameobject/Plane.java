package com.spacewargame.gameobject;

import java.util.ArrayList;

import android.graphics.Bitmap;

public abstract class Plane extends GameObject {
	protected ArrayList<Bullet> mBullets;
	protected Bitmap mBulletBitmap;
	protected int mNumBullets = 0;
	protected int mTimeShoot = 0;

	public ArrayList<Bullet> getBullets() {
		return mBullets;
	}

	public int getNumBullets() {
		return mNumBullets;
	}

}
