package com.spacewargame.gameobject;

import java.util.ArrayList;

import com.spacewargame.gameview.ScreenSize;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class YellowPlane extends Plane {
	private MainPlane mTarget;

	public YellowPlane(float x, float y, Bitmap planeBitmap,
			Bitmap bulletBitmap) {
		this.mX = x;
		this.mY = y;
		this.mBitmap = planeBitmap;
		this.mBulletBitmap = bulletBitmap;
		mBullets = new ArrayList<Bullet>();
		mVelocityY = GameConstants.YELLOW_PLANE_VELOCITY_Y;
	}

	public void setTarget(MainPlane target) {
		this.mTarget = target;
	}

	@Override
	public void draw(Canvas canvas) {
		if (mIsRender) {
			canvas.drawBitmap(mBitmap, mX, mY, null);
			mTimeShoot++;
			if (mTimeShoot == GameConstants.YELLOW_PLANE_TIMESHOOT_LIMIT) {
				Bullet bullet = new Bullet(mBulletBitmap);
				bullet.initTargetedBullet(this.getCenterX() - bullet.getWidth()
						/ 2, this.getCenterY(), mTarget.getCenterX(),
						mTarget.getCenterY(),
						GameConstants.YELLOW_PLANE_BULLET_VELOCITY);
				mBullets.add(bullet);
				mNumBullets += 1;
				mTimeShoot = 0;
			}
		}

		for (int i = 0; i < mBullets.size(); i++) {
			mBullets.get(i).draw(canvas);
			if (mBullets.get(i).getY() > ScreenSize.getScreenHeight()) {
				mBullets.remove(i);
				mNumBullets -= 1;
			}
		}

		mY += mVelocityY;
	}

}
