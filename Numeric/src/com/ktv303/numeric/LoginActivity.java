package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends Activity {
	private ImageButton imageButtonGoBack;
	private Button buttonLogin;

	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_login );
        
        //  set imageButtonGoBack
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        //  set buttonLogin
        this.buttonLogin = (Button) findViewById( R.id.buttonLogin );

        
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
		// add click listener to login button
		buttonLogin.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
				finish();
					}
			});
	}
}