package com.spacewargame.gamemanager;

public class ScoreManager {
	private int mScore = 0;
	private int mLife = 3;

	public void increaseScore() {
		mScore++;
	}

	public void reset() {
		mScore = 0;
	}

	public void decreaseLife() {
		mLife--;
	}

	public void increaseLife() {
		mLife++;
	}

	public int getScore() {
		return mScore;
	}

	public int getLife() {
		return mLife;
	}
}
