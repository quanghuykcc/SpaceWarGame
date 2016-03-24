package com.spacewargame.gameview;

import com.spacewargame.R;
import com.spacewargame.gameactivity.MainActivity;
import com.spacewargame.gameactivity.MenuActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReplayDialog extends Dialog implements OnClickListener {
	Activity mParentActivity;
	ImageButton mMenuButton, mReplayButton;
	TextView mScoreText, mMessageText;
	public ReplayDialog(Activity parentActivity) {
		super(parentActivity);
		mParentActivity = parentActivity;
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
	    Typeface tfFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    mScoreText.setTypeface(tfFontFace);
	    mMessageText.setTypeface(tfFontFace);
	    mMenuButton.setOnClickListener(this);
	    mReplayButton.setOnClickListener(this);
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
