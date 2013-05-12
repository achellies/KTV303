package com.ktv303.numeric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends Activity {
	private ImageButton imageButtonGoBack;
	private ImageButton imageButtonLogin;
	private ImageButton imageButtonRegister;
	private ImageButton imageButtonRegisterScreen;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_login );
        
        //  set imageButtonGoBack
        this.imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        //  set imageButtonLogin
        this.imageButtonLogin = (ImageButton) findViewById( R.id.imageButtonLogin );
        //  set imageButtonRegister
        this.imageButtonRegister = (ImageButton) findViewById( R.id.imageButtonRegister );
        //  set imageButtonRegisterScreen
        this.imageButtonRegisterScreen = (ImageButton) findViewById( R.id.imageButtonRegisterScreen );

        
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
		imageButtonLogin.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
				finish();
					}
			});
		// add click listener to register button
		imageButtonRegister.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
					}
			});
		// add click listener to register screen button
		imageButtonRegisterScreen.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
					}
			});

	}
}