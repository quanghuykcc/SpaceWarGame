package com.spacewargame.gameview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;

import com.spacewargame.gamemanager.BitmapManager;
import com.spacewargame.gamemanager.CollisionManager;
import com.spacewargame.gamemanager.ScoreManager;
import com.spacewargame.gamemanager.SoundManager;
import com.spacewargame.gameobject.BluePlane;
import com.spacewargame.gameobject.Bullet;
import com.spacewargame.gameobject.Explosion;
import com.spacewargame.gameobject.GameConstants;
import com.spacewargame.gameobject.Lifes;
import com.spacewargame.gameobject.MainPlane;
import com.spacewargame.gameobject.PausePlayButton;
import com.spacewargame.gameobject.PurplePlane;
import com.spacewargame.gameobject.YellowPlane;
import com.spacewargame.gamethread.MainThread;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
	private MainThread mThread;
	private SoundManager mSoundManager;
	private BitmapManager mBitmapManager;
	private CollisionManager mCollisionManager;
	private ScoreManager mScoreManager;

	// game objects
	private MainPlane mMainPlane;
	private ArrayList<YellowPlane> mYellowPlanes = new ArrayList<YellowPlane>();
	private ArrayList<BluePlane> mBluePlanes = new ArrayList<BluePlane>();
	private ArrayList<PurplePlane> mPurplePlanes = new ArrayList<PurplePlane>();
	private ArrayList<Explosion> mExplosions = new ArrayList<Explosion>();
	private ArrayList<Bullet> mMainBullet = new ArrayList<Bullet>();
	private Lifes mLife;
	private Paint mPaint;
	private PausePlayButton mPausePlayButton;

	private int mAddYellowPlaneTime = 0;
	private int mAddBluePlaneTime = 0;
	private int mAddPurplePlaneTime = 0;
	private int mMainPlaneTimeShoot = 0;
	private boolean mIsStart = false;
	Random rand = new Random();

	public GamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		mThread = new MainThread(getHolder(), this);
		setFocusable(true);

		// create managers of game
		mBitmapManager = new BitmapManager(this.getResources());
		mSoundManager = new SoundManager(context);
		mSoundManager.initSounds();
		mCollisionManager = new CollisionManager();
		mScoreManager = new ScoreManager();

		// create paint to draw custom text
		Typeface lavaFontFace = Typeface.createFromAsset(context.getAssets(),
				"fonts/lava.ttf");
		mPaint = new Paint();
		mPaint.setColor(Color.MAGENTA);
		mPaint.setTypeface(lavaFontFace);
		mPaint.setTextSize(25.0f);

		mLife = new Lifes(mBitmapManager.getLifeBitmap(), mScoreManager);
		mPausePlayButton = new PausePlayButton(mBitmapManager.getPlayBitmap(),
				mBitmapManager.getPauseBitmap());

	}

	public void drawYellowPlanes(Canvas canvas) {
		mAddYellowPlaneTime++;
		if (mAddYellowPlaneTime == GameConstants.ADD_YELLOW_PLANE_TIME_LIMIT) {
			YellowPlane yellowPlane = new YellowPlane(rand.nextInt(this
					.getWidth()), 0, mBitmapManager.getYellowPlaneBitmap(),
					mBitmapManager.getYellowBulletBitmap());
			yellowPlane.setTarget(mMainPlane);
			mYellowPlanes.add(yellowPlane);
			mAddYellowPlaneTime = 0;
		}
		for (int i = 0; i < mYellowPlanes.size(); i++) {
			YellowPlane yellowPlane = mYellowPlanes.get(i);
			yellowPlane.draw(canvas);
			if (yellowPlane.getY() > ScreenSize.getScreenHeight()
					|| (!yellowPlane.isRender() && yellowPlane.getNumBullets() == 0)) {
				mYellowPlanes.remove(i);
			}
		}

	}

	public void drawPurplePlanes(Canvas canvas) {
		mAddPurplePlaneTime++;
		if (mAddPurplePlaneTime == GameConstants.ADD_PURPLE_PLANE_TIME_LIMIT) {
			PurplePlane purplePlane = new PurplePlane(rand.nextInt(this
					.getWidth()), 0, mBitmapManager.getPurplePlaneBitmap(),
					mBitmapManager.getPurpleBulletBitmap());
			mPurplePlanes.add(purplePlane);
			mAddPurplePlaneTime = 0;
		}

		for (int i = 0; i < mPurplePlanes.size(); i++) {
			PurplePlane purplePlane = mPurplePlanes.get(i);
			purplePlane.draw(canvas);
			if (purplePlane.getY() > ScreenSize.getScreenHeight()
					|| (!purplePlane.isRender() && purplePlane.getNumBullets() == 0)) {
				mPurplePlanes.remove(i);
			}
		}
	}

	public void drawExplosions(Canvas canvas) {
		for (int i = 0; i < mExplosions.size(); i++) {
			Explosion explosion = mExplosions.get(i);
			explosion.draw(canvas);
			if (explosion.isDone()) {
				mExplosions.remove(i);
			}
		}

	}

	public void drawBluePlanes(Canvas canvas) {
		mAddBluePlaneTime++;
		if (mAddBluePlaneTime == GameConstants.ADD_BLUE_PLANE_TIME_LIMIT) {
			BluePlane bluePlane = new BluePlane(rand.nextInt(this.getWidth()),
					0, mBitmapManager.getBluePlaneBitmap(),
					mBitmapManager.getBlueBulletBitmap());
			mBluePlanes.add(bluePlane);
			mAddBluePlaneTime = 0;
		}

		for (int i = 0; i < mBluePlanes.size(); i++) {
			BluePlane bluePlane = mBluePlanes.get(i);
			bluePlane.draw(canvas);
			if (bluePlane.getY() > ScreenSize.getScreenHeight()
					|| (!bluePlane.isRender() && bluePlane.getNumBullets() == 0)) {
				mBluePlanes.remove(i);
			}
		}
	}

	public void drawMainBullets(Canvas canvas) {
		mMainPlaneTimeShoot++;
		if (mMainPlaneTimeShoot > GameConstants.MAIN_PLANE_TIMESHOOT_LIMIT) {
			Bullet bullet = new Bullet(mBitmapManager.getBulletBitmap());
			bullet.setLocation(mMainPlane.getCenterX() - bullet.getWidth() / 2,
					mMainPlane.getCenterY());
			bullet.setVelocity(0, -10);
			mMainBullet.add(bullet);
			mSoundManager.playSound(SoundManager.SOUND_SHOOT);
			mMainPlaneTimeShoot = 0;
		}

		for (int i = 0; i < mMainBullet.size(); i++) {
			mMainBullet.get(i).draw(canvas);
			if (mMainBullet.get(i).getY() < 0) {
				mMainBullet.remove(i);
			}
		}

	}

	public boolean onTouchEvent(MotionEvent event) {
		if (!mIsStart) {
			mIsStart = true;
		}
	
		mMainPlane
				.setX((int) (event.getX() - mMainPlane.getBitmap().getWidth() / 2));
		mMainPlane.setY((int) (event.getY() - mMainPlane.getBitmap()
				.getHeight() / 2));
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		if (!mPausePlayButton.isPause()) {
			canvas.drawColor(Color.BLACK);
			mLife.draw(canvas);
			canvas.drawText("" + mScoreManager.getScore(), 10, 20, mPaint);
			if (mMainPlane != null) {
				mMainPlane.draw(canvas);
			}
			if (mIsStart) {
				mPausePlayButton.draw(canvas);
				this.drawMainBullets(canvas);
				this.drawYellowPlanes(canvas);
				this.drawPurplePlanes(canvas);
				this.drawBluePlanes(canvas);
				this.drawExplosions(canvas);
				checkMainBulletsAndEnemiesCollisions();
				checkEnemiesBulletsAndMainPlaneCollisions();
			}
		}
		

	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		Log.d("ScreenSize", "(" + getWidth() + "," + getHeight() + ")");
		ScreenSize.setScreenHeight(this.getHeight());
		ScreenSize.setScreenWidth(this.getWidth());
		mMainPlane = new MainPlane(mBitmapManager.getMainPlaneBitmap());
		mMainPlane.setLocation((getWidth() - mMainPlane.getWidth()) / 2,
				getHeight() - 50);
	}

	private void checkMainBulletsAndEnemiesCollisions() {
		outerloop: for (Bullet bullet : mMainBullet) {
			for (BluePlane bluePlane : mBluePlanes) {
				if (bluePlane.isRender()
						&& mCollisionManager.checkCollision(bluePlane, bullet)) {
					mExplosions.add(new Explosion(bluePlane.getCenterX(),
							bluePlane.getCenterY(), mBitmapManager
									.getSmallExplosionBitmap(), mBitmapManager
									.getMediumExplosionBitmap(), mBitmapManager
									.getBigExplosionBitmap()));
					mMainBullet.remove(bullet);
					bluePlane.setRender(false);
					mSoundManager.playSound(SoundManager.SOUND_DETONATE);
					mScoreManager.increaseScore();
					break outerloop;
				}
			}

			for (PurplePlane purplePlane : mPurplePlanes) {
				if (purplePlane.isRender()
						&& mCollisionManager
								.checkCollision(purplePlane, bullet)) {
					mExplosions.add(new Explosion(purplePlane.getCenterX(),
							purplePlane.getCenterY(), mBitmapManager
									.getSmallExplosionBitmap(), mBitmapManager
									.getMediumExplosionBitmap(), mBitmapManager
									.getBigExplosionBitmap()));
					mMainBullet.remove(bullet);
					purplePlane.setRender(false);
					mSoundManager.playSound(SoundManager.SOUND_DETONATE);
					mScoreManager.increaseScore();
					break outerloop;
				}
			}

			for (YellowPlane yellowPlane : mYellowPlanes) {
				if (yellowPlane.isRender()
						&& mCollisionManager
								.checkCollision(yellowPlane, bullet)) {
					mExplosions.add(new Explosion(yellowPlane.getCenterX(),
							yellowPlane.getCenterY(), mBitmapManager
									.getSmallExplosionBitmap(), mBitmapManager
									.getMediumExplosionBitmap(), mBitmapManager
									.getBigExplosionBitmap()));
					mMainBullet.remove(bullet);
					yellowPlane.setRender(false);
					mSoundManager.playSound(SoundManager.SOUND_DETONATE);
					mScoreManager.increaseScore();
					break outerloop;
				}
			}

		}

	}

	private void checkEnemiesBulletsAndMainPlaneCollisions() {
		for (BluePlane bluePlane : mBluePlanes) {
			ArrayList<Bullet> blueBullets = bluePlane.getBullets();
			for (int i = 0; i < blueBullets.size(); i++) {
				if (mCollisionManager.checkCollision(mMainPlane, blueBullets.get(i))) {
					mScoreManager.decreaseLife();
					if (mScoreManager.getLife() == 0) {
						
					}
					blueBullets.remove(i);
			
				}
			}
		}

		for (YellowPlane yellowPlane : mYellowPlanes) {
			ArrayList<Bullet> yellowBullets = yellowPlane.getBullets();
			for (int i = 0; i < yellowBullets.size(); i++) {
				if (mCollisionManager.checkCollision(mMainPlane, yellowBullets.get(i))) {
					mScoreManager.decreaseLife();
					if (mScoreManager.getLife() == 0) {
						
					}
					yellowBullets.remove(i);
				}
			}
		}

		for (PurplePlane purplePlane : mPurplePlanes) {
			ArrayList<Bullet> purpleBullets = purplePlane.getBullets();
			for (int i = 0; i < purpleBullets.size(); i++) {
				if (mCollisionManager.checkCollision(mMainPlane, purpleBullets.get(i))) {
					mScoreManager.decreaseLife();
					if (mScoreManager.getLife() == 0) {
						
					}
					purpleBullets.remove(i);
				}
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mThread.setRunning(true);
		mThread.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mThread.isAlive()) {
			mThread.setRunning(false);
		}
	}

}
