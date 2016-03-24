package com.spacewargame.gameobject;

import java.util.ArrayList;

import com.spacewargame.gameview.ScreenSize;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class BluePlane extends Plane {
	public BluePlane(float x, float y, Bitmap planeBitmap, Bitmap bulletBitmap) {
		this.mX = x;
		this.mY = y;
		this.mBitmap = planeBitmap;
		this.mBulletBitmap = bulletBitmap;
		mBullets = new ArrayList<Bullet>();
		mVelocityY = GameConstants.BLUE_PLANE_VELOCITY_Y;
	}

	@Override
	public void draw(Canvas canvas) {
		if (mIsRender) {
			canvas.drawBitmap(mBitmap, mX, mY, null);			
			mTimeShoot++;
			if (mTimeShoot == GameConstants.BLUE_PLANE_TIMESHOOT_LIMIT) {
				Bullet bullet = new Bullet(mBulletBitmap);
				bullet.setLocation(this.getCenterX() - bullet.getWidth() / 2,
						this.getCenterY());
				bullet.setVelocity(0.0f,
						GameConstants.BLUE_PLANE_BULLET_VELOCITYY);
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
