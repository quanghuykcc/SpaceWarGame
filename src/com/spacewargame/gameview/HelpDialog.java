package com.spacewargame.gameview;

import com.spacewargame.R;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelpDialog extends Dialog implements OnClickListener {
	Activity mParentActivity;
	Button mYesButton;
	TextView mMessage;
	public HelpDialog(Activity parentActivity) {
		super(parentActivity);
		mParentActivity = parentActivity;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.dialog_help);
	    mYesButton = (Button) findViewById(R.id.btn_ok_help);
	    mMessage = (TextView) findViewById(R.id.txt_help_message);
	    Typeface tfFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    Typeface lavaFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/lava.ttf");
	    mYesButton.setTypeface(lavaFontFace);
	    mMessage.setTypeface(tfFontFace);
	    mYesButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_ok_help:
			dismiss();
			break;
		default:
			break;
		}
		
	}
}
