package com.ktv303.numeric;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class HighscoreActivity extends Activity
{
	private ImageButton imageButtonGoBack;
	private Typeface	romansTypeFace;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView( R.layout.activity_highscore);
		
		//Set imageButtonGoBack
		imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack);
		
		addListenerOnButton();
	}
	
	public void addListenerOnButton()
	{
		// add click listener to back button
		imageButtonGoBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				finish();
			}
		});
	}
}
