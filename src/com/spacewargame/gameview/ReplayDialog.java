package com.spacewargame.gameview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.spacewargame.R;
import com.spacewargame.gameactivity.MainActivity;
import com.spacewargame.gameactivity.MenuActivity;

public class ReplayDialog extends Dialog implements OnClickListener {
	Activity mParentActivity;
	ImageButton mMenuButton, mReplayButton;
	TextView mScoreText, mMessageText;
	int mScore;
	public ReplayDialog(Activity parentActivity, int score) {
		super(parentActivity);
		mParentActivity = parentActivity;
		mScore = score;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.dialog_replay);
	    mMenuButton = (ImageButton) findViewById(R.id.imgbt_menu);
	    mReplayButton = (ImageButton) findViewById(R.id.imgbt_replay);
	    
	    mScoreText = (TextView) findViewById(R.id.txt_score);
	    mMessageText = (TextView) findViewById(R.id.txt_message);
	    mScoreText.setText(mScore + "");
	    SharedPreferences pre = mParentActivity.getSharedPreferences("space_war_game_data", mParentActivity.MODE_PRIVATE);
		int highScore = pre.getInt("high_score", 0);
		if (mScore > highScore) {
			mMessageText.setText("High score:");
			SharedPreferences.Editor editor = pre.edit();
			editor.putInt("high_score", mScore);
			editor.commit();
		}
		else {
			mMessageText.setText("Your score:");
		}
	    
	    
	    Typeface tfFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    Typeface lavaFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/lava.ttf");
	    mScoreText.setTypeface(lavaFontFace);
	    mMessageText.setTypeface(tfFontFace);
	    mMenuButton.setOnClickListener(this);
	    mReplayButton.setOnClickListener(this);
	    setCanceledOnTouchOutside(false);
	    setCancelable(false);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgbt_menu:
			Intent menuIntent = new Intent(mParentActivity, MenuActivity.class);
			mParentActivity.startActivity(menuIntent);
			mParentActivity.finish();
			break;
		case R.id.imgbt_replay:
			Intent gameActivity = new Intent(mParentActivity, MainActivity.class);
			mParentActivity.startActivity(gameActivity);
			mParentActivity.finish();
			break;
		default:
			break;
		}
		
	}

}
