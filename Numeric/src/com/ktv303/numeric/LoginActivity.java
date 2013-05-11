package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class LoginActivity extends Activity {
	private ImageButton imageButtonGoBack;

	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_login );
        
        //  set ImageButtonGoBack
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        
        addListenerOnButton();
    }
	
	public void addListenerOnButton()
	{ 
		// add click listener to back button
		imageButtonGoBack.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
				finish();
			}
			});
	}
}