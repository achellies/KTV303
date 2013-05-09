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
	ImageButton imageButtonMenuOmzetten;
	ImageButton imageButtonMenuOpVolgorde;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOnButton();
    }
    
    public void addListenerOnButton()
    {
    	 
		imageButtonMenuOmzetten = (ImageButton) findViewById( R.id.imageButtonMenuOmzetten );
 
		imageButtonMenuOmzetten.setOnClickListener( new OnClickListener()
		{
			
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
		
		imageButtonMenuOpVolgorde = (ImageButton) findViewById( R.id.imageButtonMenuOpVolgorde );
		
		imageButtonMenuOpVolgorde.setOnClickListener( new OnClickListener()
		{
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
		
	}
    
}
