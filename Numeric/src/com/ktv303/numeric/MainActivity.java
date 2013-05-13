package com.ktv303.numeric;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import model.UserFunctions;

public class MainActivity extends Activity
{
	// immageButtonMenuOmzetten
	private ImageButton imageButtonMenuOmzetten;
	// imageButtonMenuOpVolgorde
	private ImageButton imageButtonMenuOpVolgorde;
	// imageButtonMenuLogin
	private ImageButton imageButtonMenuLogin;
	// imageButtonMenuLogoff
	private ImageButton imageButtonMenuLogoff;
	// imageButtonMenuHigscore
	private ImageButton imageButtonMenuHighscore;
	//  TextView textViewHighScore
	private TextView textViewHighScore;
	//  userFunctions
	private UserFunctions userFunctions;
	//  int highScore
	private int highScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.userFunctions = new UserFunctions();
        //this.userFunctions.logoutUser( getApplicationContext() );
        
        // find imageButtonMenuOmzetten
        this.imageButtonMenuOmzetten = (ImageButton) findViewById( R.id.imageButtonMenuOmzetten );
        // find imageButtonMenuOpVolgorde
     	this.imageButtonMenuOpVolgorde = (ImageButton) findViewById( R.id.imageButtonMenuOpVolgorde );
     	// find imageButtonMenuLogin
     	this.imageButtonMenuLogin = (ImageButton) findViewById( R.id.imageButtonMenuLogin );
     	// find imageButtonMenuLogoff
     	this.imageButtonMenuLogoff = (ImageButton) findViewById( R.id.imageButtonMenuLogoff );
     	// find imageButtonMenuHighscore
     	this.imageButtonMenuHighscore = (ImageButton) findViewById( R.id.imageButtonMenuHighscore );
     	// find textViewHighScore
     	this.textViewHighScore = (TextView) findViewById( R.id.textViewHighScore );
        
        if( this.userFunctions.isUserLoggedIn( getApplicationContext() ) )
        {
        	this.highScore = this.userFunctions.getUserHighScore( getApplicationContext() );
        	this.textViewHighScore.setText( "Highscore\n" + String.valueOf( this.highScore ) );
        	this.imageButtonMenuLogoff.setVisibility(View.VISIBLE);
        	this.imageButtonMenuLogin.setVisibility(View.GONE);
        }
        
        addListenerOnButton();
    }
    
    public void addListenerOnButton()
    {
		// set OnClickListener to imageButtonMenuOmzetten
		imageButtonMenuOmzetten.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity omzettenScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent omzettenScreen = new Intent( getApplicationContext(), OmzettenActivity.class );
				omzettenScreen.putExtra( "gameCount", 0 );
				omzettenScreen.putIntegerArrayListExtra( "combiAlreadyAnswered", new ArrayList<Integer>()  );
				omzettenScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity( omzettenScreen );
				finish();
			}
			
		});
		
		// set onClickListener to imageButtonMenuOpVolgorde
		imageButtonMenuOpVolgorde.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity opVolgordeScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent opVolgordeScreen = new Intent( getApplicationContext(), OpVolgordeActivity.class );
				opVolgordeScreen.putExtra( "gameCount", 0 );
				opVolgordeScreen.putIntegerArrayListExtra( "combiAlreadyAnswered", new ArrayList<Integer>()  );
				opVolgordeScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity( opVolgordeScreen );
				finish();
			}
		});
		
		// set OnClickListener to imageButtonMenuLogin
		imageButtonMenuLogin.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity omzettenScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent loginScreen = new Intent( getApplicationContext(), LoginActivity.class );
				loginScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity( loginScreen );
				finish();
			}
			
		});
		
		// set OnClickListener to imageButtonMenuLogoff
		imageButtonMenuLogoff.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity omzettenScreen
			@Override
			public void onClick( View arg0 )
			{
				userFunctions.logoutUser( getApplicationContext() );
				startActivity( MainActivity.this.getIntent() );
				finish();
			}
			
		});
		
		// set OnClickListener to imageButtonMenuLogoff
		imageButtonMenuHighscore.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity omzettenScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent highscoreScreen = new Intent( getApplicationContext(), HighscoreActivity.class );
				highscoreScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity( highscoreScreen );
				finish();
			}
			
		});
		
	}
    
}
