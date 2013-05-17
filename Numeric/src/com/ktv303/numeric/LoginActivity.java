package com.ktv303.numeric;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import model.DatabaseHandler;
import model.UserFunctions;

public class LoginActivity extends Activity {
	private ImageButton 		imageButtonGoBack;
	private Button 				buttonRegisterScreen;
	private Button 				buttonLoginScreen;
	private Button				buttonLogin;
	private Button				buttonRegister;
	private Typeface			romansTypeFace;
	private EditText			editTextUsername;
	private EditText			editTextPassword;
	private ProgressDialog		progressDialog;
	private String errorMessage;
	
	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_USERNAME = "username";
	private static String KEY_CREATED_AT = "created_at";
	private static String KEY_HIGHSCORE = "highscore";
	
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
        //  set editTextUsername
        this.editTextUsername = (EditText) findViewById( R.id.editTextUsername );
        //  set editTextPassword
        this.editTextPassword = (EditText) findViewById( R.id.editTextPassword );
        
        
    	romansTypeFace = Typeface.createFromAsset( getAssets(), "fonts/font.ttf" );
		buttonLogin.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonRegister.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonLoginScreen.setTypeface(romansTypeFace, Typeface.BOLD);
		buttonRegisterScreen.setTypeface(romansTypeFace, Typeface.BOLD);
		
        addListenerOnButton();
    }
	
	public void addListenerOnButton()
	{ 
		// add click listener to back button
		imageButtonGoBack.setOnClickListener(new OnClickListener()
			{
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent( getApplicationContext(), MainActivity.class );
				startActivity(i);
				finish();
			}
			});
		// add click listener to login button
		buttonLogin.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				progressDialog = ProgressDialog.show( LoginActivity.this, "", "Gegevens controleren...", true );
                new Thread(new Runnable() {
                	public void run() {
                		login();                          
                	}
                }).start();
			}
		});
		// add click listener to register button
		buttonRegister.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				progressDialog = ProgressDialog.show( LoginActivity.this, "", "Account aanmaken...", true );
                new Thread(new Runnable() {
                	public void run() {
                		register();                          
                	}
                }).start();
			}
		});
		// add click listener to login screen button
		buttonLoginScreen.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				buttonLogin.setVisibility(View.VISIBLE);
				buttonRegister.setVisibility(View.GONE);
				buttonRegisterScreen.setVisibility(View.VISIBLE);
				buttonLoginScreen.setVisibility(View.GONE);
			}
		});
		// add click listener to register screen button
		buttonRegisterScreen.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				buttonLogin.setVisibility(View.GONE);
				buttonRegister.setVisibility(View.VISIBLE);
				buttonRegisterScreen.setVisibility(View.GONE);
				buttonLoginScreen.setVisibility(View.VISIBLE);
			}
		});

	}
	
	private void login()
	{
		String username = this.editTextUsername.getText().toString();
		String password = this.editTextPassword.getText().toString();
		UserFunctions userFunction = new UserFunctions();
		Log.d("Button", "Login");
		JSONObject json = userFunction.loginUser( username, password );
		
		// check for login response
		try {
			if( json.getString(KEY_SUCCESS) != null )
			{
				String res = json.getString(KEY_SUCCESS); 
				if(Integer.parseInt(res) == 1){
					// user successfully logged in
					// Store user details in SQLite Database
					DatabaseHandler db = new DatabaseHandler(getApplicationContext());
					JSONObject json_user = json.getJSONObject("user");
					
					// Clear all previous data in database
					userFunction.logoutUser(getApplicationContext());
					db.addUser(json_user.getString(KEY_USERNAME), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT), json_user.getString(KEY_HIGHSCORE));						
					
					// Launch Dashboard Screen
					//Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
					
					// Close all views before launching Dashboard
					//dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					//startActivity(dashboard);
					
					// Close Login Screen
					Intent i = new Intent( getApplicationContext(), MainActivity.class );
					startActivity(i);
					finish();
				}else{
					// Error in login
					this.errorMessage = json.getString( KEY_ERROR_MSG );
					showAlert();
				}
			}
		} catch( JSONException e ) {
			this.progressDialog.dismiss();
           	Log.v( "Exception", e.getMessage() );
		}
	}
	
	private void register()
	{
		String username = this.editTextUsername.getText().toString();
		String password = this.editTextPassword.getText().toString();
		UserFunctions userFunction = new UserFunctions();
		JSONObject json = userFunction.registerUser( username, password );
		
		try {
			if (json.getString(KEY_SUCCESS) != null) {
				
				String res = json.getString(KEY_SUCCESS); 
				if(Integer.parseInt(res) == 1){
					// user successfully registred
					// Store user details in SQLite Database
					DatabaseHandler db = new DatabaseHandler(getApplicationContext());
					JSONObject json_user = json.getJSONObject("user");
					
					// Clear all previous data in database
					userFunction.logoutUser(getApplicationContext());
					db.addUser(json_user.getString(KEY_USERNAME), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT), json_user.getString(KEY_HIGHSCORE));						
					// Launch Dashboard Screen
					//Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
					// Close all views before launching Dashboard
					//dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					//startActivity(dashboard);
					// Close Registration Screen
					Intent i = new Intent( getApplicationContext(), MainActivity.class );
					startActivity(i);
					finish();
				}else{
					// Error in registration
					this.errorMessage = json.getString( KEY_ERROR_MSG );
					showAlert();
				}
			}
		} catch (JSONException e) {
			this.progressDialog.dismiss();
           	Log.v( "Exception", e.getMessage() );
		}
	}
	

	private void showAlert(){
        LoginActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Oeps!");
                builder.setMessage(errorMessage)
                       .setCancelable(false)
                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                           }
                       });                     
                AlertDialog alert = builder.create();
                alert.show();
                progressDialog.dismiss();
            }
        });
    }
}