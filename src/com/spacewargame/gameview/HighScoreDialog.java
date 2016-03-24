package com.spacewargame.gameview;

import com.spacewargame.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HighScoreDialog extends Dialog implements android.view.View.OnClickListener {
	Activity mParentActivity;
	Button mOkButton;
	TextView mScoreText;
	TextView mMessage;
	public HighScoreDialog(Activity parentActivity) {
		super(parentActivity);
		mParentActivity = parentActivity;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.dialog_highscore);
	    mOkButton = (Button) findViewById(R.id.btn_ok);  
	    mScoreText = (TextView) findViewById(R.id.txt_score); 
	    mMessage = (TextView) findViewById(R.id.txt_message);
	    SharedPreferences pre = mParentActivity.getSharedPreferences("space_war_game_data", mParentActivity.MODE_PRIVATE);
		int highScore = pre.getInt("high_score", 0);
		 mScoreText.setText(highScore + "");
	    Typeface tfFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    Typeface lavaFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/lava.ttf");
	    mOkButton.setTypeface(lavaFontFace);
	    mScoreText.setTypeface(lavaFontFace);	
	    mMessage.setTypeface(tfFontFace);
	    mOkButton.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_ok:
			dismiss();
			break;

		default:
			break;
		}
		
	}

}
