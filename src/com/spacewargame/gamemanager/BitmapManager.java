package com.spacewargame.gamemanager;

import com.spacewargame.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapManager {
	private Bitmap mBulletBitmap;
	private Bitmap mYellowPlaneBitmap;
	private Bitmap mPurplePlaneBitmap;
	private Bitmap mBluePlaneBitmap;
	private Bitmap mMainPlaneBitmap;
	private Bitmap mPurpleBulletBitmap;
	private Bitmap mYellowBulletBitmap;
	private Bitmap mBlueBulletBitmap;
	private Bitmap mSmallExplosionBitmap;
	private Bitmap mMediumExplosionBitmap;
	private Bitmap mBigExplosionBitmap;
	private Bitmap mLifeBitmap;

	public BitmapManager(Resources resources) {
		mBulletBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.bullet);
		mYellowPlaneBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.plane_yellow);
		mPurplePlaneBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.plane_purple);
		mBluePlaneBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.plane_blue);
		mMainPlaneBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.plane_main);
		mPurpleBulletBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.bullet_purple);
		mBlueBulletBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.bullet_blue);
		mYellowBulletBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.bullet_yellow);
		mSmallExplosionBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.fire_small);
		mMediumExplosionBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.fire_medium);
		mBigExplosionBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.fire_big);
		mLifeBitmap = BitmapFactory.decodeResource(resources,
				R.drawable.plane_life);
	}

	public Bitmap getLifeBitmap() {
		return mLifeBitmap;
	}

	public Bitmap getBlueBulletBitmap() {
		return mBlueBulletBitmap;
	}

	public Bitmap getYellowBulletBitmap() {
		return mYellowBulletBitmap;
	}

	public Bitmap getPurpleBulletBitmap() {
		return mPurpleBulletBitmap;
	}

	public Bitmap getBulletBitmap() {
		return mBulletBitmap;
	}

	public Bitmap getYellowPlaneBitmap() {
		return mYellowPlaneBitmap;
	}

	public Bitmap getBluePlaneBitmap() {
		return mBluePlaneBitmap;
	}

	public Bitmap getMainPlaneBitmap() {
		return mMainPlaneBitmap;
	}

	public Bitmap getPurplePlaneBitmap() {
		return mPurplePlaneBitmap;
	}

	public Bitmap getSmallExplosionBitmap() {
		return mSmallExplosionBitmap;
	}

	public Bitmap getMediumExplosionBitmap() {
		return mMediumExplosionBitmap;
	}

	public Bitmap getBigExplosionBitmap() {
		return mBigExplosionBitmap;
	}

}
