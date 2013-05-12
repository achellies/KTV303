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
	private Button 		buttonRegisterScreen;
	private Button 		buttonLoginScreen;
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
        //  set buttonRegisterScreen
        buttonRegisterScreen = (Button) findViewById( R.id.buttonRegisterScreen );
        //  set buttonLoginScreen
        buttonLoginScreen = (Button) findViewById( R.id.buttonLoginScreen );
        
    	romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
		buttonLogin.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonRegister.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonLoginScreen.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonRegisterScreen.setTypeface(romansTypeFace, Typeface.BOLD);
        
        // set txtViewRegister to invisible
		buttonRegister.setVisibility(buttonRegister.GONE);
		buttonLoginScreen.setVisibility(buttonLoginScreen.GONE);
        
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
		buttonLoginScreen.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
					buttonLogin.setVisibility(View.VISIBLE);
					buttonRegister.setVisibility(View.GONE);
					buttonLoginScreen.setVisibility(View.GONE);
					buttonRegisterScreen.setVisibility(View.VISIBLE);
					
					}
			});
		// add click listener to register screen button
		buttonRegisterScreen.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
					buttonLogin.setVisibility(View.GONE);
					buttonRegister.setVisibility(View.VISIBLE);
					buttonLoginScreen.setVisibility(View.VISIBLE);
					buttonRegisterScreen.setVisibility(View.GONE);
					}
			});

	}
}