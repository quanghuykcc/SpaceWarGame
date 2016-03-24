package com.spacewargame.gameactivity;

import com.spacewargame.R;
import com.spacewargame.R.id;
import com.spacewargame.R.layout;
import com.spacewargame.R.menu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HighScoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score);
		SharedPreferences pre = getSharedPreferences("space_war_game_data", MODE_PRIVATE);
		int highScore = pre.getInt("high_score", 0);
		
	}
	
}
