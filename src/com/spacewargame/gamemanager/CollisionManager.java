package com.spacewargame.gamemanager;

import com.spacewargame.gameobject.GameObject;

public class CollisionManager {
	public CollisionManager() {
		// TODO Auto-generated constructor stub
	}

	private float calculateDistance(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public boolean checkCollision(GameObject gameObject1, GameObject gameObject2) {
		// distance between two center
		float distanceBetweenCenters = calculateDistance(
				gameObject1.getCenterX(), gameObject1.getCenterY(),
				gameObject2.getCenterX(), gameObject2.getCenterY());

		// summary of two radius
		float sumRadiuses = (gameObject1.getWidth() + gameObject2.getWidth()) / 2;
		if (distanceBetweenCenters < sumRadiuses) {
			return true;
		} else {
			return false;
		}

	}

}
