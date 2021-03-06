package com.spacewargame.gameactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.spacewargame.R;
import com.spacewargame.gameview.ExitDialog;
import com.spacewargame.gameview.HelpDialog;
import com.spacewargame.gameview.HighScoreDialog;
import com.spacewargame.gameview.OptionsDialog;

public class MenuActivity extends Activity implements OnClickListener {
	TextView mPlayGameTV, mHighScoreTV, mOptionsTV, mHelpTV, mQuitTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_menu);
		mPlayGameTV = (TextView) findViewById(R.id.tv_play_game);
		mHighScoreTV = (TextView) findViewById(R.id.tv_high_score);
		mOptionsTV = (TextView) findViewById(R.id.tv_options);
		mHelpTV = (TextView) findViewById(R.id.tv_help);
		mQuitTV = (TextView) findViewById(R.id.tv_quit);
		Typeface lavaFontFace = Typeface.createFromAsset(getAssets(),
				"fonts/VNTHFAP3.TTF");
		mPlayGameTV.setTypeface(lavaFontFace);
		mPlayGameTV.setOnClickListener(this);
		mHighScoreTV.setTypeface(lavaFontFace);
		mHighScoreTV.setOnClickListener(this);
		mOptionsTV.setTypeface(lavaFontFace);
		mOptionsTV.setOnClickListener(this);
		mHelpTV.setTypeface(lavaFontFace);
		mHelpTV.setOnClickListener(this);
		mQuitTV.setTypeface(lavaFontFace);
		mQuitTV.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_play_game:
			Intent playIntent = new Intent(MenuActivity.this,
					MainActivity.class);
			startActivity(playIntent);
			finish();
			break;
		case R.id.tv_quit:
			ExitDialog dialogQuit = new ExitDialog(MenuActivity.this);
			dialogQuit.show();
			break;
		case R.id.tv_options:
			OptionsDialog dialogOptions = new OptionsDialog(MenuActivity.this);
			dialogOptions.show();
			break;
		case R.id.tv_help:
			HelpDialog helpDialog = new HelpDialog(MenuActivity.this);
			helpDialog.show();
			break;
		case R.id.tv_high_score:
			HighScoreDialog highScoreDialog = new HighScoreDialog(this);
			highScoreDialog.show();
			break;
		default:
			break;
		}

	}
}
