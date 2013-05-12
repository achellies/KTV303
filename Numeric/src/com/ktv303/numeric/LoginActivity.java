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

public class LoginActivity extends Activity {
	private ImageButton imageButtonGoBack;
	private ImageButton imageButtonRegisterScreen;
	private Button		buttonLogin;
	private Button		buttonRegister;
	private Typeface	romansTypeFace;
	


	
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.activity_login );
        
        //  set imageButtonGoBack
        imageButtonGoBack = (ImageButton) findViewById( R.id.imageButtonGoBack );
        //  set buttonViewLogin
        buttonLogin = (Button) findViewById( R.id.buttonLogin );
        //  set buttonRegister
        buttonRegister = (Button) findViewById( R.id.buttonRegister );
        //  set imageButtonRegisterScreen
        imageButtonRegisterScreen = (ImageButton) findViewById( R.id.imageButtonRegisterScreen );
        
    	romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
		buttonLogin.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonRegister.setTypeface(romansTypeFace, Typeface.BOLD);
        
        // set txtViewRegister to invisible
		buttonRegister.setVisibility(buttonRegister.GONE);
        
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
		// add click listener to register button
		buttonRegister.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
				finish();
					}
			});
		// add click listener to register screen button
		imageButtonRegisterScreen.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
					buttonLogin.setVisibility(View.GONE);
					buttonRegister.setVisibility(View.VISIBLE);
					}
			});

	}
}