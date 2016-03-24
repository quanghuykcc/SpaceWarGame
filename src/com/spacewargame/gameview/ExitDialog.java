package com.spacewargame.gameview;

import com.spacewargame.R;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ExitDialog extends Dialog implements android.view.View.OnClickListener {
	Activity mParentActivity;
	Button mYesButton, mNoButton;
	TextView mMessage;
	public ExitDialog(Activity parenActivity) {
		super(parenActivity);
		mParentActivity = parenActivity;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.dialog_exit);
	    mYesButton = (Button) findViewById(R.id.btn_yes);
	    mNoButton = (Button) findViewById(R.id.btn_no);
	    mMessage = (TextView) findViewById(R.id.txt_dia);
	    Typeface tfFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    Typeface lavaFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/lava.ttf");
	    mYesButton.setTypeface(lavaFontFace);
	    mNoButton.setTypeface(lavaFontFace);
	    mMessage.setTypeface(tfFontFace);
	    mYesButton.setOnClickListener(this);
	    mNoButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_yes:
			dismiss();
			mParentActivity.finish();
			break;
		case R.id.btn_no:
			dismiss();
			break;
		default:
			break;
		}
		
	}
	
}
