package com.ktv303.numeric;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity
{
	// immageButtonMenuOmzetten
	ImageButton imageButtonMenuOmzetten;
	// imageButtonMenuOpVolgorde
	ImageButton imageButtonMenuOpVolgorde;
	// imageButtonMenuLogin
	ImageButton imageButtonMenuLogin;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOnButton();
    }
    
    public void addListenerOnButton()
    {
    	// find imageButtonMenuOmzetten
		imageButtonMenuOmzetten = (ImageButton) findViewById( R.id.imageButtonMenuOmzetten );
		// set OnClickListener to imageButtonMenuOmzetten
		imageButtonMenuOmzetten.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity omzettenScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent omzettenScreen = new Intent( getApplicationContext(), OmzettenActivity.class );
				omzettenScreen.putExtra( "highscore", 0 );
				omzettenScreen.putExtra( "gameCount", 0 );
				omzettenScreen.putIntegerArrayListExtra( "combiAlreadyAnswered", new ArrayList<Integer>()  );
				startActivity( omzettenScreen );
			}
			
		});
		
		// find imageButtonMenuOpVolgorde
		imageButtonMenuOpVolgorde = (ImageButton) findViewById( R.id.imageButtonMenuOpVolgorde );
		// set onClickListener to imageButtonMenuOpVolgorde
		imageButtonMenuOpVolgorde.setOnClickListener( new OnClickListener()
		{
			// set OnClick that starts activity opVolgordeScreen
			@Override
			public void onClick( View arg0 )
			{
				Intent opVolgordeScreen = new Intent( getApplicationContext(), OpVolgordeActivity.class );
				opVolgordeScreen.putExtra( "highscore", 0 );
				opVolgordeScreen.putExtra( "gameCount", 0 );
				opVolgordeScreen.putIntegerArrayListExtra( "combiAlreadyAnswered", new ArrayList<Integer>()  );
				startActivity( opVolgordeScreen );
			}
		});
		
		
		// find imageButtonMenuLogin
		imageButtonMenuLogin = (ImageButton) findViewById( R.id.imageButtonMenuLogin );
		// set OnClickListener to imageButtonMenuLogin
		imageButtonMenuLogin.setOnClickListener( new OnClickListener()
				{
					// set OnClick that starts activity omzettenScreen
					@Override
					public void onClick( View arg0 )
					{
						Intent loginScreen = new Intent( getApplicationContext(), LoginActivity.class );
						startActivity( loginScreen );
					}
					
				});
		
	}
    
}
