package com.spacewargame.gameactivity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.spacewargame.R;

public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		TextView help = (TextView) findViewById(R.id.help_string);
		Typeface lavaFontFace = Typeface.createFromAsset(getAssets(),
				"fonts/TAHOMA.TTF");
		help.setTypeface(lavaFontFace);
		 ActionBar actionBar = getActionBar();
	     actionBar.setTitle("Help");
	     actionBar.setIcon(R.drawable.help);
	     actionBar.setDisplayHomeAsUpEnabled(true);
		
	}
}
