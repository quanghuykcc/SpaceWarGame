package com.spacewargame.gameactivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.spacewargame.R;

public class HighScoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score);
		SharedPreferences pre = getSharedPreferences("space_war_game_data", MODE_PRIVATE);
		int highScore = pre.getInt("high_score", 0);
		
	}
	
}
