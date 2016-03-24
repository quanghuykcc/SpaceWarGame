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

public class OptionsDialog extends Dialog implements android.view.View.OnClickListener {
	Activity mParentActivity;
	Button mYesButton;
	TextView mMessage;
	public OptionsDialog(Activity parenActivity) {
		super(parenActivity);
		mParentActivity = parenActivity;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.dialog_options);
	    mYesButton = (Button) findViewById(R.id.btn_yes_op);
	    mMessage = (TextView) findViewById(R.id.txt_dia_op);
	    Typeface lavaFontFace = Typeface.createFromAsset(mParentActivity.getAssets(),
				"fonts/VNTHFAP3.TTF");
	    mYesButton.setTypeface(lavaFontFace);
	    mMessage.setTypeface(lavaFontFace);
	    mYesButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_yes_op:
			dismiss();
			break;
		default:
			break;
		}
		
	}
	
}
